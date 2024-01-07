import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val ticketList = createTicketList()
    while (true) {
        initMachine(scanner, ticketList)
    }

}