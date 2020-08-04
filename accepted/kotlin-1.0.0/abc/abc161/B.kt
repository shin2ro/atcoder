fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val a = readLine()!!.split(' ').map { it.toInt() }.sortedDescending()
    val s = a.sum()

    var ans = "Yes"

    for (i in 0 until m) {
        if (a[i] * 4 * m < s) {
            ans = "No"
            break
        }
    }

    println(ans)
}

