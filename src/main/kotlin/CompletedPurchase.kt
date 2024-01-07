class CompletedPurchase (val ticket: Ticket, val zone: Int) {
    fun printTicket() {
        println("""
            |Títol: ${ticket.name}
            |Zona: $zone
            |Preu: ${ticket.calculatePrice(zone)}€
            --------------------
        """.trimIndent())
    }

}