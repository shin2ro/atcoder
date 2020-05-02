fun main() {
    val x = readLine()!!.toLong()
    var c = 100L
    var ans = 0
    while (c < x) {
        c += c / 100
        ans++
    }
    println(ans)
}
