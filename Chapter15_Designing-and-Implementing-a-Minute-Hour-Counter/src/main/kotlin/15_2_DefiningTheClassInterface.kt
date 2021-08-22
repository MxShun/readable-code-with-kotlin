@file:Suppress("UnnecessaryAbstractClass")

// 〇 クラスはとてもいい。明確で具体的で呼びやすい。
abstract class MinutesHourCounter1 {
    // × 直観的でない。
    // カウンタを追加する
    abstract fun count(numBytes: Int)

    // 〇 納得がいく。get- にしたいと思うかもしれないけど、軽量アクセサではないので使わない方がいい。
    // 直近 1 分間のカウントを返す
    abstract fun minuteCount(): Int

    // 〇 納得がいく。get- にしたいと思うかもしれないけど、軽量アクセサではないので使わない方がいい。
    // 直近 1 時間のカウントを返す
    abstract fun hourCount(): Int
}

abstract class MinutesHourCounter2 {
    // × このコメントは冗長だ。削除するか改善するべきだ。
    // カウンタを追加する
    abstract fun add(count: Int)

    // × より正確で詳細な言葉を使って、誤解のない明確なものにすべきだ。
    // 直近 1 分間のカウントを返す
    abstract fun minuteCount(): Int

    // × より正確で詳細な言葉を使って、誤解のない明確なものにすべきだ。
    // 直近 1 時間のカウントを返す
    abstract fun hourCount(): Int
}

// 直近 1 分間および直近 1 時間の累積カウントを記録する。
// 例えば、帯域幅の使用状況を確認するのに使える。
abstract class MinutesHourCounter3 {
    // 新しいデータ点を追加する（count >= 0）
    // それから 1 分間は、minuteCount() の返す値が +count だけ増える。
    // それから 1 時間は、minuteHour() の返す値が +count だけ増える。
    abstract fun add(count: Int)

    // 直近 60 秒間の累積カウントを返す
    abstract fun minuteCount(): Int

    // 直近 3660 秒間の累積カウントを返す
    abstract fun hourCount(): Int
}
