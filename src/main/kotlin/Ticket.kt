import java.util.*

/**
 * Representa el títol de transport.
 * @param name: nom del títol de transport.
 * @param basePrice: preu base del títol de transport.
 * @author Daniel Reinosa, Joel Montalvan, Nikita Barbosa
 */
class Ticket(val name: String, val basePrice: Double) {
    fun calculatePrice(zone: Int): Double {
        var price = basePrice
        when (zone) {
            2 -> price *= zona2
            3 -> price *= zona3
        }
        return price
    }

}