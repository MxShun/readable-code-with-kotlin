class Retval {
    // ✕retvalには、これは戻り値です以外の情報はない
    val euclideanNormWithRetval = fun(v: DoubleArray): Double {
        var retval = 0.0
        for (i in 0..v.size) retval += v[i] * v[i]
        return Math.sqrt(retval)
    }

    // 〇sum_squaresだったらバグを見つけやすい
    val euclideanNormWithSumSquares = fun(v: DoubleArray): Double {
        var sumSquares = 0.0
        for (i in 0..v.size) sumSquares += v[i] * v[i]
        return Math.sqrt(sumSquares)
    }
}

class Tmp {
    // ✕tmpがファイルなのか、ファイル名なのか、データなのかが分からない
    fun saveTmp(tmp: Any) {
        save(tmp)
    }

    // 〇保存するのがファイルオブジェクトと分かる
    fun saveTmpFile(tmpFile: Any) {
        save(tmpFile)
    }

    @Suppress("UnusedPrivateMember")
    fun save(any: Any) {}
}
