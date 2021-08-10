// × ひどいコード。機能を追加したら、もっとひどいコードになるだろう。
fun makeLocationFriendly1(location: Location): String {
    var place = location.localityName
    if (place.isNullOrEmpty()) place = location.subAdministrativeAreaName
    if (place.isNullOrEmpty()) place = location.administrativeAreaName
    if (place.isNullOrEmpty()) place = "Middle-of-Nowhere"
    if (location.countryName.isNullOrEmpty()) {
        place += ", ${location.countryName}"
    } else {
        place += ", Planet Earth"
    }

    return place
}

// 〇 一度に 1 つのタスクを適用したことでコードのことを考えやすくなった
fun makeLocationFriendly2(location: Location): String {
    val town = location.localityName
    val city = location.subAdministrativeAreaName
    val state = location.administrativeAreaName
    val country = location.countryName

    // 先にデフォルト値を設定して、値が見つかったら書き換える
    var secondHalf = "Planet Earth"
    if (!country.isNullOrEmpty()) secondHalf = country
    if (!state.isNullOrEmpty() && country == "USA") secondHalf = state

    var firstHalf = "Middle-of-Nowhere"
    if (!state.isNullOrEmpty() && country != "USA") firstHalf = state
    if (!city.isNullOrEmpty()) firstHalf = city
    if (!town.isNullOrEmpty()) firstHalf = town

    return "$firstHalf, $secondHalf"
}

// 個人的には variable を使うことによってコードを追いたくない
private const val FIRST_HALF_DEFAULT = "Middle-of-Nowhere"
private const val SECOND_HALF_DEFAULT = "Planet Earth"
fun makeLocationFriendly3(location: Location): String {
    val town = location.localityName
    val city = location.subAdministrativeAreaName
    val state = location.administrativeAreaName
    val country = location.countryName

    val secondHalf = when {
        !country.isNullOrEmpty() -> country
        !state.isNullOrEmpty() && location.isUSA() -> state
        else -> SECOND_HALF_DEFAULT
    }
    val firstHalf = when {
        !state.isNullOrEmpty() && location.isNotUSA() -> state
        !city.isNullOrEmpty() -> city
        !town.isNullOrEmpty() -> town
        else -> FIRST_HALF_DEFAULT
    }

    return "$firstHalf, $secondHalf"
}

data class Location(
    val localityName: String?,
    val subAdministrativeAreaName: String?,
    val administrativeAreaName: String?,
    val countryName: String?,
) {
    fun isUSA() = countryName == "USA"
    fun isNotUSA() = countryName != "USA"
}
