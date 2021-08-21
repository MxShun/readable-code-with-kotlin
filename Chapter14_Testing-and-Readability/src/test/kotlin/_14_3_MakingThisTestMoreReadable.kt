import org.junit.jupiter.api.Test

internal class _14_3_MakingThisTestMoreReadable {
    // △ ヘルパー関数によりずっと簡潔になった
    @Test
    fun test2() {
        var docs = listOf<ScoredDocument>()
        makeScoredDoc(sd = docs[0], url = "http://example.com", score = -5.0)
        makeScoredDoc(sd = docs[1], url = "http://example.com", score = 1.0)
        makeScoredDoc(sd = docs[2], url = "http://example.com", score = 4.0)
        makeScoredDoc(sd = docs[3], url = "http://example.com", score = -99998.7)
        makeScoredDoc(sd = docs[4], url = "http://example.com", score = 3.0)

        docs = sortAndFilterDocs(docs = docs)

        assert(docs.size == 3)
        assert(docs[0].score == 4.0)
        assert(docs[1].score == 3.0)
        assert(docs[2].score == 1.0)
    }

    // △ だいぶよくなった。でも、まだ「楽に読み書きできる」テストじゃない
    @Test
    fun test3() {
        var docs = listOf<ScoredDocument>()
        docs = addScoredDoc(docs = docs, score = -5.0)
        docs = addScoredDoc(docs = docs, score = 1.0)
        docs = addScoredDoc(docs = docs, score = 4.0)
        docs = addScoredDoc(docs = docs, score = -99998.7)
        docs = addScoredDoc(docs = docs, score = 3.0)

        docs = sortAndFilterDocs(docs = docs)

        assert(docs.size == 3)
        assert(docs[0].score == 4.0)
        assert(docs[1].score == 3.0)
        assert(docs[2].score == 1.0)
    }

    // 〇 これならもっとたくさんテストを書きたくなる
    @Test
    fun test4() {
        checkScoresBeforeAfter(
            before = listOf(-5.0, 1.0, 4.0, -99998.3, 3.0),
            after = listOf(4.0, 3.0, 1.0)
        )
    }
}

/**
 * ScoredDocument に値を詰めるヘルパー関数
 *
 * @param ScoredDocument
 * @param Double Score
 * @param String URL
 */
private fun makeScoredDoc(
    sd: ScoredDocument,
    score: Double,
    url: String,
) = sd.apply {
    this.score = score
    this.url = url
}

/**
 * ScoredDocument に score を指定した要素を追加して返す
 *
 * @param List<ScoredDocument> docs
 * @param Double score
 */
private fun addScoredDoc(
    docs: List<ScoredDocument>,
    score: Double,
) = docs.plus(
    ScoredDocument(
        url = "http://example.com",
        score = score
    )
)

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

    assert(after == result.map { it.score })
}
