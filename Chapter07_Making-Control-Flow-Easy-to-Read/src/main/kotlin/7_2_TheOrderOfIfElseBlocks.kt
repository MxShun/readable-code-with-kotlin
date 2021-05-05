import java.io.File

fun ifElse(a: Int, b: Int, file: File) {
    // ✕条件が否定形であるために直感的ではない
    if(a != b) {
        // 第1のケース
    } else {
        // 第2のケース
    }

    // 〇自然
    if(a == b) {
        // 第2のケース
    } else {
        // 第1のケース
    }


    // 〇否定形の条件であっても単純で関心や注意を引く場合にはそれを先に処理する
    if(!file.exists()) {
        // エラーをログに記録する
    } else {
        // 処理
    }
}