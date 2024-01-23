class Schuetze(name: String, HP: Int) : Held(name, HP) {


    var normalerSchuss = 25
    var praesiserSchuss = 35
    var flaechenschuss = 40
    override var MAX_HP = HP

    var alleAttacken = mutableListOf(
        normalerSchuss,
        praesiserSchuss,
        flaechenschuss

    )

    override fun attacke(gegner: MutableList<Gegner>, beutel: MutableList<Heiltrank>, helden: MutableList<Held>) {
        if (!istCharakterBesiegt) {
            println()
            println("${charakterName}, du bist dran. Wähle weise.")
            println()
            println(" 1 -> normaler Schuss")
            println(" 2 -> präziser Schuss")
            println(" 3 -> Flächenschuss")
            println()
            println(" 5 -> Heiltrank")

            var aktion = readln().toInt()

            // Gegner angreifen mit normalen Schuss
            if (aktion == 1) {
                val unterboss = gegner.firstOrNull { it.gegnername == unterboss.gegnername }
                if (unterboss != null && unterboss.gegnerHP > 0){
                    println("'Mein Pfeil wird dich durchbohren!'")
                    println("$charakterName hat mit normaler Schuss angegriffen und ${alleAttacken[1 -1]} dmg gemacht.")
                    unterboss.gegnerHpVerlieren(hpabzug = alleAttacken[1 -1])
                    println("\n___________________________________________________")
                }else {
                    println("'Mein Pfeil wird dich durchbohren!'")
                    println("$charakterName hat mit normaler Schuss angegriffen und ${alleAttacken[1 -1]} dmg gemacht.")
                    gegner.random().gegnerHpVerlieren(hpabzug = alleAttacken[1 -1])
                    println("\n___________________________________________________")
                }
            }

            // Gegner angreifen mit präziser Schuss
            if (aktion == 2) {
                val unterboss = gegner.firstOrNull { it.gegnername == unterboss.gegnername }
                if (unterboss != null && unterboss.gegnerHP > 0){
                    println("'Mein Pfeil trifft immer!'")
                    println("$charakterName hat mit präziser Schuss angegriffen und ${alleAttacken[2 -1]} dmg gemacht.")
                    unterboss.gegnerHpVerlieren(hpabzug = alleAttacken[2 -1])
                    println("\n___________________________________________________")
                }else {
                    println("'Mein Pfeil trifft immer!'")
                    println("$charakterName hat mit präziser Schuss angegriffen und ${alleAttacken[2 -1]} dmg gemacht.")
                    gegner.random().gegnerHpVerlieren(hpabzug = alleAttacken[2 -1])
                    println("\n___________________________________________________")
                }
            }
            // Angriff auf Drache, oder auf Drache und Unterboss
            if (aktion == 3) {
                println("'Meine Pfeile werden euch treffen!'")
                println("$charakterName greift mit Flächenschuss an und verursacht ${alleAttacken[3 - 1]} dmg!")
                if (gegner.any { it.gegnername == unterboss.gegnername && it.gegnerHP > 0}) {
                    gegner.forEach { it.gegnerHpVerlieren(flaechenschuss) }
                    println("\n___________________________________________________")
                } else {
                    println("'Meine Pfeile werden dich treffen'")
                    gegner[0].gegnerHpVerlieren(flaechenschuss)
                    println("\n___________________________________________________")
                }
            }
            // Heiltrank nutzen
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