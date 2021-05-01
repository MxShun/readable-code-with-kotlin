class MeaninglessOrder {
    // ✕変数宣言の並びを意識しなかったために流し読みできない
    val details: String = ""
    val phone: String = ""
    val email: String = ""
    val url: String = ""
    val location: String = ""
}

class MeaningfulOrder {
    // 〇意味のある並びで理解がしやすい
    val details:  String = ""
    val location: String = ""
    val phone:    String = ""
    val email:    String = ""
    val url:      String = ""
}