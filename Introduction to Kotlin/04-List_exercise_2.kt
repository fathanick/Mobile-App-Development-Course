fun main() {
    val cart = mutableListOf("Shoes", "T-shirt")

    cart.add("Hat")
    cart.add("Socks")

    cart.remove("T-shirt")

    println("Final cart items: $cart")
}
