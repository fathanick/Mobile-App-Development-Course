fun login(username: String, password: String): Boolean {
    return username == "admin" && password == "1234"
}

fun main() {
    val user = "admin"
    val pass = "1234"

    if (login(user, pass)) {
        println("Login successful")
    } else {
        println("Invalid credentials")
    }
}
