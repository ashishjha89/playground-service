package aj.random.playground.user.model

import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*

@Suppress("unused")
@JsonInclude(JsonInclude.Include.NON_NULL)
data class User(
        val id: String,
        val name: UserName,
        val birthDate: Date,
        val hobby: List<String> = listOf(),
        val anniversaryDate: Date? = null,
        val partnerId: String? = null,
        val childrenIds: List<String>? = null,
        val siblingIds: List<String>? = null
) {
    val isEngaged = !partnerId.isNullOrBlank()

    val isParent = !childrenIds.isNullOrEmpty()

    val needALife = hobby.isEmpty()
}

@Suppress("unused")
@JsonInclude(JsonInclude.Include.NON_NULL)
data class UserName(val firstName: String, val lastName: String, val nickName: String? = null) {
    val fullName = "$firstName $lastName"
}