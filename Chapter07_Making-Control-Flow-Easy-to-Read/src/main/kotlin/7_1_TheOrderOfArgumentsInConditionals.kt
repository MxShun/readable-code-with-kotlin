fun printLongLength(length: Int) {
    // ✕不自然
    if(100 <= length) { print(length) }

    // 〇自然
    if(length >= 100) { print(length) }
}