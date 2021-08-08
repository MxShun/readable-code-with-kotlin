@file:Suppress("MagicNumber")

import java.time.Duration

// × 残念なインタフェースから愚直に必要な Cookie を取得している
fun getMaxResults1(): String? {
    var maxResults: String? = null
    val cookies = Cookie().values().split(";")
    for (i in 0..cookies.size) {
        var c = cookies[i]
        c = c.replace(Regex("""^[ ]+"""), "") // 先頭の空白を削除
        if (c.indexOf("max_results=") == 0) {
            maxResults = c.substring(12, c.length)
        }
    }
    return maxResults
}

// 〇 インタフェースをラップする関数により、優雅で簡潔で強力に Cookie を扱えるようになった。
fun getCookieOrNull(name: String) = Cookie().values().split(";").firstOrNull { c -> c.startsWith(name) }
fun setCookie(name: String, value: String, aliveTime: Duration) { Cookie(mapOf(Pair(name, value)), aliveTime) }
fun deleteCookie(name: String) = Cookie().values().split(";").dropWhile { c -> c.startsWith(name) }

// Cookie を操作する JavaScript ライブラリを模したもの
class Cookie(
    private val cookies: Map<String, String>,
    private val aliveTime: Duration
) {
    constructor() : this(cookies = emptyMap(), aliveTime = Duration.ZERO)

    fun values() = cookies.map { "${it.key}=${it.value}; " }.joinToString()
}
