import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    val (a, b) = readLine()!!.split(' ').let {
        BigDecimal(it[0]) to BigDecimal(it[1])
    }
    println((a * b).setScale(0, RoundingMode.FLOOR))
}

