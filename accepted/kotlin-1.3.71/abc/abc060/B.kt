fun main() {
    val (a, b, c) = readLine()!!.split(' ').map { it.toInt() }
    var ans = false

    var i = 1
    while (true) {
        if (i > 1 && a * i % b == a % b) {
            break
        }
        if (a * i % b == c) {
            ans = true
            break
        }
        i++
    }

    println(if (ans) "YES" else "NO")
}

