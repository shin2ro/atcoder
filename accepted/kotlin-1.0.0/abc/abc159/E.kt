fun main(args: Array<String>) {
    val (h, w, k) = readLine()!!.split(' ').map { it.toInt() }
    val s = (0 until h).map { readLine()!! }.toTypedArray()

    val ws = Array(h) { IntArray(w + 1) }

    for (i in 0 until h) {
        for (j in 0 until w) {
            ws[i][j + 1] = ws[i][j] + (s[i][j] - '0')
        }
    }

    var ans = 10000

    for (bits in 0 until (1 shl h - 1)) {

        val hs = run {
            val list = mutableListOf<Int>()
            list.add(0)
            list.addAll((0 until h - 1).filter { (bits shr it) and 1 == 1 }.map { it + 1 })
            list.add(h)
            list.toList()
        }

        var ok = true
        var cnt = 0

        var l = 0
        var r = 1

        while (r <= w) {
            var mx = 0
            for (i in 0 until hs.size - 1) {
                val x = (hs[i] until hs[i + 1]).sumBy { ws[it][r] - ws[it][l] }
                mx = Math.max(mx, x)
            }
            if (mx <= k) {
                r++
                continue
            }
            if (r - l == 1) {
                ok = false
                break
            }
            cnt++
            l = r - 1
        }
        if (ok) {
            ans = Math.min(ans, cnt + hs.size - 2)
        }
    }

    println(ans)
}

