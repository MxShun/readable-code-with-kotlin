// ✕新しい情報を提供するわけでもなく、読み手がコードを理解しやすくなるわけでもない。まったく価値がない。
// Account クラスの定義
abstract class Account {
    // コンストラクタ
    constructor()
    // profit に新しい値を設定する
    abstract fun setProfit(profit: Double)
    // この Account から profit を返す
    abstract fun getProfit(): Double
}


class DontCommentJustForTheSakeCommenting {
    // ✕価値のないコメントだ（関数宣言とほぼ同じだ）。このコメントは削除するか改善すべきだろう。
    // 与えられた subtree に含まれる name と depth に合致した Node を見つける

    // 〇コメントをつけたければ、もっと大切なことを説明したほうがいい
    // 与えられた 'name' に合致した Node か NULL を返す
    // もし depth <= 0 ならば 'subtree' だけを調べる
    // もし depth == N ならば 'subtree' とその下の N 階層まで調べる
    fun findNodeInSubtree(subtree: Node, name: String, depth: Int): Node = Node()
}

class Node {
    val name: String = ""
    val value: String = ""
    val sub: List<Node> = listOf()
}


abstract class DontCommentBadNames {
    // ✕clean の意味を説明しているだけだ。enforceLimit（制限を課す）という言葉を関数名に入れた方がいい。
    // Reply に対して Request で記述した制限を課す
    // 例えば、返ってくる項目数や合計バイト数など
    abstract fun cleanReply(request: Request, reply: Reply)

    // 〇関数名が自己文書化されている。関数名はいろんなところでしようされるのだから、優れたコメントよりも名前の方が大切だ。
    // 'reply' を 'request' にある項目数やバイト数の制限に合わせる
    abstract fun enforceLimitsFromRequest(request: Request, reply: Reply)


    // ✕コメントで関数の機能説明を補っている。
    // レジストリのハンドルを解放する。実際のレジストリは変更しない。
    abstract fun deleteRegistry(key: RegistryKey)

    // 〇関数名が自己文書化している
    abstract fun releaseRegistryHandle(key: RegistryKey)
}

class Request
class Reply
class RegistryKey
