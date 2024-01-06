import java.util.Scanner
import kotlin.system.exitProcess


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
}

