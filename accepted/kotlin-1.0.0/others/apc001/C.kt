enum class State {
    None, Vacant, Male, Female
}

fun main(args: Array<String>) {
    fun query(pos: Int): State {
        println(pos)
        return State.valueOf(readLine()!!)
    }

    val n = readLine()!!.toInt()
    val seats = Array(n) { State.None }

    seats[0] = query(0)
    if (seats[0] == State.Vacant) return

    var l = 0
    var r = n - 1
    while (true) {
        val m = l + (r - l) / 2
        seats[m] = query(m)
        if (seats[m] == State.Vacant) return
        if (m % 2 == 0) {
            if (seats[m] == seats[0]) {
                l = m + 1
            } else {
                r = m
            }
        } else {
            if (seats[m] == seats[0]) {
                r = m
            } else {
                l = m + 1
            }
        }
    }
}

