fun main() {
    val (x, y, a, b) = readLine()!!.split(' ').map { it.toLong() }
    var exp = 0L

    var str = x
    while (str <= y / a && str * a < y && str * a < str + b) {
        exp++
        str *= a
    }
    exp += (y - 1 - str) / b

    println(exp)
}

