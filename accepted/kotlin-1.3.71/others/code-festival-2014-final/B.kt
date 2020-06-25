fun main() {
    val s = readLine()!!
    val ans = s
            .mapIndexed { i, c -> (c - '0') * if (i % 2 == 0) 1 else -1 }
            .sum()
    println(ans)
}
