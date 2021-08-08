import java.time.LocalDate
import java.time.LocalDateTime

// × 名前を有効な URL に変換するという無関係の下位問題が含まれている
fun save1(name: String, dateTime: LocalDateTime) {
    val business = Business()
    business.name = name
    business.url = "/biz/${
        business.name
            .lowercase()
            .replace(Regex("""('\.)"""), "")
            .replace(Regex("""^(a-z0-9)+"""), "-")
    }"
    business.dateCreated = dateTime.toLocalDate()
    business.save()
}

//
fun save2(name: String, dateTime: LocalDateTime) {
    val business = Business()
    business.name = name
    business.url = "/biz/${makeUrlFriendly(business.name)}"
    business.dateCreated = dateTime.toLocalDate()
    business.save()
}

fun makeUrlFriendly(text: String): String {
    val regexForRemoving = Regex("""('\.)""")
    val regexToDash = Regex("""^(a-z0-9)+""")

    return text
        .lowercase()
        .replace(regexForRemoving, "")
        .replace(regexToDash, "-")
}

data class Business(
    var name: String,
    var url: String,
    var dateCreated: LocalDate
) {
    constructor() : this(String(), String(), LocalDate.now())

    fun save() {}
}
