fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    println(if ((1..9).any { a -> (1..9).any { b -> a * b == n } }) "Yes" else "No")
}
