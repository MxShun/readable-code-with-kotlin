import java.time.Instant
import java.util.concurrent.ArrayBlockingQueue

// 時間バケツ N 個のカウントを保持するクラス
class TrailingBucketCounter(
    numBuckets: Int,
    val secsPerBucket: Int
) {
    private val buckets = ConveyorQueue(maxItems = numBuckets)
    private var lastUpdateTime = Instant.now()

    fun add(
        count: Int,
        now: Instant
    ) {
        update(now = now)
        buckets.addToBack(count = count)
    }

    fun trailingCount(now: Instant): Int {
        update(now = now)
        return buckets.totalSum()
    }

    private fun update(now: Instant) {
        val currentBucket = now.epochSecond / secsPerBucket
        val lastUpdateBucket = lastUpdateTime.epochSecond / secsPerBucket

        buckets.shift(numShifted = (currentBucket - lastUpdateBucket).toInt())
        lastUpdateTime = Instant.now()
    }
}

// 最大数を持ったキュー。古いデータは端から「落ちる」
class ConveyorQueue(
    val maxItems: Int,
    var totalSum: Int = 0
) {
    private val q = ArrayBlockingQueue<Int>(0)

    // キューの最後の値を増加する
    fun addToBack(count: Int) {
        if (q.isEmpty()) shift(numShifted = 1) // q が少なくとも 1 つの項目を持つようにする
        q.add(count)
        totalSum += count
    }

    // キューの値を 'numShifted' の文だけシフトする
    // 新しい項目は 0 で初期化する
    // 最古の項目は maxItems 以下なら削除する
    fun shift(numShifted: Int) {
        var num = numShifted

        // 項目がシフトされすぎた場合に、キューをクリアする
        if (num >= maxItems) {
            q.clear()
            totalSum = 0
            return
        }

        // 必要な分だけ 0 をプッシュする
        while (num > 0) {
            q.put(0)
            num--
        }

        // 超過した項目はすべて落とす
        while (q.size > maxItems) {
            totalSum -= q.first()
            q.poll()
        }
    }

    // 現在のキューに含まれる項目の合計値を返す
    fun totalSum() = totalSum
}
