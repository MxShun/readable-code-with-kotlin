fun connect(timeout: Int, useEncryption: Boolean) {}

fun useConnection() {
    // ✕（IDEによっては説明が表示されるが）数値とブール値が渡されているけど、なんのことだかよく分からない
    connect(10, false)

    // 〇処理としては同じだが、なにをやろうとしているのかが明確
    connect(timeout = 10, useEncryption = false)
}