fun main(args: Array<String>) {
    val deck = readLine()!!

    val map = mapOf(
            'S' to mutableSetOf<String>(),
            'H' to mutableSetOf(),
            'D' to mutableSetOf(),
            'C' to mutableSetOf()
    )

    fun parse(cur: Int): String {
        return if (deck[cur + 1] == '1') {
            deck.slice(cur..cur + 2)
        } else {
            deck.slice(cur..cur + 1)
        }
    }

    fun isNumberOfRfs(s: String): Boolean {
        return setOf('A', '1', 'J', 'Q', 'K').contains(s[1])
    }

    var suit = ' '
    var cur = 0
    while (cur < deck.length) {
        val card = parse(cur)
        cur += card.length
        if (isNumberOfRfs(card)) {
            map[card[0]]?.add(card)
        }
        if (map[card[0]]?.size == 5) {
            suit = card[0]
            break
        }
    }

    val discarded = mutableListOf<String>()
    val n = cur
    cur = 0
    while (cur < n) {
        val card = parse(cur)
        cur += card.length
        if (!(card[0] == suit && isNumberOfRfs(card))) {
            discarded.add(card)
        }
    }
    println(if (discarded.size == 0) 0 else discarded.joinToString(""))
}
