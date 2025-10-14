fun main() {
    // Initial values
    var completed = 50
    var cancelled = 8
    var ongoing = 2

    // Arithmetic
    val totalTrips = completed + cancelled + ongoing
    println("Total trips: $totalTrips")

    val successRate = (completed * 100) / totalTrips
    println("Success rate: $successRate%")

    // Increment / Decrement
    ongoing++   // new trip starts
    println("Ongoing after new trip: $ongoing")

    ongoing--   // one trip completed
    println("Ongoing after one completed: $ongoing")

    // Compound assignment
    cancelled += 2   // system update added cancellations
    println("Cancelled after update: $cancelled")

    completed -= 3   // refunded rides
    println("Completed after refunds: $completed")
}
