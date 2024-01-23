class Krieger(name: String, HP: Int) : Held(name, HP) {

    var schwerthieb = 30
    var schildschlag = 25
    var maechtigerSchwerthieb = 45
    override val MAX_HP = HP

    var alleAttacken = mutableListOf(
        schwerthieb,
        schildschlag,
        maechtigerSchwerthieb

    )

    override fun attacke(gegner: MutableList<Gegner>, beutel:MutableList<Heiltrank>, helden:MutableList<Held>) {
        if (!istCharakterBesiegt) {
            println()
            println("${charakterName}, du bist dran. Wähle weise.")
            println()
            println(" 1 -> Schwerthieb")
            println(" 2 -> Schildschlag")
            println(" 3 -> mächtiger Schwerthieb")
            println()
            println(" 5 -> Heiltrank")

            var aktion = readln().toInt()

            // Attacken auf Gegner mit Schwerthieb
            if (aktion == 1) {
                val unterboss = gegner.firstOrNull { it.gegnername == unterboss.gegnername }
                if (unterboss != null && unterboss.gegnerHP > 0){
                    println("'Mein Schwert wird dir das Fürchten lehren!'")
                    println("$charakterName hat mit Schwerthieb angegriffen und ${alleAttacken[1 -1]} dmg gemacht.")
                    unterboss.gegnerHpVerlieren(hpabzug = alleAttacken[1 -1])
                    println("\n___________________________________________________")
                }else {
                    println("'Mein Schwert wird dir das Fürchten lehren!'")
                    println("$charakterName hat mit Schwerthieb angegriffen und ${alleAttacken[1 -1]} dmg gemacht.")
                    gegner.random().gegnerHpVerlieren(hpabzug = alleAttacken[1 -1])
                    println("\n___________________________________________________")
                }
            }
            // Attacken auf Gegner mit Schildschlag
            if (aktion == 2) {
                val unterboss = gegner.firstOrNull { it.gegnername == unterboss.gegnername }
                if (unterboss != null && unterboss.gegnerHP > 0){
                    println("'Mein Schild ist unzerstörbar!'")
                    println("$charakterName hat mit Schildschlag angegriffen und ${alleAttacken[2 -1]} dmg gemacht.")
                    unterboss.gegnerHpVerlieren(hpabzug = alleAttacken[2 -1])
                    println("\n___________________________________________________")
                }else {
                    println("'Mein Schild ist unzerstörbar!'")
                    println("$charakterName hat mit Schildschlag angegriffen und ${alleAttacken[2 -1]} dmg gemacht.")
                    gegner.random().gegnerHpVerlieren(hpabzug = alleAttacken[2 -1])
                    println("\n___________________________________________________")
                }
            }
            // Attacken auf Gegner mit mächtiger Schwerthieb
            if (aktion == 3) {
                val unterboss = gegner.firstOrNull { it.gegnername == unterboss.gegnername }
                if (unterboss != null && unterboss.gegnerHP > 0){
                    println("'Mein mächtiges Schwert wird dir das Fürchten lehren!'")
                    println("$charakterName hat mit mächtiger Schwerthieb angegriffen und ${alleAttacken[3 -1]} dmg gemacht.")
                    unterboss.gegnerHpVerlieren(hpabzug = alleAttacken[3 -1])
                    println("\n___________________________________________________")
                }else {
                    println("'Mein mächtiges Schwert wird dir das Fürchten lehren!'")
                    println("$charakterName hat mit mächtiger Schwerthieb angegriffen und ${alleAttacken[3 -1]} dmg gemacht.")
                    gegner.random().gegnerHpVerlieren(hpabzug = alleAttacken[3 -1])
                    println("\n___________________________________________________")
                }
            }

            // Heiltrank nutzen
            if (aktion == 5) {
                var index= beutel.lastIndex
                var gewaehlterTrank = beutel.elementAt(index)
                gewaehlterTrank.trank(this)
                beutel.removeAt(index)
                println("\n___________________________________________________")
            }
        }
    }
}