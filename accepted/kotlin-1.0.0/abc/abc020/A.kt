fun main(args: Array<String>) {
    val q = readLine()!!
    val ans = when(q) {
        "1" -> "ABC"
        "2" -> "chokudai"
        else -> error("")
    }
    println(ans)
}
