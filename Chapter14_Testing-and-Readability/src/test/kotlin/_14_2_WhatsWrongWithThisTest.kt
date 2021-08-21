import org.junit.jupiter.api.Test

internal class _14_2_WhatsWrongWithThisTest {
    // × 少なくとも 8 つ問題がある
    @Test
    fun test1() {
        var docs = listOf<ScoredDocument>()
        docs[0].url = "http://example.com"
        docs[0].score = -5.0
        docs[1].url = "http://example.com"
        docs[1].score = 1.0
        docs[2].url = "http://example.com"
        docs[2].score = 4.0
        docs[3].url = "http://example.com"
        docs[3].score = -99998.7
        docs[4].url = "http://example.com"
        docs[4].score = 3.0

        docs = sortAndFilterDocs(docs = docs)

        assert(docs.size == 3)
        assert(docs[0].score == 4.0)
        assert(docs[1].score == 3.0)
        assert(docs[2].score == 1.0)
    }
}

/**
 * 'docs' をスコアでソートする（降順）
 * マイナスのスコアは削除する
 *
 * @param List<ScoredDocument> docs
 */
internal fun sortAndFilterDocs(
    docs: List<ScoredDocument>
) = docs.filter { it.isPositiveScore() }.sortedByDescending { it.score }

internal class ScoredDocument(
    var url: String,
    var score: Double,
) {
    fun isPositiveScore() = score >= 0.0
}
