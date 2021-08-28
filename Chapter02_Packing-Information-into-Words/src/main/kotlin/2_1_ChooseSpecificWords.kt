import java.net.URL

abstract class Get {
    // ✕どこからgetするかが不透明
    // ローカルから？インターネットから？
    abstract fun getPage(url: URL): Any

    // 〇目的に合わせて名づける
    abstract fun fetchPage(url: URL): Any
}

abstract class BinaryTree {
    // ✕なにを返すのかが不透明
    // ツリーの高さ？ノード数？ツリーのメモリ消費量？
    abstract fun size(): Int

    // 〇なにを返すのかが明確
    abstract fun numNode(): Int
}

abstract class Thread {
    // △動作に合わせてより明確な名前をつけた方がよい
    abstract fun stop()

    // 〇取り消しができない重い操作の場合
    abstract fun kill()
}
