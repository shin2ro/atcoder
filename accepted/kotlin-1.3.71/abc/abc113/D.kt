fun main() {
    val mod = 1e9.toInt() + 7
    val (h, w, k) = readLine()!!.split(' ').map { it.toInt() }
    val dp = Array(h + 1) { IntArray(w) }
    dp[0][0] = 1

    val bitsSequence = sequence {
        for (bits in 0 until (1 shl w - 1)) {
            var invalid = false
            for (i in 0 until w - 2) {
                val l = (bits shr i) and 1
                val r = (bits shr i + 1) and 1
                if (l and r == 1) {
                    invalid = true
                }
            }
            if (invalid) continue
            yield(bits)
        }
    }

    for (i in 0 until h) {
        for (j in 0 until w) {
            for (bits in bitsSequence) {
                var nj = j
                if (bits shr j and 1 == 1) nj = j + 1
                else if (j > 0 && bits shr j - 1 and 1 == 1) nj = j - 1
                dp[i + 1][nj] += dp[i][j]
                dp[i + 1][nj] %= mod
            }
        }
    }

    println(dp[h][k - 1])
}

