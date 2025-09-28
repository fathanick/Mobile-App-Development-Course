open class SmartDevice(val name: String, val category: String) {

    var status: String = "off"        // public getter + setter
    open fun turnOn()  { status = "on";  println("$name is ON") }
    open fun turnOff() { status = "off"; println("$name is OFF") }

}


class SmartTvDevice(name: String) : SmartDevice(name, "Smart TV") {
    override fun turnOn() {
        super.turnOn()                 // keep shared ON logic
        println("TV: display on")      // TV-specific behavior
    }
}

class SmartLightDevice(name: String) : SmartDevice(name, "Smart Light") {
    override fun turnOn() {
        super.turnOn()                 // keep shared ON logic
        println("Light: brightness set") // Light-specific behavior
    }
}

fun main() {
    val tv = SmartTvDevice("Living Room TV")
    val lamp = SmartLightDevice("Desk Lamp")

    println("TV:")
    tv.turnOn()
    tv.turnOff()
    
    println("\n")
    
    println("Lamp:")
    lamp.turnOn()
    lamp.turnOff()
}
