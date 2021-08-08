import java.time.LocalDateTime

class PrintEvents {
    val eventList: List<Event> = listOf()

    // ✕
    // 10月16日に開催されたイベントをすべて印字したいとき
    // printEventsInRange(LocalDateTime.of(2021, 10, 16, 0, 0), LocalDateTime.of(2021, 10, 17, 23, 59, 59))
    fun printEventsInRangeClosed(start: LocalDateTime, stop: LocalDateTime) {
        val eventsInRangeClosed = eventList.filter { it.dateTime >= start && it.dateTime <= stop }
        eventsInRangeClosed.forEach { println(it.name) }
    }

    // 〇包含/排他的範囲として明確
    // 10月16日に開催されたイベントをすべて印字したいとき
    // printEventsInRange(LocalDateTime.of(2021, 10, 16, 0, 0), LocalDateTime.of(2021, 10, 17, 0, 0))
    fun printEventsInRange(begin: LocalDateTime, end: LocalDateTime) {
        val eventsInRange = eventList.filter { it.dateTime >= begin && it.dateTime < end }
        eventsInRange.forEach { println(it.name) }
    }
}

data class Event(val name: String, val dateTime: LocalDateTime)
