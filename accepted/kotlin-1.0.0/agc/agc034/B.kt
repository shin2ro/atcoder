fun main(args: Array<String>) {
    val s = readLine()!!.toCharArray()
    var ans = 0L
    var cntA = 0
    var cur = 0
    while (cur < s.size - 1) {
        if (s[cur] == 'A') {
            cntA++
            cur++
            continue
        }

        if (cntA > 0 && s[cur] == 'B' && s[cur + 1] == 'C') {
            ans += cntA
            cur += 2
            continue
        }

        cntA = 0
        cur++
    }
    println(ans)
}
