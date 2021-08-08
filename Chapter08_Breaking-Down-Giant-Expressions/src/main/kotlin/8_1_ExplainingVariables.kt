fun isRootUser(userInfo: String): Boolean {
    // ✕なにをやっているのかがぱっと見で分からない
    if(userInfo.split(":")[0].trim() == "root") return true
    return false
}

fun isRootUser_(userInfo: String): Boolean {
    // 〇説明変数がその役割を果たしている
    val userName = userInfo.split(":")[0].trim()
    if(userName== "root") return true
    return false
}