// ✕すべてのメンバ変数を追跡したり、度のメソッドが変数を変更しているかを把握したりするのが難しい
class LargeClass {
    var str = ""

    fun method1() {
        str = "1"
        method2()
    }

    fun method2() {
        // str を使った処理
    }

    // str を使っていないメソッドがたくさんある
}

// ○ str をローカル変数に格下げするといいかもしれない
class LargeClass_ {
    fun method1() {
        val str = "1"
        method2(str)
    }

    fun method2(str: String) {
        // str を使った処理
    }

    // str を使っていないメソッドがたくさんある
}
