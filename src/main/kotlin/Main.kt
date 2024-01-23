import Farben.*




var unterboss = Unterboss("$cyan Drakonis$reset", 300)

fun main() {

    val magier = Magier("$blau Seraphina die Magierin$reset", 200)
    val krieger = Krieger("$gruen Eisenfaust der Krieger$reset", 300)
    val schuetze = Schuetze("$gelb Falkenauge der Schütze$reset", 250)
    var helden = mutableListOf(magier, krieger, schuetze)

    unterboss = Unterboss("$cyan Drakonis$reset", 300)
    val drache = Drache("$rot Azurion$reset", 750)
    var gegner:MutableList<Gegner> = mutableListOf(drache)

    var beutel:MutableList<Heiltrank> = mutableListOf(Heiltrank(),Heiltrank(),Heiltrank(),Heiltrank())
    Thread.sleep(500)
    println("""                            
               .:'                                 `:.                                    
              ::'              Art by               `::                                   
             :: :.      Ronald Allan Stanions      .: ::                                  
              `:. `:.             .             .:'  .:'                                   
               `::. `::           !           ::' .::'                                     
                   `::.`::.    .' ! `.    .::'.::'                                         
                    `::.  `::::'':!:``::::'   ::'                                          
                     :'*:::.  .:' ! `:.  .:::*`:                                           
                    :: HHH::.   ` ! '   .::HHH ::                                          
                   ::: `H TH::.  `!'  .::HT H' :::                                         
                   ::..  `THHH:`:   :':HHHT'  ..::                                         
                   `::      `T: `. .' :T'      ::'                                         
                     `:. .   :         :   . .:'                                           
                       `::'               `::'                                             
                         :'  .`.  .  .'.  `:                                               
                         :' ::.       .:: `:                                               
                         :' `:::     :::' `:                                               
                          `.  ``     ''  .'                                                
                           :`...........':                                                 
                           ` :`.     .': '                                                 
                            `: `"'"'"' :'
                              
                Willkommen zum fröhlichen Drachenjagen 
                
                
              Helden, der Drache${drache.gegnername} ist erschienen!
           
                Macht euch bereit und vernichtet ihn.""")

    println("""
        
  / \
  | |                                                           /`.
  |.|                                                          /   :.
  |.|                                                         /     \\ 
  |:|      __                                              ,;/,      :: 
,_|:|_,   /  )                           /^\           ___:c/.(      ||
  (Oo    / _I_/                     /\   "V"         ,'  _|:)>>>--,-'B)>
   +\ \  || __|                    /__\   I         (  '---'\--'` _,'|| 
      \ \||___|                   //..\\  I          `--.    \ ,-'   ;;
        \ /.:.\-\                 \].`[/  I              |    \|    // 
         |.:. /-----\              l\/j\  (]             |     \   ;' 
         |___|::oOo::|           /. ~~ ,\/I              |_____|\,'  
         /   |:<_T_>:|           \\L__j^\/I              :     :  
        |_____\ ::: /             \/--v}  I              |  ,  |  
         | |  \ \:/               |    |  I              | : \ : 
         | |   | |                |    |  I              | | : : 
         \ /   | \___             |    l  I              | | | | 
         / |   \_____\          _/j  L l\_!              | | |_`. 
         `-'                                             '--`
    """.trimIndent())
    println()
    Thread.sleep(500)
    while (helden.any {!it.istCharakterBesiegt && gegner.isNotEmpty()}){
        attacke(helden, gegner, beutel)
    }

    println("Willst du nochmal Spielen? j/n")
    val antwort = readln()
    if (antwort == "j") {
        main()
    } else {
        println("Auf Wiedersehen!")
    }
}
