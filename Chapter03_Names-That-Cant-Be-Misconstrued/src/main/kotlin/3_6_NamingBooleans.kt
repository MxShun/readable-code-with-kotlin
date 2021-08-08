// ✕真偽値の意味が不明瞭で誤解を招く危険性がある
// パスワードをこれから読み取るのか、既に読み取っているのかが不明
val readPassword: Boolean = true

// 〇真偽値の意味が明瞭
val needPassword: Boolean = true
val userIsAuthenticated: Boolean = true


// ✕関数名だけ見ると数値を返すように見える
fun spaceLeft(): Boolean = true

// 〇真偽値を返すことが明白
fun hasSpaceLeft(): Boolean = true


// ✕否定系の false は直感的ではない
val disableSsl: Boolean = false

// 〇声に出して読みやすい。それに短くて済む。
val useSsl: Boolean = false
