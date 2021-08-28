fun readDocument(request: Request) {
    val document = Document()

    // ✕変数が5つも入っているから、考えるのにちょっと時間がかかる
    if (request.user.id == document.ownerId) {
        // ユーザはこの文書を編集できる
    }
    if (request.user.id != document.ownerId) {
        // 文書は読み取り専用
    }


    // 〇要約変数を最上部に定義したことで、この関数で参照する概念を事前に伝えることができるようになった
    val userOwnsDocument: Boolean = (request.user.id == document.ownerId)
    if (userOwnsDocument) {
        // ユーザはこの文書を編集できる
    }
    if (!userOwnsDocument) {
        // 文書は読み取り専用
    }
}

class Request(
    val user: User
) {
    constructor() : this(user = User())
}

class Document(
    val ownerId: String
) {
    constructor() : this(ownerId = "")
}

class User(
    val id: String
) {
    constructor() : this(id = "")
}
