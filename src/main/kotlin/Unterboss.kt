import kotlin.random.Random

class Unterboss(name: String, HP: Int,
                var heilung :Int = 20,
                var angriffsplus :Int = 15,
                var kugelflamme :Int = 25,
                var klauenhieb :Int = 16) : Gegner(name, HP) {


    override var maxHP = HP

    // Die Namen der Aktionen werden in einer Liste gespeichert.
    var aktionen = listOf("heilung", "angriffsplus", "kugelflamme", "klauenhieb")

    override fun zufaelligeAttacke(gegner: MutableList<Gegner>, helden: MutableList<Held>) {
        var aktion = aktionen.random()
        if (gegnerHP > 0) {
            when (aktion) {

                // Heilung des Drachen
                "heilung" -> {
                    if (gegner[0].gegnerHP + heilung > gegner[0].maxHP) {
                        gegner[0].gegnerHP = gegner[0].maxHP
                    } else {
                        gegner[0].gegnerHP += heilung
                    }
                    Thread.sleep(500)
                    println()
                    println("$gegnername hat ${gegner[0].gegnername} mit $heilung HP geheilt. ${gegner[0].gegnername} hat jetzt ${gegner[0].gegnerHP} HP.")
                    println("\n___________________________________________________")
                }

                // Erhöhung der Drachenangriffe
                "angriffsplus" -> {
                    if (gegner[0] is Drache) {
                        val drache = gegner[0] as Drache
                        drache.feueratem += angriffsplus
                        drache.prankenschlag += angriffsplus
                        Thread.sleep(500)
                        println()
                        println("$gegnername hat die Angriffsstärke von ${drache.gegnername} um $angriffsplus erhöht.")
                        println("\n___________________________________________________")
                    }
                }

                // Angriffe auf einen zufälligen Helden
                "kugelflamme", "klauenhieb" -> {
                    val zufaelligerHeld = helden.random()
                    val schaden = if (aktion == "kugelflamme" || aktion == "klauenhieb") kugelflamme else klauenhieb
                    Thread.sleep(500)
                    println()
                    println("$gegnername hat ${zufaelligerHeld.charakterName} mit $aktion angegriffen.")
                    zufaelligerHeld.hpVerlieren(schaden)
                    println("\n___________________________________________________")
                }
            }
        }
    }
}