// ✕バグを見逃しやすい
fun Range.overlapsWith1(other: Range): Boolean {
    // 'begin' または 'end' が 'other' のなかにあるかを確認する
    return (begin >= other.begin && begin < other.end) ||
            (end > other.begin && end <= other.end)
}


// 〇重なっていない部分にフォーカスしたことでロジックが単純になった
@Suppress("ReturnCount")
fun Range.overlapsWith2(other: Range): Boolean {
    if (other.end <= begin) return false // 一方の終点が、この視点よりも前にある
    if (other.begin >= end) return false // 一方の視点が、個の終点よりも跡にある
    return true // 残ったものは重なっている
}

@Suppress("MagicNumber")
class Range {
    val begin: Int = 1
    val end: Int = 3
}
