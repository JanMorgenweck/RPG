class Magier(name: String, HP: Int) : Held(name, HP) {

    var heilzauber = 100
    var frostzauber = 35
    var feuerzauber = 25
    var blitzzauber = 40

    override val MAX_HP = HP

    var alleAttacken = mutableListOf<Int>(
        heilzauber,
        frostzauber,
        feuerzauber,
        blitzzauber

    )


    override fun attacke(gegner: MutableList<Gegner>, beutel: MutableList<Heiltrank>, helden: MutableList<Held>) {
        if (!istCharakterBesiegt) {
            println()
            println("${charakterName}, du bist dran. Wähle weise.")
            println()
            println(" 1 -> Heilzauber")
            println(" 2 -> Frostzauber")
            println(" 3 -> Feuerzauber")
            println(" 4 -> Blitzzauber")
            println(" 5 -> Heiltrank")


            val aktion = readln().toInt()

            // Helden mit der kleinsten HP heilen aber nicht höher als die maximale HP des Charakters
            if (aktion == 1) {
                val heldMitkleinsterHP = helden.minBy { it.charakterHP }

                    if (heldMitkleinsterHP.charakterHP + heilzauber > MAX_HP) {
                        heldMitkleinsterHP.charakterHP = MAX_HP
                    } else {
                        heldMitkleinsterHP.charakterHP += heilzauber
                    }
                    println(" 'Vulnera Sanentur' ")
                    println("$charakterName hat Heilzauber angewendet und ${heldMitkleinsterHP.charakterName} hat $heilzauber HP dazu bekommen und hat nun ${heldMitkleinsterHP.charakterHP}.")
                    println(charakterHP)
                println("\n___________________________________________________")
                }

            // Attacken auf Gegner mit Frostzauber
            if (aktion == 2) {
                val unterboss = gegner.firstOrNull { it.gegnername == unterboss.gegnername }
                if (unterboss != null && unterboss.gegnerHP > 0){
                    println(" 'Glacius' ")
                    println("$charakterName hat mit Frostzauber angegriffen und ${alleAttacken[2 -1]} dmg gemacht.")
                    unterboss.gegnerHpVerlieren(hpabzug = alleAttacken[2 -1])
                    println("\n___________________________________________________")

                }else {
                    println(" 'Glacius' ")
                    println("$charakterName hat mit Frostzauber angegriffen und ${alleAttacken[2 -1]} dmg gemacht.")
                    gegner.random().gegnerHpVerlieren(hpabzug = alleAttacken[2 -1])
                    println("\n___________________________________________________")

                }
            }

            // Attacke auf Gegner mit Feuerzauber
            if (aktion == 3){
                val unterboss = gegner.firstOrNull { it.gegnername == unterboss.gegnername }
                if (unterboss != null && unterboss.gegnerHP > 0){
                    println(" 'Incendio' ")
                    println("$charakterName hat mit Feuerzauber angegriffen und ${alleAttacken[3 -1]} dmg gemacht.")
                    unterboss.gegnerHpVerlieren(hpabzug = alleAttacken[3 -1])
                    println("\n___________________________________________________")

                }else {
                    println(" 'Incendio' ")
                    println("$charakterName hat mit Feuerzauber angegriffen und ${alleAttacken[3 -1]} dmg gemacht.")
                    gegner.random().gegnerHpVerlieren(hpabzug = alleAttacken[3 -1])
                    println("\n___________________________________________________")

                }
            }
            // Attacke auf Gegner mit Blitzzauber
            if (aktion == 4){
                val unterboss = gegner.firstOrNull { it.gegnername == unterboss.gegnername }
                if (unterboss != null && unterboss.gegnerHP > 0){
                    println(" 'Stupor' ")
                    println("$charakterName hat mit Blitzzauber angegriffen und ${alleAttacken[4 -1]} dmg gemacht.")
                    unterboss.gegnerHpVerlieren(hpabzug = alleAttacken[4 -1])
                    println("\n___________________________________________________")

                }else {
                    println(" 'Stupor' ")
                    println("$charakterName hat mit Blitzzauber angegriffen und ${alleAttacken[4 -1]} dmg gemacht.")
                    gegner.random().gegnerHpVerlieren(hpabzug = alleAttacken[4 -1])
                    println("\n___________________________________________________")

                }
            }
            // Heiltrank benutzen
            if (aktion == 5) {
                var index = beutel.lastIndex
                var gewaehlterTrank = beutel.elementAt(index)
                gewaehlterTrank.trank(this)
                beutel.removeAt(index)
                println("\n___________________________________________________")
            }
        }
    }
}


