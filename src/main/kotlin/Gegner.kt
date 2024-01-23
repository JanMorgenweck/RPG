open class Gegner(name:String, HP:Int) {



    //    Variablen Gegner
    var gegnername = name
    var gegnerHP = HP
    var istGegnerBesiegt = false
    open val maxHP = HP
    open fun zufaelligeAttacke(gegner:MutableList<Gegner>, helden: MutableList<Held>){

    }
    fun gegnerHpVerlieren(hpabzug: Int) {
        gegnerHP -= hpabzug
        if (this.gegnerHP <= 0) {
            istGegnerBesiegt = true
            println("$gegnername ist besiegt.")
        } else {
            println("$gegnername hat noch $gegnerHP HP.")
        }
    }
}