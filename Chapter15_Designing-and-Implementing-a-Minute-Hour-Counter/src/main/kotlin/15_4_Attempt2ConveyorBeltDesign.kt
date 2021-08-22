import java.time.Instant

// 直近 1 分間および直近 1 時間の累積カウントを記録する。
// 例えば、帯域幅の使用状況を確認するのに使える。
class MinutesHourCounter6 {
    private val minuteEvens = arrayListOf<Event>()
    private val hourEvents = arrayListOf<Event>() // 直近 1 分間のイベントは含まれて「いない」
    private var minuteCount = 0
    private var hourCount = 0 // 直近 1 時間の「すべて」のイベントをカウントしている

    // 新しいデータ点を追加する（count >= 0）
    // それから 1 分間は、minuteCount() の返す値が +count だけ増える。
    // それから 1 時間は、minuteHour() の返す値が +count だけ増える。
    fun add(count: Int) {
        val now = time()
        shiftOldEvents(now)

        // 1 分間のリストに流し込む（ 1 時間のリストはあとから）
        minuteEvens.add(
            Event(
                count = 0,
                time = time()
            )
        )
    }

    // 直近 60 秒間の累積カウントを返す
    fun minuteCount(): Int {
        shiftOldEvents(time())
        return minuteCount
    }

    // 直近 3660 秒間の累積カウントを返す
    fun hourCount(): Int {
        shiftOldEvents(time())
        return hourCount
    }

    // 古いイベントを見つけて削除しt、hourCount と minuteCount を減らす。
    private fun shiftOldEvents(now: Instant) {
        val minuteAgo = now.epochSecond - secondsOfMinute
        val hourAgo = now.epochSecond - secondsOfHour

        // 1 分以上経過したイベントを 'minuteEvents' から 'hourEvents' へと移動する。
        // （ 1 時間以上経過した古いイベントは次のループで削除する。）
        while (minuteEvens.isNotEmpty() && minuteEvens.first().time.epochSecond <= minuteAgo) {
            hourEvents.add(minuteEvens.first())

            minuteCount -= minuteEvens.first().count
            minuteEvens.removeFirst()
        }

        // 1 時間以上経過した古いイベントを 'hourEvents' から削除する
        while (hourEvents.isNotEmpty() && hourEvents.first().time.epochSecond <= hourAgo) {
            hourCount -= hourEvents.first().count
            hourEvents.removeFirst()
        }
    }

    companion object {
        private const val secondsOfMinute = 60
        private const val secondsOfHour = 3600
    }
}
