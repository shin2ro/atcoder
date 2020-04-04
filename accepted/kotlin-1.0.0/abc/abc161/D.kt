import java.util.*

fun main(args: Array<String>) {
    val k = readLine()!!.toInt()
    val queue = ArrayDeque<Long>()
    for (i in 1..9L) queue.addLast(i)

    repeat(k - 1) {
        val x = queue.removeFirst()
        if (x % 10 != 0L) queue.addLast(x * 10 + x % 10 - 1)
        queue.addLast(x * 10 + x % 10)
        if (x % 10 != 9L) queue.addLast(x * 10 + x % 10 + 1)
    }

    println(queue.removeFirst())
}
