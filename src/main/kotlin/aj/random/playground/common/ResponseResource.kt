package aj.random.playground.common

import aj.random.playground.common.ErrorCode.SOMETHING_WENT_WRONG
import aj.random.playground.common.ErrorMessage.somethingWentWrong
import org.springframework.http.HttpStatus

data class Resource<out T>(val httpStatus: HttpStatus,
                           val status: ResourceStatus,
                           val data: T?,
                           val errorBody: ErrorBody? = null) {
    companion object {

        fun <T> success(httpCode: HttpStatus = HttpStatus.OK, data: T) =
                Resource(httpStatus = httpCode, status = ResourceStatus.SUCCESS, data = data)

        fun <T> error(httpStatus: HttpStatus, errorBody: ErrorBody, data: T? = null) =
                Resource(httpStatus = httpStatus, status = ResourceStatus.ERROR, errorBody = errorBody, data = data)
    }
}

enum class ResourceStatus {
    SUCCESS,
    ERROR
}

data class ErrorBody(val errorCode: String = SOMETHING_WENT_WRONG, val errorMessage: String = somethingWentWrong)