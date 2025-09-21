// Function: show battery status message
fun batteryMessage(level: Int) {
    if (level >= 30) { 
        println("Battery is Good") 
    } else if (level >= 20) { 
        println("Battery is Low") 
    } else { 
        println("Battery Critical, Please Charge") 
    }
}

// Function: show battery countdown
fun showBattery(level: Int) {
    var current = level 
    while (current >= 0) { 
        println("Battery: ${current}%") 
        current-- 
        
        batteryMessage(current) 
    }
}

fun main() {
    val batteryLevel = 35 
    showBattery(batteryLevel)
}
