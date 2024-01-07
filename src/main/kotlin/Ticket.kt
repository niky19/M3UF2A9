import java.util.*

class Ticket(val name: String, val basePrice: Double) {
    fun calculatePrice(zone: Int): Double {
        var price = basePrice
        when (zone) {
            2 -> price *= zona2
            3 -> price *= zona3
        }
        println("Preu del bitllet: $price€")
        return price
    }

}