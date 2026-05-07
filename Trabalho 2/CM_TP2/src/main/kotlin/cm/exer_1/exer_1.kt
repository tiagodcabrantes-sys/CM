package cm.exer_1

sealed class Event{
    data class Login(val username: String, val timestamp: Long) : Event()
    data class Purchase(val username: String, val amount: Double, val timestamp: Long) : Event()
    data class Logout(val username: String, val timestamp: Long) : Event()

}

fun List<Event>.filterByUser(username: String): List<Event>{
    return this.filter{ event ->
        if (event is Event.Login){
            event.username == username
        } else if(event is Event.Purchase){
            event.username == username
        } else if(event is Event.Logout){
            event.username == username
        } else{
            false
        }
    }
}

fun List<Event>.totalSpent(username: String) : Double{
    return this
        .filterIsInstance<Event.Purchase>()
        .filter { purchase -> purchase.username == username}
        .sumOf { purchase -> purchase.amount}


}

fun processEvents(events: List<Event>,handler:(Event) -> Unit){
    events.forEach{ event -> handler(event)}
}

fun main() {

    val events = listOf(
        Event.Login("alice", 1_000),
        Event.Purchase("alice", 49.99, 1_100),
        Event.Purchase("bob", 19.99, 1_200),
        Event.Login("bob", 1_050),
        Event.Purchase("alice", 15.00, 1_300),
        Event.Logout("alice", 1_400),
        Event.Logout("bob", 1_500)
    )

    processEvents(events) { event ->
        when (event) {
            is Event.Login -> {
                println("[LOGIN] ${event.username} logged in at t=${event.timestamp}")
            }

            is Event.Purchase -> {
                println("[PURCHASE] ${event.username} spent $${event.amount} at t=${event.timestamp}")
            }

            is Event.Logout -> {
                println("[LOGOUT] ${event.username} logged out at t=${event.timestamp}")
            }
        }
    }

    println("Total spent by Alice: $${events.totalSpent("Alice")}")
    println("Total spent by Bob: $${events.totalSpent("Bob")}")

    println("Events for Alice: ")
    events.filterByUser("alice").forEach{event -> println(event)}
}