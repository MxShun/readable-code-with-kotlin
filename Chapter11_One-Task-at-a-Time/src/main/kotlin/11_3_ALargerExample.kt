// × 大量のコード。ロジックもいっぱい。重複コードだってある。読んでいて楽しくない。
fun updateCounts1(hd: HttpDownload) {
    val counts = Count(counter = 0)

    // 可能であれば Exit State を見つける
    if (!hd.hasEventLog() || hd.eventLog.hasExitState()) {
        counts.of("Exit State", "unknown").counter++
    } else {
        val stateStr = ExitStateTypeName(hd.eventLog.exitState).toString()
        counts.of("Exit State", stateStr).counter++
    }

    // HTTP ヘッダーがなければ、残りの要素に "unknown" を設定する
    if (!hd.hasHttpHeaders()) {
        counts.of("Http Response", "unknown").counter++
        counts.of("Content-type", "unknown").counter++
        return
    }

    val headers = hd.httpHeaders

    // HTTP レスポンスをログに記録する。なければ "unknown" と記録する。
    if (!headers.hasResponseCode()) {
        counts.of("Http Response", "unknown").counter++
    } else {
        print(headers.responseCode)
        counts.of("Http Response", headers.responseCode)
    }

    // Content-Type をログに記録する。なければ "unknown" と記録する。
    if (!headers.hasContentType()) {
        counts.of("Content-Type", "unknown").counter++
    } else {
        val contentType = ContentTypeMime(headers.contentType).toString()
        counts.of("Content-Type", contentType).counter++
    }
}

// 〇 ヘルパー関数で一度に 1 つのタスクを行うを適用できた
fun updateCounts2(hd: HttpDownload) {
    val counts = Count(counter = 0)

    counts.of("Exit State", getExitState(hd)).counter++
    counts.of("Http Response", getHttpResponse(hd)).counter++
    counts.of("Content-Type", getContentType(hd)).counter++
}

fun getExitState(hd: HttpDownload): String {
    return if (hd.hasEventLog() && hd.eventLog.hasExitState()) {
        ExitStateTypeName(hd.eventLog.exitState).toString()
    } else {
        "unknown"
    }
}

fun getHttpResponse(hd: HttpDownload): String {
    return if (hd.httpHeaders.hasResponseCode()) {
        hd.httpHeaders.responseCode
    } else {
        "unknown"
    }
}

fun getContentType(hd: HttpDownload): String {
    return if (hd.httpHeaders.hasContentType()) {
        ContentTypeMime(hd.httpHeaders.contentType).toString()
    } else {
        "unknown"
    }
}

data class Count(
    var counter: Int,
) {
    fun of(key: String, value: String) = this
}

data class HttpDownload(
    val eventLog: Log,
    val httpHeaders: Headers
) {
    fun hasEventLog() = eventLog.body.isNotBlank()
    fun hasHttpHeaders() = httpHeaders.isNotBlank()
}

data class Log(
    val state: String,
    val body: String,
    val exitState: String,
) {
    fun hasExitState() = state == "Exit"
}

data class Headers(
    val body: String,
    val responseCode: String,
    val contentType: String,
) {
    fun isNotBlank() = body.isNotBlank()
    fun hasResponseCode() = responseCode.isNotBlank()
    fun hasContentType() = contentType.isNotBlank()
}

data class ContentTypeMime(
    val type: String,
)

data class ExitStateTypeName(
    val state: String,
)
