import java.util.*
import kotlin.random.Random

/**
 *      Contains utility functions used in the game.
 * The functions are static and can be called from any class.
 * @authors Nikita Barbosa, Omar Zouaoui, Fabián Gómez.
 */

/**
 *     Checks if the user input is an int.
 * If the input is not an int, the user is asked to input a new value.
 * @param sc Scanner for user input.
 */

fun checkInt(sc: Scanner): Int {
    while (true) {
        if (sc.hasNextInt()) {
            return sc.nextInt()
        } else {
            println("Inválido: no es un número. Vuelve a introducir:")
            sc.next()
        }
    }
}

/**
 *     Checks if the user input is a double.
 * If the input is not an int, the user is asked to input a new value.
 * @param sc Scanner for user input.
 */
fun checkDouble(sc: Scanner): Double {
    while (true) {
        if (sc.hasNextDouble()) {
            return sc.nextDouble()
        } else {
            println("Invàlid: no es un numero. Introdueix un enter:")
            sc.next()
        }
    }
}

/**
 *    Checks if the user input is an int within a given range.
 * If the input is not an int or is not within the range, the user is asked to input a new value.
 * @param startInt The lower bound of the range.
 * @param endInt The upper bound of the range.
 */
fun getIntInRange(startInt: Int, endInt: Int, sc: Scanner): Int {
    while (true) {
        if (sc.hasNextInt()) {
            val userNumber = sc.nextInt()
            if (userNumber in startInt..endInt) {
                return userNumber
            }
            println("Invàlid: no está entre les opcions. Introdueix un numero entre $startInt i $endInt:")
        } else {
            println("Invàlid: no es un ente. Introdueix un numero entre $startInt i $endInt:")
            sc.next()
        }
    }
}

