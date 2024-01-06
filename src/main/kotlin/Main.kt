import java.time.LocalDate
import java.util.Scanner
import kotlin.system.exitProcess




const val zona2 = 1.3125
const val zona3 = 1.8443

fun createTicketList(): List<Ticket> {
    return listOf(
        Ticket("Bitllet Senzill", 2.40),
        Ticket("T-Casual", 11.35),
        Ticket("T-Usual", 40.00),
        Ticket("T-Familiar", 70.00),
        Ticket("T-Jove", 80.00)
    )
}

fun allowedMoney(): List<Double> {
    return listOf(0.05, 0.10, 0.20, 0.50, 1.0, 2.0, 5.0, 10.0, 20.0, 50.0)
}

fun isMoneyAllowed(userMoney: Double): Boolean {
    return allowedMoney().contains(userMoney)
}

fun calculatePrice(ticket: Ticket, zone: Int): Double {
    var price = ticket.basePrice
    when (zone) {
        2 -> price *= zona2
        3 -> price *= zona3
    }
    println("Preu del bitllet: $price€")
    return price
}

fun payment(scanner: Scanner, ticketList: List<Ticket>, userTicket: Int, userZone: Int): Double {
    var money = 0.0
    val change: Double
    val userTicketObj: Ticket = ticketList[userTicket - 1]
    val price = calculatePrice(userTicketObj, userZone)

    while (money < price) {
        print("Introdueix l'import a pagar: ")

        val userMoney = checkDouble(scanner)

        if (isMoneyAllowed(userMoney)) {
            money += userMoney
            println("Import ingressat: $money")
            if (money < price) {
                println("Import restant: ${price - money}")
            }


        } else {
            println("Moneda o bitllet no vàlid. Torna a provar.")
        }
    }

    change = money - price
    return change
}


fun main() {
    val scanner = Scanner(System.`in`)
    val ticketList = createTicketList()

    var continueShopping: Boolean
    do {
        menu(scanner, ticketList)
        print("Vols comprar un altre bitllet? (si/no): ")
        continueShopping = scanner.next().toLowerCase() == "si"
    } while (continueShopping)

    println("Gràcies per utilitzar la màquina de venda. Adeu!")
}

fun menu(scanner: Scanner, ticketList: List<Ticket>) {
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
    val userTicket = getIntInRange(1, 5, scanner)

    println(
        """
        Ara selecciona la zona en la que vols viatjar:
        1. Zona 1
        2. Zona 2
        3. Zona 3
    """.trimIndent()
    )

    val userZone = getIntInRange(1, 3, scanner)
    val change = payment(scanner, ticketList, userTicket, userZone)
    println("El teu canvi és de $change€.")
}

fun printTicket(ticket: Ticket) {
    val date = LocalDate.now()
    println("""
        --------------TIQUET--------------
        |            $date               |
        |                                |
        |                                |
        Has comprat un bitllet ${ticket.name} 
        per ${ticket.basePrice}€.
        -----------------------------------
    """.trimIndent())
}

/*
fun calcularPrecio(opcion: Int, zona: Int): Double {
    val preciosBase = arrayOf(2.40, 11.35, 40.00, 70.00, 80.00)
    return if (opcion in 1..preciosBase.size) {
        val precioBase = preciosBase[opcion - 1]
        when (zona) {
            1 -> precioBase
            2 -> precioBase * 1.3125
            3 -> precioBase * 1.8443
            else -> 0.0
        }
    } else {
        0.0
    }
}

fun procesarCompra(opcion: Int, zona: Int, scanner: Scanner): Pair<Boolean, Double> {
    var compraExitosa = false
    var cambio = 0.0
    val precioTotal = calcularPrecio(opcion, zona)
    println("Preu total: %.2f€".format(precioTotal))

    var dineroIngresado = 0.0

    while (dineroIngresado < precioTotal) {
        print("Introdueixi diners (0.05€, 0.10€, 0.20€, 0.50€, 1€, 2€, 5€, 10€, 20€, 50€): ")
        val monedaBillete = scanner.nextDouble()

        if (esMonedaBilleteValido(monedaBillete)) {
            dineroIngresado += monedaBillete
            println("Diners actuals ingressats: %.2f€".format(dineroIngresado))
        } else {
            println("Moneda o bitllet no vàlid. Torni-ho a provar.")
        }
    }

    if (dineroIngresado >= precioTotal) {
        compraExitosa = true
        cambio = dineroIngresado - precioTotal
        println("Bitllet comprat! Canvi: %.2f€".format(cambio))
    } else {
        println("Diners insuficients. Torni-ho a intentar.")
    }
    return compraExitosa to cambio
}

fun esMonedaBilleteValido(valor: Double): Boolean {
    val monedasBilletesValidos = arrayOf(0.05, 0.10, 0.20, 0.50, 1.0, 2.0, 5.0, 10.0, 20.0, 50.0)
    return monedasBilletesValidos.contains(valor)
}

fun main() {
    val scanner = Scanner(System.`in`)
    val listaTickets = crearListaTickets()

    var seguirComprant: Boolean
    do {
        imprimirOpcionesTickets(listaTickets)
        print("Esculli una opció (introdueixi el número corresponent): ")
        val opcion = scanner.nextInt()

        if (opcion == 4321) {
            println("Màquina aturada")
            exitProcess(0)
        }

        if (opcion in 1..listaTickets.size) {
            print("Esculli una zona (1, 2 o 3): ")
            val zona = scanner.nextInt()

            if (zona in 1..3) {
                val (compraExitosa, _) = procesarCompra(opcion, zona, scanner)

                if (compraExitosa) {
                    print("Vol comprar un altre bitllet? (si/no): ")
                    seguirComprant = scanner.next().toLowerCase() == "si"
                } else {
                    seguirComprant = true
                }
            } else {
                println("Zona invàlida. Torni-ho a intentar.")
                seguirComprant = true
            }
        } else {
            println("Opció invàlida. Torni-ho a intentar.")
            seguirComprant = true
        }
    } while (seguirComprant)

    println("Gràcies per utilitzar la màquina de venda. Adeu!")
}

fun crearListaTickets(): List<Ticket> {
    return listOf(
        Ticket("Bitllet Senzill", 2.40),
        Ticket("T-Casual", 11.35),
        Ticket("T-Usual", 40.00),
        Ticket("T-Familiar", 70.00),
        Ticket("T-Jove", 80.00)
    )
}

fun imprimirOpcionesTickets(listaTickets: List<Ticket>) {
    println("Opcions disponibles:")
    listaTickets.forEachIndexed { index, ticket ->
        println("${index + 1}. ${ticket.name}")
    }
}*/