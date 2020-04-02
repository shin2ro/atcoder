fun main(args: Array<String>) {
    val dx = listOf(-1, -1, 0, 1, 1, 1, 0, -1)
    val dy = listOf(0, 1, 1, 1, 0, -1, -1, -1)

    val (h, w) = readLine()!!.split(' ').map { it.toInt() }
    val image = (0 until h).map { readLine()!! }

    val original = Array(h) { CharArray(w) { '.' } }
    for (i in 0 until h) {
        for (j in 0 until w) {

            if (image[i][j] == '.') continue

            var c = '#'
            for (k in 0 until 8) {
                val di = i + dx[k]
                val dj = j + dy[k]

                if (di !in 0 until h) continue
                if (dj !in 0 until w) continue

                if (image[di][dj] == '.') {
                    c = '.'
                    break
                }
            }
            original[i][j] = c
        }
    }

    val shrunk = Array(h) { CharArray(w) { '.' } }
    for (i in 0 until h) {
        for (j in 0 until w) {
            if (original[i][j] == '.') continue

            shrunk[i][j] = '#'
            for (k in 0 until 8) {
                val di = i + dx[k]
                val dj = j + dy[k]

                if (di !in 0 until h) continue
                if (dj !in 0 until w) continue

                shrunk[di][dj] = '#'
            }
        }
    }

    if ((0 until h).all { i -> (0 until w).all { j -> shrunk[i][j] == image[i][j] } }) {
        println("possible")
        original.forEach { println(it.joinToString("")) }
    } else {
        println("impossible")
    }
}
