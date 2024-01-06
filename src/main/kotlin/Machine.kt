//import java.util.Scanner
//
//fun main() {
//    val sc = Scanner(System.`in`)
//    menu(sc)
//
//}
//
//const val zona2 = 1.3125
//const val zona3 = 1.8443
//
//fun createTicketList(): List<Ticket> {
//    return listOf(
//        Ticket("Bitllet Senzill", 2.40),
//        Ticket("T-Casual", 11.35),
//        Ticket("T-Usual", 40.00),
//        Ticket("T-Familiar", 70.00),
//        Ticket("T-Jove", 80.00)
//    )
//}
//
//fun allowedMoney(): List<Double> {
//    val allowedMoney = listOf(
//        0.05, 0.10, 0.20, 0.50, 1.0, 2.0, 5.0, 10.0, 20.0, 50.0
//    )
//    return allowedMoney
//}
//
//fun isMoneyAllowed(userMoney: Double): Boolean {
//    return allowedMoney().contains(userMoney)
//}
//
//fun priceCalculator(ticket: Ticket, zone: Int): Double {
//    var price = ticket.basePrice
//    when (zone) {
//        2 -> price *= zona2
//        3 -> price *= zona3
//    }
//    println("Preu del bitllet: $price€")
//    return price
//}
//
//fun menu(sc: Scanner) {
//    val ticketList = createTicketList()
//
//    println(
//        """
//        Benvingut a la màquina de bitllets de metro. Selecciona el títol de transport que vols comprar:
//        1. Bitllet senzill
//        2. T-Casual
//        3. T-Usual
//        4. T-Familiar
//        5. T-Jove
//    """.trimIndent()
//    )
//    val userTicket = getIntInRange(1, 5, sc)
//
//    println(
//        """
//        Ara selecciona la zona en la que vols viatjar:
//        1. Zona 1
//        2. Zona 2
//        3. Zona 3
//    """.trimIndent()
//    )
//
//    val userZone = getIntInRange(1, 3, sc)
//    val change = payment(sc, ticketList, userTicket, userZone)
//    println("El teu canvi és de $change€.")
//
//}
//
//fun payment(sc: Scanner, ticketList: List<Ticket>, userTicket: Int, userZone: Int): Double {
//    var money = 0.0
//    val change: Double
//    val userTicket: Ticket = ticketList[userTicket - 1]
//    val price = priceCalculator(userTicket, userZone)
//
//    while (money < price) {
//        print("Introdueix l'import a pagar: ")
//
//        val userMoney = checkDouble(sc)
//
//        if (isMoneyAllowed(userMoney)) {
//            money += userMoney
//            println("Import ingresat: $money")
//            println("Import restant: ${price - money}")
//
//        } else {
//            println("Moneda o bitllet no vàlid. Torna a provar.")
//        }
//    }
//
//    change = money - price
//    return change
//}