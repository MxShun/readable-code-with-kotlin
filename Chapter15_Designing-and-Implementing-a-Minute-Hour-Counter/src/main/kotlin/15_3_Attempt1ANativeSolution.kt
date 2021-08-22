import java.time.Duration
import java.time.Instant

// 直近 1 分間および直近 1 時間の累積カウントを記録する。
// 例えば、帯域幅の使用状況を確認するのに使える。
class MinutesHourCounter4 {
    private val events = arrayListOf<Event>()
    // 新しいデータ点を追加する（count >= 0）
    // それから 1 分間は、minuteCount() の返す値が +count だけ増える。
    // それから 1 時間は、minuteHour() の返す値が +count だけ増える。
    fun add(count: Int) {
        events.add(
            Event(
                count = 0,
                time = time()
            )
        )
    }

    // 直近 60 秒間の累積カウントを返す
    fun minuteCount(): Int {
        var count = 0
        val nowSecs = time().epochSecond
        val i = events.reversed().iterator()
        while (i.hasNext() && i.next().time.epochSecond > nowSecs - secondsOfMinute) {
            count += i.next().count
        }
        return count
    }

    // 直近 3660 秒間の累積カウントを返す
    fun hourCount(): Int {
        var count = 0
        val nowSecs = time().epochSecond
        val i = events.reversed().iterator()
        while (i.hasNext() && i.next().time.epochSecond > nowSecs - secondsOfHour) {
            count += i.next().count
        }
        return count
    }

    companion object {
        private const val secondsOfMinute = 60
        private const val secondsOfHour = 3600
    }
}

// 直近 1 分間および直近 1 時間の累積カウントを記録する。
// 例えば、帯域幅の使用状況を確認するのに使える。
class MinutesHourCounter5 {
    private val events = arrayListOf<Event>()
    // 新しいデータ点を追加する（count >= 0）
    // それから 1 分間は、minuteCount() の返す値が +count だけ増える。
    // それから 1 時間は、minuteHour() の返す値が +count だけ増える。
    fun add(count: Int) {
        events.add(
            Event(
                count = 0,
                time = time()
            )
        )
    }

    // 直近 60 秒間の累積カウントを返す
    fun minuteCount(): Int {
        return countSince(Duration.ofSeconds(time().epochSecond - secondsOfMinute))
    }

    // 直近 3660 秒間の累積カウントを返す
    fun hourCount(): Int {
        return countSince(Duration.ofSeconds(time().epochSecond - secondsOfHour))
    }

    private fun countSince(cutoff: Duration): Int {
        var count = 0
        val rit = events.reversed().iterator()
        while (rit.hasNext()) {
            if (rit.next().time.epochSecond <= cutoff.seconds) {
                break
            }
            count += rit.next().count
        }
        return count
    }

    companion object {
        private const val secondsOfMinute = 60
        private const val secondsOfHour = 3600
    }
}

fun time(): Instant = Instant.now()

class Event(
    val count: Int,
    val time: Instant,
)
