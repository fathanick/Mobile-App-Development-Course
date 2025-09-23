fun main() {
    val notifications = arrayOf(5, 8, 2, 10, 4, 7, 6)

    println("Unread notifications per day:")
    for (n in notifications) {
        println(n)
    }

    val total = notifications.sum()
    println("Total notifications this week: $total")
}
