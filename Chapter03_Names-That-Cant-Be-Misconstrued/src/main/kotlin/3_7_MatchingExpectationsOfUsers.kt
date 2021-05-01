class StatisticsCollector {
    fun addSample(x: Double) {}

    // ✕コストが高いとは思わずに呼び出してしまう
    fun getMean(): Double {
        // 過去すべてのデータをイテレートして、その場で平均値を計算する
        return 0.0
    }

    // 〇コストが高いことを見越した実装ができる
    fun computeMean(): Double {
        // 過去すべてのデータをイテレートして、その場で平均値を計算する
        return 0.0
    }
}