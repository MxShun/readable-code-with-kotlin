@file:Suppress("SpacingAroundColon")

// ✕無駄な余白、配置のズレ、不規則な順序
class BadStatsKeeper {
// double を記録するクラス
    fun add(d: Double) {} // とすばやく統計を出すメソッド
   private  val count: Int = 0 // それまでの個数
    val average: Double = 0.0

private  val minimum: Double = 0.0
val pastItems
  : List<Double> = listOf()
    private val maximum: Double = 0.0
}

// 〇統一感のある余白、配置、順序
// double を記録するクラスと
// すばやく統計を出すメソッド
class GoodStatsKeeper {
    fun add(d: Double) {}
    val average: Double = 0.0

    private val pastItems: List<Double> = listOf()
    private val count: Int = 0
    private val minimum: Double = 0.0
    private val maximum: Double = 0.0
}
