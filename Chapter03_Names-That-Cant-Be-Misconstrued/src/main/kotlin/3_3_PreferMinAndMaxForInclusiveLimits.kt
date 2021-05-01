// ✕限界値の変数名が不明確なために off-by-one エラーのバグがある
fun canBuyItemsWithLimit(numItems: Int): Boolean {
    val CART_TOO_BOG_LIMIT = 100
    if(numItems >= CART_TOO_BOG_LIMIT) {
        throw Error("カートにある商品数が多すぎます")
    } else {
        return true
    }
}

// 〇上限値を含むことが明確なためにデバッグがしやすい
fun canBuyItemsWithMax(numItems: Int): Boolean {
    val MAX_ITEMS_IN_CART = 100
    if(numItems > MAX_ITEMS_IN_CART) {
        throw Error("カートにある商品数が多すぎます")
    } else {
        return true
    }
}