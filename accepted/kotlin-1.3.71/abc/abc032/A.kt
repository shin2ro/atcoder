fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val n = readLine()!!.toInt()
    var ans = n
    while (!(ans % a == 0 && ans % b == 0)) {
        ans++
    }
    println(ans)
}

