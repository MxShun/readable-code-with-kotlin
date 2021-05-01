// ✕ひと塊のコードになっていて誰も読む気がしない
fun badSuggestNewFriends(user: User, emailPassword: String) {
    val friends = user.friends()
    val friendsEmails = friends.map { it.email }
    val contacts = importContacts(user.email, emailPassword)
    val contactEmails = contacts.map { it.email }
    val nonFriendEmails = contactEmails - friendsEmails
    val suggestedFriends = user.select(nonFriendEmails)
    print(user)
    print(friends)
    print(suggestedFriends)
}

// 〇コードにざっと目を通せるようになった
fun goodSuggestNewFriends(user: User, emailPassword: String) {
    // ユーザの友達のメールアドレスを取得する
    val friends = user.friends()
    val friendsEmails = friends.map { it.email }

    // ユーザのメールアカウントからすべてのメールアドレスをインポートする
    val contacts = importContacts(user.email, emailPassword)
    val contactEmails = contacts.map { it.email }

    // まだともだちになっていないユーザを探す
    val nonFriendEmails = contactEmails - friendsEmails
    val suggestedFriends = user.select(nonFriendEmails)

    // それをページに表示する
    print(user)
    print(friends)
    print(suggestedFriends)
}

fun importContacts(email: String, password: String): List<Friend> = listOf()

class User {
    val email: String = ""

    fun friends(): List<Friend> = listOf()
    fun select(emails: List<String>): List<Friend> = listOf()
}

class Friend {
    val email: String = ""
}