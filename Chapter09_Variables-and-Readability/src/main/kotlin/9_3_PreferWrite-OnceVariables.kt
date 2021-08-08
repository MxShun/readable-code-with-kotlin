@file:Suppress("VarCouldBeVal")

fun numFunction1() {
    // ✕ num が変更される可能性があり追跡する必要がある
    var num = 0

    // num を使った処理
}

fun numFunction2() {
    // ○ num が変更されないことが約束されている
    val num = 0

    // num を使った処理
}
