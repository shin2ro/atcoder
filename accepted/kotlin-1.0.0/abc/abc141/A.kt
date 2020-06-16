fun main(args: Array<String>) {
    val w = listOf("Sunny", "Cloudy", "Rainy")
    val s = readLine()!!
    println(w[(w.indexOf(s) + 1) % 3])
}
