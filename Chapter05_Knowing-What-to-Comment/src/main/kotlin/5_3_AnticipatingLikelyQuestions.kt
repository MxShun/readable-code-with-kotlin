import javax.swing.text.html.HTML

abstract class AdvertisingLikelyPitfalls {
    // ✕メーラー接続に1秒かかる実装の場合、開発者が HTTP リクエストの処理中に誤って呼び出してしまうかもしれない
    abstract fun sendEmail1(to: String, subject: String, body: String)

    // 〇メーラがダウンしているときにアプリケーションがハングする不幸を防げる
    // メールを送信するだいぶサービスを呼び出している（1分でタイムアウト）
    abstract fun sendEmail2(to: String, subject: String, body: String)


    // ✕HTML によっては何分も処理がかかることもある
    abstract fun fixBrokenHtml1(html: HTML)

    // 〇ユーザが後で気づくよりも使う前に告知する方がいい
    // 実行時間は 0（タグの数 * タグの深さの平均）なので、ネストの深さに気を付ける
    abstract fun fixBrokenHtml2(html: HTML)
}


// 〇関数の処理を箇条書きでまとめたものなので、詳細を調べなくても関数の概要が把握できる
class SummaryComments {
    fun generateUserReport() {
        // このユーザのロックを獲得する

        // ユーザの情報をデータベースから読み込む

        // 情報をファイルに書き出す

        // このユーザのロックを開放する
    }
}
