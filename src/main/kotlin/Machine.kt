import java.util.*

const val zona2 = 1.3125
const val zona3 = 1.8443
val allowedMoney = listOf(0.05, 0.10, 0.20, 0.50, 1.0, 2.0, 5.0, 10.0, 20.0, 50.0)

fun createTicketList(): List<Ticket> {
    return listOf(
        Ticket("Bitllet Senzill", 2.40),
        Ticket("T-Casual", 11.35),
        Ticket("T-Usual", 40.00),
        Ticket("T-Familiar", 70.00),
        Ticket("T-Jove", 80.00)
    )
}

fun isMoneyAllowed(userMoney: Double): Boolean {
    return allowedMoney.contains(userMoney)
}

fun payment(scanner: Scanner, price: Double): Double {
    var money = 0.0
    while (money < price) {
        print("Inserta l'import a pagar: ")
        val userMoney = checkDouble(scanner)
        if (isMoneyAllowed(userMoney)) {
            money += userMoney
            println("Import ingressat: $money")
            if (money < price) {
                println("Import restant: ${price - money}")
            }
        } else {
            println("Moneda o bitllet no vàlid. Torna a insertar.")
        }
    }
    return money
}

fun calculateChange(money: Double, price: Double): Double {
    val canvi = money - price
    println("Recull el teu canvi: $canvi€.")
    return canvi
}

//todo hacer que se vea bonito y poner fecha
fun printTickets(completedTickets: MutableList<CompletedPurchase>, scanner: Scanner){
    println("Desitja tiquet en paper? (S/N): ")
    val userAnswer = getYesOrNo(scanner)
    if (userAnswer) {
        println("--------TIQUET---------")
        completedTickets.forEach {
            it.printTicket()
            println("--------------------")
        }
    }
}

fun selectTicket(scanner: Scanner, ticketList: List<Ticket>): Ticket {
    println(
        """
        Benvingut a la màquina de bitllets de metro. Selecciona el títol de transport que vols comprar:
        1. Bitllet senzill
        2. T-Casual
        3. T-Usual
        4. T-Familiar
        5. T-Jove
    """.trimIndent()
    )
    val userTicket = getIntInRange(1, ticketList.size, scanner)
    val selectedTicket = ticketList[userTicket - 1]
    return selectedTicket
}

fun selectZone(scanner: Scanner): Int {
    println(
        """
        Ara selecciona la zona en la que vols viatjar:
        Zona 1
        Zona 2
        Zona 3
    """.trimIndent()
    )
    val userZone = getIntInRange(1, 3, scanner)
    return userZone
}

fun purchaseTicket (scanner: Scanner, ticketList: List<Ticket>): CompletedPurchase {
    val userTicket = selectTicket(scanner, ticketList)
    val userZone = selectZone(scanner)
    val price = userTicket.calculatePrice(userZone)
    val money = payment(scanner, price)
    calculateChange(money, price)
    return CompletedPurchase(userTicket, userZone)
}

fun initMachine(scanner: Scanner, ticketList: List<Ticket>) {
    val userCart = createCart()
    var continueShopping = true
    while (continueShopping) {
        val userTicket = purchaseTicket(scanner, ticketList)
        userCart.add(userTicket)
        print("Vols comprar un altre bitllet? (S/N): ")
        val userAnswer = getYesOrNo(scanner)
        if (!userAnswer || isCartFull(userCart)) {
            continueShopping = false
        }
    }
    endPurchase(userCart, scanner)
}

fun endPurchase(userCart: MutableList<CompletedPurchase> ,scanner: Scanner){
    printTickets(userCart, scanner)
    println("Gràcies per utilitzar la màquina de venda. Adéu!")
}

fun isCartFull(cart: MutableList<CompletedPurchase>): Boolean {
     if(cart.size >= 3){
         println("El carro està ple. No es poden afegir més bitllets.")
         return true
     }
    return false
}

fun createCart(): MutableList<CompletedPurchase> {
    return mutableListOf()
}



