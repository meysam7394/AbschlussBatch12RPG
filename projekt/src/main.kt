fun main() {
    val hero1 = Hero1("Hero1", 100)
    val hero2 = Hero2("Hero2", 100)
    val hero3 = Hero3("Hero3", 100)

    val finalBoss = FinalBoss("Final Boss", 120)
    val underBoss = UnderBoss("UnderBoss", 50)

    val heroes = listOf(hero1, hero2, hero3)

// Hier wird überprüft, ob mindestens ein Held im Spiel ist (deren HP größer als 0 ist)
// und entweder der Final Boss oder der UnderBoss noch am Leben ist (deren HP größer als 0 ist).
// Solange diese Bedingungen erfüllt sind, wird die Schleife weiter ausgeführt.
    var round = 1
    while (heroes.any { it.hp > 0 } && (finalBoss.hp > 0 || underBoss.hp > 0)) {
        println("WELCOME TO GOLDEN SYNTHAX ")
        println("Round $round starts...")

        for (hero in heroes) { //Wenn ein Held bereits besiegt wurde (HP kleiner oder gleich 0),
            // wird dieser übersprungen und es wird zum nächsten Helden in der Liste fortgefahren.
            if (hero.hp <= 0) {
                continue
            }

            val heroAction = hero.chooseAction()

            when (heroAction) {
                "Attack" -> hero.attack(finalBoss)
                "Defend" -> hero.defend(finalBoss)
                "Bag" -> hero.useBag()
            }
        }
        //Der Code führt die Aktionen für jeden lebenden Helden in der Liste aus und dann die Aktionen
        // für den Final Boss und den UnderBoss, wenn sie noch am Leben sind.

        if (finalBoss.hp > 0) {
            finalBoss.finalBossActions(heroes, underBoss)
        }

        if (underBoss.hp > 0) {
            underBoss.underBossActions(heroes)
        }

        println("Hero hps: ${heroes.joinToString { "${it.name}: ${it.hp}" }}")
        println("Final Boss HP: ${finalBoss.hp}")
        println("UnderBoss HP: ${underBoss.hp}")

        round++
    }
//Diese Bedingung wird wahr, wenn alle Helden (heroes) keine HP mehr haben (HP <= 0)
// und sowohl der Final Boss (finalBoss) als auch der UnderBoss (underBoss) keine HP mehr haben.
    if (heroes.all { it.hp <= 0 } && finalBoss.hp <= 0 && underBoss.hp <= 0) {
        println("Both Final Boss and UnderBoss are defeated!")
        //iese Bedingung wird wahr, wenn alle Helden (heroes) keine HP mehr haben (HP <= 0) und entweder der Final Boss
    // (finalBoss) oder der UnderBoss (underBoss) keine HP mehr hat.
    } else if (heroes.all { it.hp <= 0 } && (finalBoss.hp <= 0 || underBoss.hp <= 0)) {
        println("Heroes are defeated!")
        //Diese Bedingung wird wahr, wenn alle Helden (heroes) keine HP mehr haben (HP <= 0)
    // und der UnderBoss (underBoss) keine HP mehr hat.
    } else if (heroes.all { it.hp <= 0 } && underBoss.hp <= 0) {
        println("Final Boss wins!")
        //Wenn keine der obigen Bedingungen erfüllt ist, bedeutet das, dass die Helden das Spiel gewonnen haben.
        //In diesem Fall wird die Nachricht "Heroes win!" ausgegeben.
    } else {
        println("Heroes win!")
    }
}
