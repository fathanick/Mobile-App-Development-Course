fun main() {
    // Initial message counts
    var read = 120
    var unread = 45
    var spam = 10

    // 1. Arithmetic Operators
    val totalMessages = read + unread + spam
    println("Total messages: $totalMessages")

    val messagesWithoutSpam = totalMessages - spam
    println("Messages without spam: $messagesWithoutSpam")

    // 2. Increment & Decrement
    unread++   // new message arrives
    println("Unread after new message: $unread")

    unread--   // user reads one message
    println("Unread after reading one: $unread")

    // 3. Compound Assignment
    spam += 5   // 5 new spam messages
    println("Spam after new spam: $spam")

    spam -= 3   // user deletes 3 spam messages
    println("Spam after cleanup: $spam")
}
