package aj.random.playground.user.repo.constants

import aj.random.playground.user.model.User
import aj.random.playground.user.model.UserName
import java.text.SimpleDateFormat

private val ashishJha = User(
        id = ashishJhaUserId,
        name = UserName(firstName = "Ashish", lastName = "Jha", nickName = "Anku"),
        birthDate = generateDate(dateStr = "16/07/1989"),
        hobby = listOf("TV & Movies", "PS4", "Planning", "Cooking", "Politics"),
        anniversaryDate = generateDate(dateStr = "24/11/2016"),
        partnerId = shobhnaSinhaUserId,
        siblingIds = listOf(manishaAnandUserId, raginiJhaUserId)
)

private val shobhna = User(
        id = shobhnaSinhaUserId,
        name = UserName(firstName = "Shobhna", lastName = "Sinha", nickName = "Mona"),
        birthDate = generateDate(dateStr = "26/11/1988"),
        hobby = listOf("TV & Movies", "Resting", "Politics"),
        anniversaryDate = generateDate(dateStr = "24/11/2016"),
        partnerId = ashishJhaUserId
)

private val sunil = User(
        id = sunilAnandUserId,
        name = UserName(firstName = "Sunil", lastName = "Anand"),
        birthDate = generateDate(dateStr = "29/08/1976"),
        hobby = listOf(),
        anniversaryDate = generateDate(dateStr = "05/12/2005"),
        partnerId = manishaAnandUserId,
        childrenIds = listOf(anahatMudgalUserId, anaagatMudgalUserId)
)

private val manisha = User(
        id = manishaAnandUserId,
        name = UserName(firstName = "Manisha", lastName = "Anand", nickName = "Soni"),
        birthDate = generateDate(dateStr = "14/02/1981"),
        hobby = listOf("Cooking", "Reading", "Sketching & Painting"),
        anniversaryDate = generateDate(dateStr = "05/12/2005"),
        partnerId = sunilAnandUserId,
        childrenIds = listOf(anahatMudgalUserId, anaagatMudgalUserId)
)

private val anahat = User(
        id = anahatMudgalUserId,
        name = UserName(firstName = "Anahat", lastName = "Mudgal"),
        birthDate = generateDate(dateStr = "23/12/2008"),
        hobby = listOf("XBox", "Lego", "Painting", "Programming", "Composing & Playing music"),
        siblingIds = listOf(anaagatMudgalUserId)
)

private val anaagat = User(
        id = anaagatMudgalUserId,
        name = UserName(firstName = "Anaagat", lastName = "Mudgal"),
        birthDate = generateDate(dateStr = "14/02/2014"),
        hobby = listOf("XBox", "Lego", "Playing"),
        siblingIds = listOf(anahatMudgalUserId)
)

private val ashishKumar =  User(
        id = ashishKumarUserId,
        name = UserName(firstName = "Ashish", lastName = "Kumar"),
        birthDate = generateDate(dateStr = "11/08/1980"),
        hobby = listOf("Movies", "Cricket", "Listening Music"),
        anniversaryDate = generateDate(dateStr = "08/05/2009"),
        partnerId = raginiJhaUserId,
        childrenIds = listOf(atharvaKashyapUserId, arikaJhaUserId)
)

private val raginiJha =  User(
        id = raginiJhaUserId,
        name = UserName(firstName = "Ragini", lastName = "Jha", nickName = "Moni"),
        birthDate = generateDate(dateStr = "02/02/1983"),
        hobby = listOf("Swimming", "Shopping", "Socializing", "TV", "Eating", "Make up"),
        anniversaryDate = generateDate(dateStr = "08/05/2009"),
        partnerId = ashishKumarUserId,
        childrenIds = listOf(atharvaKashyapUserId, arikaJhaUserId)
)

private val atharva = User(
        id = atharvaKashyapUserId,
        name = UserName(firstName = "Atharva", lastName = "Kashyap", nickName = "Gudru"),
        birthDate = generateDate(dateStr = "14/04/2014"),
        hobby = listOf("Skating", "Swimming", "Cycling", "Playing"),
        siblingIds = listOf(arikaJhaUserId)
)

private val arika = User(
        id = arikaJhaUserId,
        name = UserName(firstName = "Arika", lastName = "Jha", nickName = "Shivi"),
        birthDate = generateDate(dateStr = "19/07/2018"),
        hobby = listOf("Running after Atharva", "Playing", "Cartoon"),
        siblingIds = listOf(atharvaKashyapUserId)
)

val userList = listOf(
        ashishJha,
        shobhna,
        sunil,
        manisha,
        anahat,
        anaagat,
        raginiJha,
        ashishKumar,
        atharva,
        arika
)

private fun generateDate(dateStr: String) = SimpleDateFormat("dd/MM/yyyy").parse(dateStr)