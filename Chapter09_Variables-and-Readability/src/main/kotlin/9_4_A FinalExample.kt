@file:Suppress("ReturnCount")

// ✕ found、i、elem という3つの変数は関数の中で何度も書き換えられている
fun getElementWithNewValue1(newValue: String): Element {
    var found = false
    var i = 1
    var elem = Document().getElementById(i)
    while (elem != null) {
        if (elem.value == "") {
            found = true
            break
        }
        i++
        elem = Document().getElementById(i)
    }
    if (found) elem.value = newValue
    return elem
}

// ○ガード節で早期リターン、値を追いかける必要がない
fun getElementWithNewValue2(newValue: String): Element? {
    for (i in 1..Int.MAX_VALUE) {
        val elem = Document().getElementById(i)
        elem ?: return null

        if (elem.value == "") {
            elem.value = newValue
            return elem
        }
    }
    return null
}

class Document {
    fun getElementById(id: Int) = Element(id, "")
}

data class Element(
    var id: Int,
    var value: String
)
