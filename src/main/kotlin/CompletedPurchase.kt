class CompletedPurchase (val ticket: Ticket, val zone: Int) {
    fun printTicket() {
        println("Has comprat un bitllet ${ticket.name} per a la zona $zone.")
    }

}