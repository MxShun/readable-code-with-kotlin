fun orOperator(a: Boolean, b: Boolean, c: Boolean): Boolean {
    // a・b・cの中から最初に真と評価できるものを選ぶ
    val x = a || b || c
    return x
}
