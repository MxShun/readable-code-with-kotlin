fun isRootUser1(userInfo: String): Boolean {
    // ✕なにをやっているのかがぱっと見で分からない
    if (userInfo.split(":")[0].trim() == "root") return true
    return false
}

fun isRootUser2(userInfo: String): Boolean {
    // 〇説明変数がその役割を果たしている
    val userName = userInfo.split(":").firstOrNull()?.trim()
    if (userName == "root") return true
    return false
}
