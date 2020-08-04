import java.io.PrintWriter
import java.util.*

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!.toCharArray()
    val q = readLine()!!.toInt()

    val t = mutableMapOf<Char, TreeSet<Int>>()
    for (i in 0 until 26) {
        t['a' + i] = sortedSetOf()
    }

    for (i in s.indices) {
        t[s[i]]!!.add(i)
    }

    val pw = PrintWriter(System.out)

    repeat(q) {
        val query = readLine()!!.split(' ')
        if (query[0] == "1") {
            val (i, c) = query[1].toInt() - 1 to query[2][0]
            t[s[i]]!!.remove(i)
            s[i] = c
            t[c]!!.add(i)
        } else {
            val (l, r) = query[1].toInt() - 1 to query[2].toInt() - 1

            (0 until 26)
                    .filter {
                        val p = t['a' + it]!!.higher(l - 1) ?: n
                        p <= r
                    }
                    .count()
                    .let { pw.println(it) }
        }
    }

    pw.flush()
}

