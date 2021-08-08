// ✕値の決め方が妥当なのか分からない
const val NUM_THREAD = 8

// 〇値の決め方が分かる
const val NUM_THREAD_ = 8 // 値は >= 2 * numProcessors で十分


// 〇値は厳密じゃなくてもいい場合もある
const val MAX_RSS_SUBSCRIPTIONS = 1000 // 合理的な限界値。人間はこんなに読めない。

// 〇値が良い感じに設定されているので、それ以上調整する必要がないこともある
const val IMAGE_QUALITY = 0.72 // 0.72 ならユーザはファイルサイズと品質の面で妥協できる
