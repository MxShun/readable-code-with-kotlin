import java.net.URL

class Get {
    // ✕どこからgetするかが不透明
    // ローカルから？インターネットから？
    fun getPage(url: URL): Any {
        return url.openConnection().getContent()
    }

    // 〇目的に合わせて名づける
    fun fetchPage(url: URL): Any {
        return url.openConnection().getContent()
    }
}

class BinaryTree {
    // ✕なにを返すのかが不透明
    // ツリーの高さ？ノード数？ツリーのメモリ消費量？
    fun size(): Int = 0

    // 〇なにを返すのかが明確
    fun numNode(): Int = 0
}

class Thread {
    // △動作に合わせてより明確な名前をつけた方がよい
    fun stop(): Unit {}

    // 〇取り消しができない重い操作の場合
    fun kill(): Unit {}
}