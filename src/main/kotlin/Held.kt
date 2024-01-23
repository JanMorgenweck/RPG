open class Held(name: String, HP: Int) {




    //    Variablen Helden
    var charakterName = name
    var charakterHP = HP
    var istCharakterBesiegt = false
    var istVerflucht = false
    var fluch : Double = 0.1
    open val MAX_HP = HP



    open fun attacke(gegner: MutableList<Gegner>, beutel:MutableList<Heiltrank>, helden:MutableList<Held>) {

        // Fluch des Drachens
        if (istVerflucht){
            this.hpVerlieren((MAX_HP * fluch).toInt())
        }
    }

    fun hpVerlieren(hpabzug: Int) {
        charakterHP -= hpabzug
        if (this.charakterHP <= 0) {
            istCharakterBesiegt = true
            println("$charakterName ist besiegt.")
        } else {
            println("$charakterName hat noch $charakterHP HP.")
        }
    }
}