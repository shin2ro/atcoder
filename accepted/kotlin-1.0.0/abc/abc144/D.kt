fun main(args: Array<String>) {
    val (a, b, x) = readLine()!!.split(' ').map { it.toDouble() }
    val rad = if (a * a * b / 2 <= x) {
        Math.atan(2 * (a * a * b - x) / (a * a * a))
    } else {
        Math.PI / 2 - Math.atan(2 * x / (a * b * b))
    }
    println(rad / Math.PI / 2 * 360)
}
