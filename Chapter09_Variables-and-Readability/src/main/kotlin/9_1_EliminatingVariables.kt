import java.time.LocalDateTime

fun setViewdTimeNow(message: Message) {
    // ✕複雑な式を分割しているわけでなく、より明確になっているわけでもない
    val now = LocalDateTime.now()
    message.lastViewedTime = now

    // ○明確さは変わらない
    message.lastViewedTime = LocalDateTime.now()
}

fun removeByValue(array: ArrayList<Int>, valueToRemove: Int) {
    // ✕中間変数を不必要に利用している
    var indexToRemove: Int? = null
    for(i in 0..array.size) {
        if(array[i] == valueToRemove) {
            indexToRemove = i
            break
        }
    }
    if(indexToRemove !== null) {
        array.drop(indexToRemove)
    }

    // ○コードがずっと簡潔になった
    for(i in 0..array.size) {
        if(array[i] == valueToRemove) {
            array.drop(i)
            return
        }
    }

    // Kotlin(Java)のイディオムを生かせばこう書ける
    array.removeIf { it == valueToRemove }
}

class Message {
    var lastViewedTime = LocalDateTime.MIN
}