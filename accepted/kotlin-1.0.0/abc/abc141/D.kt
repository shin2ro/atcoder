import java.util.*

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val pq = PriorityQueue<Int>(n) { o1, o2 -> -o1.compareTo(o2) }
    readLine()!!.split(' ')
            .map { it.toInt() }
            .forEach { pq.add(it) }
    repeat(m) {
        val a = pq.poll()
        pq.add(a / 2)
    }
    println(pq.fold(0L) { acc, i -> acc + i })
}
