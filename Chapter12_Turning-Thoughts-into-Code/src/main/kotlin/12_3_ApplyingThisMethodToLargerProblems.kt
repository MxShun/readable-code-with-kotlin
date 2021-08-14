import java.time.LocalDateTime

// × 一致しない行をスキップするのに多くの行を費やしている
//   「行をぬかしていないだろうか？」とか「イテレータを読み込みすぎていないだろうか？」などの「警告フラグ」が頭をよぎったかもしれない
fun printStockTransactions1() {
    val stockIter = listOf<Stock>().iterator()
    val priceIter = listOf<Price>().iterator()
    val numSharesIter = listOf<NumberShares>().iterator()

    // 3つのテーブルの行を一度にイテレートする
    while (stockIter.hasNext() && priceIter.hasNext() && numSharesIter.hasNext()) {
        val stockTime = stockIter.next().time
        val priceTime = priceIter.next().time
        val numSharesTime = numSharesIter.next().time

        // 3つの行に同じ time が含まれていない場合は最も過去の行をスキップする
        // 注意: 最も過去の行が2つ一致していることもあるので "<=" は "<" にできない。
        if (stockTime != priceTime || stockTime != numSharesTime) {
            if (stockTime <= priceTime && stockTime <= numSharesTime) {
                stockIter.next()
            } else if (priceTime <= stockTime && priceTime <= numSharesTime) {
                priceIter.next()
            } else if (numSharesTime <= stockTime && numSharesTime <= priceTime) {
                numSharesIter.next()
            } else {
                assert(false) // 不可能
            }
            continue
        }
        assert(stockTime == priceTime && priceTime == numSharesTime)

        // 一致した行を印字する
        println("@$stockTime")
        println(stockIter.next().tickerSymbol)
        println(priceIter.next().price)
        println(numSharesIter.next().numberOfShares)

        stockIter.next()
        priceIter.next()
        numSharesIter.next()
    }
}

// 〇 すごく理解しやすくなった。行をいっちさせる汚い部分がすべて隠れた。
fun printStockTransactions2() {
    val stockIter = listOf<Stock>().iterator()
    val priceIter = listOf<Price>().iterator()
    val numSharesIter = listOf<NumberShares>().iterator()

    while (true) {
        val time = advanceToMatchingTime(stockIter, priceIter, numSharesIter)
        time ?: return

        // 一致した行を印字する
        println("@$time")
        println(stockIter.next().tickerSymbol)
        println(priceIter.next().price)
        println(numSharesIter.next().numberOfShares)

        stockIter.next()
        priceIter.next()
        numSharesIter.next()
    }
}

fun advanceToMatchingTime(
    stockIter: Iterator<Stock>,
    priceIter: Iterator<Price>,
    numSharesIter: Iterator<NumberShares>,
): LocalDateTime {
    // 3つのテーブルの行を一度にイテレートする
    while (stockIter.hasNext() && priceIter.hasNext() && numSharesIter.hasNext()) {
        val stockTime = stockIter.next().time
        val priceTime = priceIter.next().time
        val numSharesTime = numSharesIter.next().time

        // 3つの行に同じ time が含まれていない場合は最も過去の行をスキップする
        if (stockTime != priceTime || stockTime != numSharesTime) {
            if (stockTime <= priceTime && stockTime <= numSharesTime) {
                stockIter.next()
            } else if (priceTime <= stockTime && priceTime <= numSharesTime) {
                priceIter.next()
            } else if (numSharesTime <= stockTime && numSharesTime <= priceTime) {
                numSharesIter.next()
            } else {
                assert(false) // 不可能
            }
            continue
        }
        assert(stockTime == priceTime && priceTime == numSharesTime)
        return stockTime
    }
}

data class Stock(
    val time: LocalDateTime,
    val tickerSymbol: String,
)

data class Price(
    val time: LocalDateTime,
    val price: UInt,
)

data class NumberShares(
    val time: LocalDateTime,
    val numberOfShares: UInt
)
