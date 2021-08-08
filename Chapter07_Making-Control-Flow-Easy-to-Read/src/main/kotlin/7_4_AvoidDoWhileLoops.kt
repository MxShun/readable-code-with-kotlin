@file:Suppress("MultiLineIfElse")

// △ do/while 文はコードブロックを再実行する条件が下にあり不自然
// 'name' に合致するものを 'node' のリストから探索する
// 'maxLength' を超えたノードは考えない
fun listHasNodeDoWhile(node: Node, name: String, maxLength: Int): Boolean {
    var node = node
    var maxLength = maxLength

    do {
        if (node.name().equals(name))
            return true
        node = node.next()
    } while (node != null && --maxLength > 0)

    return false
}

// 〇 while 文により自然に
fun listHasNodeWhile(node: Node, name: String, maxLength: Int): Boolean {
    var node = node
    var maxLength = maxLength

    while (node != null && maxLength-- > 0) {
        if (node.name().equals(name)) return true
        node = node.next()
    }
    return false
}

class Node {
    val name: String = ""
    val value: String = ""
    val sub: List<Node> = listOf()
    fun name(): String = name
    fun next(): Node = sub.first()
}
