import java.lang.Math.toRadians
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin

// × ループ内のコードは無関係の下位問題を扱っている
fun findClosestLocation1(lat: Double, lng: Double, array: Array<Location>): Location? {
    var closest: Location? = null
    var closestDist = Double.MAX_VALUE
    for (i in 0..array.size) {
        // 2津の地点をラジアンに変換する
        val latRad = toRadians(lat)
        val lngRad = toRadians(lng)
        val lat2Rad = toRadians(array[i].latitude)
        val lng2Rad = toRadians(array[i].longitude)

        // 「球面三角法の第二余弦定理」の公式を使う
        val dist = acos(
            sin(latRad) * sin(lat2Rad) +
            cos(latRad) * cos(lat2Rad) *
            cos(lng2Rad - lngRad)
        )
        if (dist < closestDist) {
            closest = array[i]
            closestDist = dist
        }
    }
    return closest
}

// 〇 難しい計算に心を奪われることなく高レベルの目標に集中できるようになった
fun findClosestLocation2(lat: Double, lng: Double, array: Array<Location>): Location {
    var closest = Location()
    var closestDist = Double.MAX_VALUE
    for (i in 0..array.size) {
        val dist = getSphericalDistance(
            lat1 = lat,
            lng1 = lng,
            lat2 = array[i].latitude,
            lng2 = array[i].longitude
        )
        if (dist < closestDist) {
            closest = array[i]
            closestDist = dist
        }
    }
    return closest
}

private fun getSphericalDistance(
    lat1: Double,
    lng1: Double,
    lat2: Double,
    lng2: Double
): Double {
    val lat1Rad = toRadians(lat1)
    val lng1Rad = toRadians(lng1)
    val lat2Rad = toRadians(lat2)
    val lng2Rad = toRadians(lng2)

    // 「球面三角法の第二余弦定理」の公式を使う
    return acos(
        sin(lat1Rad) * sin(lat2Rad) +
        cos(lat1Rad) * cos(lat2Rad) *
        cos(lng2Rad - lng1Rad)
    )
}

data class Location(
    val latitude: Double, // 緯度
    val longitude: Double // 経度
) {
    constructor() : this(latitude = Double.NaN, longitude = Double.NaN)
}
