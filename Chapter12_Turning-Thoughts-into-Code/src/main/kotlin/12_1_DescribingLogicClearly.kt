// × ロジックがたくさんあり理解するのが難しい
@Suppress("ReturnCount")
fun render1(user: User, document: Document): Status {
    val isAdmin = user.isAdmin()
    if (!document.isEmpty()) {
        if (!isAdmin && document.userName != user.name) {
            return Status.NOT_AUTHORIZED
        }
    } else {
        if (!isAdmin) {
            return Status.NOT_AUTHORIZED
        }
    }

    // ページのレンダリング処理
    return Status.OK
}

// 〇 if 文の中身が 2 つも空になっている。
// 　 でも、コードは小さくなったし、ロジックも単純になった。否定形がなくなったからだ。つまり、こちらの方が理解しやすい。
fun render2(user: User, document: Document): Status {
    if (user.isAdmin()) {
        // 権限あり
    } else if (!document.isEmpty() && document.userName == user.name) {
        // 権限あり
    } else {
        return Status.NOT_AUTHORIZED
    }

    // ページのレンダリング処理
    return Status.OK
}

data class Document(
    val body: String,
    val userName: String,
) {
    fun isEmpty() = body.isEmpty()
}

data class User(
    val name: String,
    val authority: Authority,
) {
    fun isAdmin() = authority == Authority.ADMIN
}

enum class Authority {
    ADMIN, GENERAL
}

enum class Status {
    OK, NOT_AUTHORIZED
}
