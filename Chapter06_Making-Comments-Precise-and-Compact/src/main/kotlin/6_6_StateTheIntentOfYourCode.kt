import java.util.Collections

fun displayProducts(products: List<Product>) {
    Collections.sort(products)

    // ✕コードの動作をそのまま書いているだけで、なにも情報を追加していない
    // List を逆順にイテレートする
    products.reversed().forEach { print(it.price) }

    // 〇プログラムの動作を高レベルから説明
    // 値段の高い順に表示する
    products.reversed().forEach { print(it.price) }
}

class Product : Comparable<Product> {
    val price: Int = 0
    override fun compareTo(other: Product): Int {
        return other.price - price
    }
}
