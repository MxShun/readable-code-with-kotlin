import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class _14_6_NamingTestFunctions {
    // 〇 名前が説明的で役に立つ
    @Test
    @DisplayName("sortAndFilterDocsで入力値が降順に並べ替えられることを確認")
    fun sortDocsTest() {
        checkScoresBeforeAfter(
            before = listOf(2.0, 1.0, 3.0),
            after = listOf(3.0, 2.0, 1.0)
        )
    }
    @Test
    @DisplayName("sortAndFilterDocsでマイナスの入力値が排除されることを確認")
    fun filterDocsTest() {
        checkScoresBeforeAfter(
            before = listOf(0.0, -0.1, -10.0),
            after = listOf(0.0)
        )
    }
    @Test
    @DisplayName("sortAndFilterDocsで重複が許容されることを確認")
    fun sortAndFilterDuplicateDocsTest() {
        checkScoresBeforeAfter(
            before = listOf(1.0, -2.0, 1.0, -2.0),
            after = listOf(1.0, 1.0)
        )
    }
    @Test
    @DisplayName("sortAndFilterDocsで空の入力値が許容されることを確認")
    fun sortAndFilterEmptyDocsTest() {
        checkScoresBeforeAfter(
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
