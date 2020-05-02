import java.io.PrintWriter

fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val pw = PrintWriter(System.out)
    var l = 0
    var r = 1
    for (i in 0 until m step 2) {
        pw.println("${l + 1} ${r + 1}")
        l = (l + n - 1) % n
        r = (r + 1) % n
    }

    if (n % 2 == 0) {
        l = (l + n - 1) % n
    }

    for (i in 1 until m step 2) {
        pw.println("${l + 1} ${r + 1}")
        l = (l + n - 1) % n
        r = (r + 1) % n
    }
    pw.flush()
}
