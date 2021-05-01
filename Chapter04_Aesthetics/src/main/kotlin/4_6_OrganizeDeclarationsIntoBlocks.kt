import java.net.http.HttpRequest

// ✕メソッドの概要をすぐに把握できるような階層にはなっていない。
class BadFrontendServer {
    fun frontendServer() {}
    fun viewProfile(request: HttpRequest) {}
    fun openDatabase(location: String, user: String) {}
    fun saveProfile(request: HttpRequest) {}
    fun extractQueryParam(request: HttpRequest, param: String): String = ""
    fun replyOk(request: HttpRequest, html: String) {}
    fun findFriends(request: HttpRequest) {}
    fun replyNotFound(request: HttpRequest, error: String) {}
    fun closeDatabase(location: String) {}
}

// 〇論理的なグループで分けられており、概要が把握しやすくなった。
class GoodFrontendServer {
    fun frontendServer() {}

    // ハンドラ
    fun viewProfile(request: HttpRequest) {}
    fun saveProfile(request: HttpRequest) {}
    fun findFriends(request: HttpRequest) {}

    // リクエストとリプライのユーティリティ
    fun extractQueryParam(request: HttpRequest, param: String): String = ""
    fun replyOk(request: HttpRequest, html: String) {}
    fun replyNotFound(request: HttpRequest, error: String) {}

    // データベースのヘルパー
    fun openDatabase(location: String, user: String) {}
    fun closeDatabase(location: String) {}
}
