fun main() {
    val hero1 = Hero1("Hero1", 100)
    val hero2 = Hero2("Hero2", 100)
    val hero3 = Hero3("Hero3", 100)

    val finalBoss = FinalBoss("Final Boss", 120)
    val underBoss = UnderBoss("UnderBoss", 50)

    val heroes = listOf(hero1, hero2, hero3)

    var round = 1
    while (heroes.any { it.hp > 0 } && finalBoss.hp > 0) {
        println("Round $round starts...")

        for (hero in heroes) {
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

    if (heroes.all { it.hp <= 0 } && finalBoss.hp <= 0 && underBoss.hp <= 0) {
        println("Both Final Boss and UnderBoss are defeated!")
    } else if (heroes.all { it.hp <= 0 } && finalBoss.hp <= 0) {
        println("UnderBoss wins!")
    } else if (heroes.all { it.hp <= 0 } && underBoss.hp <= 0) {
        println("Final Boss wins!")
    } else {
        println("Heroes win!")
    }
}
