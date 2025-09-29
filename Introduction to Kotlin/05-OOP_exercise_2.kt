open class SmartDevice(val name: String, val category: String) {
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

class SmartTvDevice(name: String) : SmartDevice(name, "Smart TV") {

    var speakerVolume: Int = 5
    var channelNumber: Int = 1

    override fun turnOn() {
        super.turnOn()
        println("TV: display on")
    }

    fun increaseVolume() {
        if (speakerVolume < 100) speakerVolume++
        println("TV volume: $speakerVolume")
    }

    fun nextChannel() {
        channelNumber++
        println("TV channel: $channelNumber")
    }

    override fun turnOff() {
        println("TV: shutting down")
        super.turnOff()
    }
}

class SmartLightDevice(name: String) : SmartDevice(name, "Smart Light") {

    var brightnessLevel: Int = 50 

    override fun turnOn() {
        super.turnOn()
        println("Light: brightness set to $brightnessLevel%")
    }

    fun setBrightness(level: Int) { // method name kept the same
        brightnessLevel = level.coerceIn(0, 100)
        println("Light: brightness set to $brightnessLevel%")
    }

    override fun turnOff() {
        println("Light: turning off")
        super.turnOff()
    }
}

fun main() {
    val tv = SmartTvDevice("Living Room TV")
    val lamp = SmartLightDevice("Desk Lamp")

    tv.turnOn()
    tv.nextChannel()
    tv.increaseVolume()
    tv.turnOff()

    lamp.turnOn()
    lamp.setBrightness(80) 
    lamp.turnOff()
}
