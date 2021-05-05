// Kotlin に三項演算子はない。
// if/else 文が式として扱われるため、 if/else の結果を変数に代入するようなことは可能。
fun floatingPointNumberToRealNumber(mantissa: Int, exponent: Int): Int {
    return if(exponent >= 0) {
        mantissa * (1 shl exponent)
    } else {
        mantissa / (1 shl -exponent)
    }
}