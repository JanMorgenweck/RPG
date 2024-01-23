import Farben.cyan
import Farben.reset
import Farben.rot
import kotlin.random.Random

class Drache(
    name: String, HP: Int,
    var feueratem: Int = 40,
    var prankenschlag: Int = 30,
    var feuerball: Int = 35,
    var drachenstoss: Int = 45
) : Gegner(name, HP) {

    var hatBeschworen = false
    override val maxHP = HP

    override fun zufaelligeAttacke(gegner: MutableList<Gegner>, helden: MutableList<Held>) {

        // Unterboss beschwören
        if (!istGegnerBesiegt) {
            if (this.gegnerHP <= 300 && !hatBeschworen) {
                println("$rot $gegnername$reset hat $cyan ${unterboss.gegnername} beschworen!")
                gegner.add(unterboss)
                hatBeschworen = true


            } else {
                val zufaelligerHeld = helden[Random.nextInt(helden.size)]
                val zufaelligeAttacke = Random.nextInt(5)
                when (zufaelligeAttacke) {

                    // Angriff auf alle Helden mit Feueratem
                    0 -> {
                        Thread.sleep(500)
                        println()
                        println("'Brennt ihr Helden!'")
                        println("$gegnername greift mit Feueratem an!")
                        helden.forEach { it.hpVerlieren(feueratem) }
                        println("\n___________________________________________________")
                    }

                    // Angriff auf zufälligen Helden mit Prankenschlag
                    1 -> {
                        Thread.sleep(500)
                        println()
                        println("$gegnername greift mit Prankenschlag an!")
                        zufaelligerHeld.hpVerlieren(prankenschlag)
                        println("\n___________________________________________________")
                    }

                    // Angriff auf zufälligen Helden, Fluch wirkt solange bis held nur noch 20% seiner max.HP hat.
                    // Es werden 10% HP des Helden abgezogen pro Runde
                    2 -> {
                        Thread.sleep(500)
                        println()
                        if (zufaelligerHeld.charakterHP > zufaelligerHeld.MAX_HP * 0.2) {
                            println("'Verflucht sollst du sein!'")
                            println("$gegnername benutzt Fluch!")
                            print("${zufaelligerHeld.charakterName} wurde verflucht und hat noch ${zufaelligerHeld.charakterHP} HP!")
                            zufaelligerHeld.istVerflucht = true
                            println("\n___________________________________________________")
                        }
                    }
                    // Einzelangriff auf zufälligen Helden mit Feuerball
                    3 -> {
                        Thread.sleep(500)
                        println()
                        println("'Verbrenne!'")
                        println("$gegnername greift mit Feuerball an!")
                        zufaelligerHeld.hpVerlieren(feuerball)
                        println("\n___________________________________________________")
                    }
                    //Angriff auf alle Helden mit Drachenstoss
                    4 -> {
                        Thread.sleep(500)
                        println()
                        println("'Bebt vor meiner Macht!'")
                        println("$gegnername greift mit Drachenstoss an")
                        helden.forEach { it.hpVerlieren(drachenstoss) }
                        println("\n___________________________________________________")
                    }
                }
            }
        }
    }
}




