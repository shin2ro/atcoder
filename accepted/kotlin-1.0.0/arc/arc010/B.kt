import java.util.*

fun main(args: Array<String>) {
    val calendar = BooleanArray(366) { false }

    for (i in 0 until 366) {
        val current = Calendar.getInstance()
        current.set(2012, 0, 1, 0, 0, 0)
        current.add(Calendar.DATE, i)

        val dow = current.get(Calendar.DAY_OF_WEEK)
        if (dow == Calendar.SUNDAY || dow == Calendar.SATURDAY) {
            calendar[i] = true
        }
    }

    val n = readLine()!!.toInt()
    val c = Calendar.getInstance()
    c.set(2012, 0, 1, 0, 0, 0)
    repeat(n) {
        val (m, d) = readLine()!!.split('/').map { it.toInt() }
        val current = Calendar.getInstance()
        current.set(2012, m - 1, d, 0, 0, 0)

        val diff = (current.timeInMillis - c.timeInMillis) / (1000 * 60 * 60 * 24)
        var i = diff.toInt()
        while (i < 366 && calendar[i]) i++
        if (i < 366) calendar[i] = true
    }

    var max = 0
    var cnt = 0
    for (i in 0 until 366) {
        if (calendar[i]) {
            cnt++
        } else {
            max = Math.max(cnt, max)
            cnt = 0
        }
    }
    max = Math.max(cnt, max)

    println(max)
}
