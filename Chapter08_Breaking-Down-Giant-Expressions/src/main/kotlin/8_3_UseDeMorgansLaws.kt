import java.io.File

fun readFile(file: File, isProtected: Boolean) {
    // ✕肯定と否定、全体を括る否定があり保守性が低い
    if(!(file.exists() && !isProtected)) Error("Sorry, could not read file.")


    // 〇ド・モルガンにより単項式の和で表され直感的になった
    if(!file.exists() || isProtected) Error("Sorry, could not read file.")
}