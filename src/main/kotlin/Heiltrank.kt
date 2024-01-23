class Heiltrank(var name :String = "Heiltrank",var heilung:Int = 25) {
fun trank(held: Held){
    if (held.charakterHP + heilung > held.MAX_HP) {
        held.charakterHP = held.MAX_HP
    } else {
        held.charakterHP = held.charakterHP + heilung
    }
    println("${held.charakterName} hat einen Heiltrank benutz. Es werden $heilung HP wieder hergestellt")
    println("${held.charakterName} hat nun ${held.charakterHP}")
    println()
}
}