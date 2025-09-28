open class SmartDevice(val name: String) {
    var status: String = "off"

    open fun turnOn() {
        status = "on"
        println("$name is ON")
    }

    open fun turnOff() {
        status = "off"
        println("$name is OFF")
    }
}

class SmartLightDevice(name: String) : SmartDevice(name) {
    var brightness: Int = 50

    override fun turnOn() {
        super.turnOn()
        println("Brightness: $brightness%")
    }
}

fun main() {
    val lamp = SmartLightDevice("Desk Lamp")
    lamp.turnOn()
    lamp.turnOff()
}
