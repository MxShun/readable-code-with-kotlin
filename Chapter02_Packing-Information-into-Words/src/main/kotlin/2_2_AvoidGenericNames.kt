import kotlin.math.sqrt

class Retval {
    // ✕retvalには、これは戻り値です以外の情報はない
    val euclideanNormWithRetval = fun(v: DoubleArray): Double {
        var retval = 0.0
        for (i in 0..v.size) retval += v[i] * v[i]
        return sqrt(retval)
    }

    // 〇sum_squaresだったらバグを見つけやすい
    val euclideanNormWithSumSquares = fun(v: DoubleArray): Double {
        var sumSquares = 0.0
        for (i in 0..v.size) sumSquares += v[i] * v[i]
        return sqrt(sumSquares)
    }
}

abstract class Tmp {
    // ✕tmpがファイルなのか、ファイル名なのか、データなのかが分からない
    abstract fun saveTmp(tmp: Any)

    // 〇保存するのがファイルオブジェクトと分かる
    abstract fun saveTmpFile(tmpFile: Any)
}
