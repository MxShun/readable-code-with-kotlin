import java.nio.file.Path
import kotlin.io.path.readLines

// × ファイルを byte array で取得するという高レベルの目標に対し
// ディクショナリを印字するという無関係な下位問題を解決しようとしている
fun readFile1(path: Path): List<Byte> {
    print("--- Beginning of File ---")
    val fileAllBytes = path.readLines().mapIndexed { i, l ->
        print("Line $i: $l↴")
        l.toByte()
    }
    print("------ End of File ------")

    return fileAllBytes
}

// 〇 呼出し元のコードが簡潔になり、後から再利用ができる。コードが独立しているので改善が楽。
fun readFile2(path: Path): List<Byte> {
    val lines = path.readLines()
    printPretty(lines)
    return lines.map { it.toByte() }
}

private fun printPretty(lines: List<String>) {
    print("--- Beginning of File ---")
    lines.mapIndexed { i, l ->
        print("Line $i: $l↴")
    }
    print("------ End of File ------")
}
