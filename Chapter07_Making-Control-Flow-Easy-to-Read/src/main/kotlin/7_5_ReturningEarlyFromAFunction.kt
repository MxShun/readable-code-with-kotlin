@file:Suppress("ReturnCount")

// ✕クリーンアップにより不自然なコード
fun contains1(str: String, substr: String): Boolean {
    if (str == null || substr == null) {
        return false
    } else if (substr.equals("") || str.contains(substr)) {
        return true
    } else {
        return false
    }
}

// 〇ガード節により自然な実装
fun contains2(str: String, substr: String): Boolean {
    if (str == null || substr == null) return false
    if (substr.equals("")) return true
    if (str.contains(substr)) return true
    return false
}
