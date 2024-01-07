import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*


class MachineTest {

    @Test
    fun isMoneyAllowedWithAllowedMoney() {
        val result = isMoneyAllowed(0.05)
        assertTrue(result)
    }

    @Test
    fun isMoneyAllowedWithNotAllowedMoney() {
        val result = isMoneyAllowed(0.03)
        assertFalse(result)
    }

    @Test
    fun isMoneyAllowedWithNegativeNumbers() {
        val result = isMoneyAllowed(-0.05)
        assertFalse(result)
    }


    @Test
    fun calculateChangeReturnsCorrectChange() {
        val result = calculateChange(5.0, 2.4)
        assertEquals(2.6, result)
    }

    @Test
    fun calculateTotalPriceReturnsCorrect() {
        val completedTickets = mutableListOf(
            CompletedPurchase(Ticket("Bitllet Senzill", 2.40), 1),
            CompletedPurchase(Ticket("T-Casual", 11.35), 1),
            CompletedPurchase(Ticket("T-Usual", 40.00), 1)
        )
        val result = calculateTotalPrice(completedTickets)
        assertEquals(53.75, result)
    }

    @Test
    fun isCartFullWith3Purchases() {
        val cart = mutableListOf(
            CompletedPurchase(Ticket("Bitllet Senzill", 2.40), 1),
            CompletedPurchase(Ticket("T-Casual", 11.35), 1),
            CompletedPurchase(Ticket("T-Usual", 40.00), 1)
        )
        val result = isCartFull(cart)
        assertTrue(result)
    }

    @Test
    fun isCartFullWith4Purchases() {
        val cart = mutableListOf(
            CompletedPurchase(Ticket("Bitllet Senzill", 2.40), 1),
            CompletedPurchase(Ticket("T-Casual", 11.35), 1),
            CompletedPurchase(Ticket("T-Casual", 11.35), 1),
            CompletedPurchase(Ticket("T-Usual", 40.00), 1)
        )
        val result = isCartFull(cart)
        assertTrue(result)
    }
    @Test
    fun isCartFullWithEmptyCart() {
        val cart = mutableListOf(
            CompletedPurchase(Ticket("Bitllet Senzill", 2.40), 1),
            CompletedPurchase(Ticket("T-Casual", 11.35), 1)
        )
        val result = isCartFull(cart)
        assertFalse(result)
    }
}