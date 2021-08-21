import org.junit.jupiter.api.Test

internal class _14_5_SimplifyingTheInputValues {
    @Test
    fun test4() {
        checkScoresBeforeAfter(
            // × 入力値がでたらめであり、単純なものではない。 -99987
            before = listOf(-5.0, 1.0, 4.0, -99998.7, 3.0),
            after = listOf(4.0, 3.0, 1.0)
        )

        checkScoresBeforeAfter(
            // 〇 キレイで単純な値でありノイズがない
            before = listOf(1.0, 2.0, -1.0, 3.0),
            after = listOf(3.0, 2.0, 1.0)
        )
    }

    @Test
    fun test5() {
        // 〇 次の人がコードを扱いやすく、失敗したテストによってその場所がわかる
        checkScoresBeforeAfter( // ソート
            before = listOf(2.0, 1.0, 3.0),
            after = listOf(3.0, 2.0, 1.0)
        )
        checkScoresBeforeAfter( // マイナスは削除
            before = listOf(0.0, -0.1, -10.0),
            after = listOf(0.0)
        )
        checkScoresBeforeAfter( // 重複は許可
            before = listOf(1.0, -2.0, 1.0, -2.0),
            after = listOf(1.0, 1.0)
        )
        checkScoresBeforeAfter( // 空の入力値は許可
            before = listOf(),
            after = listOf()
        )
    }
}

/**
 * 変換前後の期待される値を受取り検査する
 *
 * @param List<Double>before
 * @param List<Double> after
 */
private fun checkScoresBeforeAfter(
    before: List<Double>,
    after: List<Double>,
) {
    val result = sortAndFilterDocs(
        docs = before.map {
            ScoredDocument(
                url = "http://example.com",
                score = it
            )
        }
    )

    if (after != result.map { it.score }) {
        println("""
            checkScoresBeforeAfter() failed,
            Input:           $before
            Expected Output: $after
            Actual Output:   $result
        """.trimIndent())
    }
}
