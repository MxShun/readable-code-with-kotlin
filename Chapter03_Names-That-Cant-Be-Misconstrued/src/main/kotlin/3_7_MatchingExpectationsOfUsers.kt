@file:Suppress("MatchingDeclarationName")
abstract class StatisticsCollector {
    abstract fun addSample(x: Double)

    // ✕コストが高いとは思わずに呼び出してしまう
    abstract fun getMean(): Double

    // 〇コストが高いことを見越した実装ができる
    abstract fun computeMean(): Double
}
