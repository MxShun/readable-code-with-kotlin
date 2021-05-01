// ✕ふるまいが不明確で、引数の意味するところも不明瞭
fun clip(text: String, length: Int): String {
    return text.substring(0, length)
}

// 〇使い手が動作を認識しやすい
fun truncate(text: String, maxChars: Int): String {
    return text.substring(0, maxChars)
}