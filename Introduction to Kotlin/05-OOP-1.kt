class SmartDevice(val name: String, val category: String) {
    var deviceStatus = "online"

    // secondary constructor: map status code to text
    constructor(name: String, category: String, statusCode: Int)
        : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }
}

fun main() {
    val tv = SmartDevice("Android TV", "Entertainment")     // primary ctor
    val plug = SmartDevice("Smart Plug", "Home", 0)         // secondary ctor

    println("${tv.name} / ${tv.category} / ${tv.deviceStatus}")
    println("${plug.name} / ${plug.category} / ${plug.deviceStatus}")
}
