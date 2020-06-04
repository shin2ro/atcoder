fun main(args: Array<String>) {
    val s = readLine()!!
    val t = readLine()!!
    val ans = if (String(s.toCharArray().sortedArray()) < String(t.toCharArray().sortedArrayDescending())) "Yes" else "No"
    println(ans)
}
