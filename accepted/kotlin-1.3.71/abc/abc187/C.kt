fun main() {
    val n = readLine()!!.toInt()
    val a = mutableSetOf<String>()
    val b = mutableSetOf<String>()
    repeat(n) {
        val s = readLine()!!
        if (s[0] == '!') {
            b.add(s.slice(1 until s.length))
        } else {
            a.add(s)
        }
    }

    val ans = a.intersect(b).let {
        if (it.isEmpty()) {
            "satisfiable"
        } else {
            it.first()
        }
    }

    println(ans)
}

