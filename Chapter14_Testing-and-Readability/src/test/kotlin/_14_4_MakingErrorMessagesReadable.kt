import org.junit.jupiter.api.Test

internal class _14_4_MakingThisTestMoreReadable {
    @Test
    fun test4() {
        checkScoresBeforeAfter(
            before = listOf(-5.0, 1.0, 4.0, -99998.7, 3.0),
            after = listOf(4.0, 3.0, 1.0)
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

    // △ 失敗すれば Assertion failed が表示されるが、分かりづらい
    assert(after == result.map { it.score })

    // 〇 入出力値も表示されより役に立つ
    if (after != result.map { it.score }) {
        println(
            """
                checkScoresBeforeAfter() failed,
                Input:           $before
                Expected Output: $after
                Actual Output:   $result
            """.trimIndent()
        )
    }
}
