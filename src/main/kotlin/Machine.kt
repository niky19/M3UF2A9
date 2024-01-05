import java.util.Scanner

fun main() {

}
const val zona2 = 1.3125
const val zona3 = 1.8443

fun allowedMoney() {
    val coins = listOf(
        0.05, 0.10, 0.20,
        0.50, 1.0, 2.0
    )
    val bills = listOf(5, 10, 20, 50)

    val metroTickets = listOf(Ticket("Bitllet Senzill", 2.40),
        Ticket("T-Casual", 2.40),
        Ticket("T-Usual", 2.40),
        Ticket("T-Familiar", 2.40),
        Ticket("T-Jove", 2.40))
}

fun priceCalculator(sc : Scanner, ticket: Ticket) : Double {
    val zone = getIntInRange(1,3, sc)
    var price = ticket.basePrice
    when (zone) {
        1 -> price
        2 -> {
            price *= zona2
        }
        3 -> {
            price *= zona3
        }
    }
    return price
}


