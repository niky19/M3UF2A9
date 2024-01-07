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
    fun `calculateChange returns correct change`() {
        val result = calculateChange(3.0, 2.4)
        assertEquals(0.6, result)
    }

    @Test
    fun `calculateTotalPrice returns correct total price`() {
        val completedTickets = mutableListOf(
            CompletedPurchase(Ticket("Bitllet Senzill", 2.40), 1),
            CompletedPurchase(Ticket("T-Casual", 11.35), 1),
            CompletedPurchase(Ticket("T-Usual", 40.00), 1)
        )
        val result = calculateTotalPrice(completedTickets)
        assertEquals(53.75, result)
    }

    @Test
    fun `isCartFull returns true when cart is full`() {
        val cart = mutableListOf(
            CompletedPurchase(Ticket("Bitllet Senzill", 2.40), 1),
            CompletedPurchase(Ticket("T-Casual", 11.35), 1),
            CompletedPurchase(Ticket("T-Usual", 40.00), 1)
        )
        val result = isCartFull(cart)
        assertTrue(result)
    }

    @Test
    fun `isCartFull returns false when cart is not full`() {
        val cart = mutableListOf(
            CompletedPurchase(Ticket("Bitllet Senzill", 2.40), 1),
            CompletedPurchase(Ticket("T-Casual", 11.35), 1)
        )
        val result = isCartFull(cart)
        assertFalse(result)
    }
}