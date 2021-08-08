import java.time.Instant

class NumberBases {
    // △16進値という情報が抜けている
    val id = "af84ef845cd8"

    // 〇hexという接頭辞で16進数という情報を付加
    val hexId = "af84ef845cd8"
}

class Units {
    // ✕時間の単位を見誤ったために意図しない計測結果が表示される
    fun showLoadTime() {
        val start = Instant.now().nano
        // 処理
        val elapsed = Instant.now().nano - start
        print("読み込み時間：${elapsed}秒")
    }

    // 〇ナノ秒という時間の単位情報を付加
    @Suppress("MagicNumber")
    fun showLoadTimeNs() {
        val startNs = Instant.now().nano
        // 処理
        val elapsedNs = Instant.now().nano - startNs
        print("読み込み時間：${elapsedNs * 100_000_000}秒")
    }
}
