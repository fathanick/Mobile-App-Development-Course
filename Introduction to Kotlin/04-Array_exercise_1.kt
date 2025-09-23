fun main() {
    val numbers = intArrayOf(5, 10, 15, 20, 25)

    var sum = 0
    for (n in numbers) {
        sum += n
    }

    println("Numbers: ${numbers.joinToString()}")
    println("Sum = $sum")
}
