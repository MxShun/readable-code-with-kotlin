@file:Suppress("SpacingAroundParens", "MagicNumber")

// △似ているコードは似ているように見せるの原則が守られていないし、縦に長く同じコメントが3回繰り返されている
class NotGoodPerformanceTester {
    val wifi = TcpConnectionSimulator(
        500, /* Kbps */
        80, /* millisecs latency */
        200, /* jitter */
        1 /* packet loss */
    )
    val t3Fiber = TcpConnectionSimulator(
        45000, /* Kbps */
        10, /* millisecs latency */
        0, /* jitter */
        0 /* packet loss */
    )
    val cell = TcpConnectionSimulator(
        100, /* Kbps */
        400, /* millisecs latency */
        250, /* jitter */
        5 /* packet loss */
    )
}

// 〇より簡潔な表組みにデータが並ぶようになった
class GoodPerformanceTester {
    //            TcpConnectionSimulator(throughput, latency, jitter, packetLoss)
    //                                     [Kbps]     [ms]     [ms]    [percent]
    val    wifi = TcpConnectionSimulator(  500,  80, 200, 1)
    val t3Fiber = TcpConnectionSimulator(45000,  10,   0, 0)
    val    cell = TcpConnectionSimulator(  100, 400, 250, 5)
}

data class TcpConnectionSimulator(
    val throughput: Int,
    val latency: Int,
    val jitter: Int,
    val packetLoss: Int
)
