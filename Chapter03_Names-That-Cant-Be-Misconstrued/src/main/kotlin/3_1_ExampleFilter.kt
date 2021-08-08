import java.util.function.Predicate

// ✕フィルターする条件を選択するのか、除外するのかが曖昧
fun <T> filter(p: Predicate<T>): List<T> {
    val list: List<T> = listOf()
    return list.filter { p.test(it) }
}

// 〇条件に該当する要素を除外すると分かる
fun <T> exclude(p: Predicate<T>): List<T> {
    val list: List<T> = listOf()
    return list.filter { p.test(it) }
}
