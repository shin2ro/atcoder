fun main(args: Array<String>) {
    val a = (0 until 3).map { readLine()!!.split(' ').map { it.toInt() } }
    val b = Array(3) { BooleanArray(3) { false } }
    val n = readLine()!!.toInt()

    repeat(n) {
        val x = readLine()!!.toInt()
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                if (a[i][j] == x) {
                    b[i][j] = true
                }
            }
        }
    }

    var ans = false

    for (i in 0 until 3) {
        if (b[i][0] && b[i][1] && b[i][2]) ans = true
    }

    for (i in 0 until 3) {
        if (b[0][i] && b[1][i] && b[2][i]) ans = true
    }

    if (b[0][0] && b[1][1] && b[2][2]) ans = true
    if (b[0][2] && b[1][1] && b[2][0]) ans = true

    println(if (ans) "Yes" else "No")
}

