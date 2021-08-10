// × ① old と new を数値にパースする、② score を更新するという 2 つのことを同時にやっていて一目見ただけでは分からない。
fun changeVote1(old: Vote, new: Vote) {
    var score = Score.getScore()

    if (new != old) {
        when (new.vote) {
            "Up" -> score += if (old.vote == "Down") 2 else 1
            "Down" -> score -= if (old.vote == "Up") 2 else 1
            "" -> score += if (old.vote == "Up") -1 else 1
            else -> Unit
        }
    }
    Score.setScore(score)
}

// 〇 一目見ただけで正しく動きそう。これがコードを「楽に理解できる」ようにすることである。
fun changeVote2(old: Vote, new: Vote) {
    var score = Score.getScore()

    score -= old.getVoteValue() // 古い値を削除する
    score += new.getVoteValue() // 新しい値を追加する

    Score.setScore(score)
}

data class Vote(
    val vote: String
) {
    fun getVoteValue(): Int {
        return when (vote) {
            "Up" -> 1
            "Down" -> -1
            "" -> 0
            else -> throw IllegalArgumentException("無効な投票値です")
        }
    }
}

object Score {
    private var value = Int.MIN_VALUE

    fun getScore() = value
    fun setScore(value: Int) { this.value = value }
}
