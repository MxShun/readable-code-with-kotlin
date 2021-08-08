@file:Suppress("MagicNumber")

class BeforeEvaluation {
    val experimentId = 101
    val theOtherExperimentIdIWantToReuse = 100
}

class Evaluating {
    // ✕再利用したい実験のID という情報を詰め込んだために長い
    val theOtherExperimentIdIWantToReuse = 100

    // ✕曖昧
    // これはテンプレートだ、なのかこのテンプレートを使っているなのかが分かりにくい
    // テンプレートに使う実験のことを本物の実験ではない抽象的なものと誤解する人がいるかもしれない
    val template = 100

    // △悪くない
    // 文字だけ見ると、この実験は100回再利用できると補任される可能性もある
    // 仮に reuseId とすると、この実験の再利用IDは100だと誤認するユーザがいるかもしれない
    val reuse = 100

    // 〇いい名前
    // 宣言だけ見ると、この実験を100回コピーするなのか、これは100回目のコピーだなのかが分からない
    // copyExperiment という名前に変えるとよい
    val copy = 100

    // 〇プログラマにはなじみのある言葉
    // inheritFrom や inheritFromExperimentId のように他の実験から継承していることは明確にしておこう
    val inherit = 100
}

class AfterEvaluation {
    val experimentId = 101
    val copyExperiment = 100 // もしくは、inheritFromExperimentId
}
