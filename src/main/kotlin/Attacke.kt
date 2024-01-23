fun attacke(helden: MutableList<Held>, gegner:MutableList<Gegner>, beutel:MutableList<Heiltrank>) {

    // Die Helden greifen zuerst an
    helden.forEach { held ->
        if(!held.istCharakterBesiegt && gegner.isNotEmpty()) held.attacke(gegner,beutel,helden)
        gegner.removeAll { it.gegnerHP <= 0 }
    }

    // Überprüfen Sie, ob der Gegner nach den Angriffen der Helden besiegt wurde.
    if (gegner.isEmpty()) {
        println("Die Helden haben alle Gegner besiegt!")
        println("Die Welt ist nun wieder sicherer!")
        println("Unsere Helden werden gefeiert und bekommen ein Denkmal gesetzt.")
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
        println("\n___________________________________________________")
        return
    }

    // Der Gegner greift einen zufälligen Helden an
    if (gegner.contains(unterboss)){
        if (!gegner[0].istGegnerBesiegt){
            gegner[0].zufaelligeAttacke(gegner,helden)
        }
        if (!gegner[1].istGegnerBesiegt){
            gegner[1].zufaelligeAttacke(gegner,helden)
        }
    }else {
        if (!gegner[0].istGegnerBesiegt){
            gegner[0].zufaelligeAttacke(gegner,helden)
        }
    }

    // Überprüfen Sie, ob alle Helden nach dem Angriff des Gegners besiegt wurden.
    if (helden.all { it.istCharakterBesiegt }) {
        println("Der Gegner hat alle Helden besiegt!")
        println("Der Terror der Drachen geht weiter!")
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
                                 """)


        println("\n___________________________________________________")
        return
    }
}
