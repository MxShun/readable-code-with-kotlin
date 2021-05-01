// ✕stop の値を含むのかが不透明
// printIntRange(2, 4) としたとき、[2, 3]？それとも[2, 3, 4]？
fun printIntRange(start: Int, stop: Int) {
    print("[")
    for(i in start..stop) {
        print("$i, ")
    }
    print("]")
}

// 〇境界値を含むことが明確
// printIntRange(2, 4) としたとき、[2, 3, 4]となることが想定しやすい
fun printIntRangeClosed(first: Int, last: Int) {
    print("[")
    for(i in first..last) {
        print("$i, ")
    }
    print("]")
}
