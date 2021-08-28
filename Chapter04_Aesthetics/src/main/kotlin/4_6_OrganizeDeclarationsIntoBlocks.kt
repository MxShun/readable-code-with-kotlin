import java.net.http.HttpRequest

// ✕メソッドの概要をすぐに把握できるような階層にはなっていない。
abstract class BadFrontendServer {
    abstract fun frontendServer()
    abstract fun viewProfile(request: HttpRequest)
    abstract fun openDatabase(location: String, user: String)
    abstract fun saveProfile(request: HttpRequest)
    abstract fun extractQueryParam(request: HttpRequest, param: String): String
    abstract fun replyOk(request: HttpRequest, html: String)
    abstract fun findFriends(request: HttpRequest)
    abstract fun replyNotFound(request: HttpRequest, error: String)
    abstract fun closeDatabase(location: String)
}

// 〇論理的なグループで分けられており、概要が把握しやすくなった。
abstract class GoodFrontendServer {
    abstract fun frontendServer()

    // ハンドラ
    abstract fun viewProfile(request: HttpRequest)
    abstract fun saveProfile(request: HttpRequest)
    abstract fun findFriends(request: HttpRequest)

    // リクエストとリプライのユーティリティ
    abstract fun extractQueryParam(request: HttpRequest, param: String): String
    abstract fun replyOk(request: HttpRequest, html: String)
    abstract fun replyNotFound(request: HttpRequest, error: String)

    // データベースのヘルパー
    abstract fun openDatabase(location: String, user: String)
    abstract fun closeDatabase(location: String)
}
