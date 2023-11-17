class Game {
    private val finalBoss = FinalBoss("Final Boss", 150)
    private val underBoss = UnderBoss("Under Boss", 50)

    private val hero1 = Hero1("Hero1", 50, finalBoss)
    private val hero2 = Hero2("Hero2", 50, finalBoss)
    private val hero3 = Hero3("Hero3", 50, finalBoss)
    private val heroes = listOf(hero1, hero2, hero3)

    fun start() {
        println("Welcome to the Hero vs Boss Game!")

        while (heroes.any { it.hp > 0 } && (finalBoss.hp > 0 || underBoss.hp > 0)) {
            heroes.forEach { hero ->
                if (hero.hp > 0) {
                    val action = hero.chooseAction()

                    // Handle actions based on hero type
                    when (action) {
                        "1" -> {
                            if (hero is Hero1) {
                                hero.attack(finalBoss)
                            } else if (hero is Hero2) {
                                hero.slingshot(finalBoss)
                            } else if (hero is Hero3) {
                                hero.spear(finalBoss)
                            }
                        }
                        "2" -> {
                            if (hero is Hero1) {
                                hero.defend(finalBoss)
                            } else if (hero is Hero2) {
                                hero.shield(finalBoss)
                            } else if (hero is Hero3) {
                                hero.sword(finalBoss)
                            }
                        }
                        "3" -> hero.useBag()
                        else -> {
                            // Handle invalid input
                            println("Invalid action. Please choose a valid action.")
                        }
                    }
                }
            }

            // Check if FinalBoss is defeated
            if (finalBoss.hp <= 0) {
                // UnderBoss takes action only when FinalBoss is defeated
                if (underBoss.hp > 0) {
                    underBoss.underBossActions(heroes)
                }
            } else {
                // FinalBoss takes action as long as it has HP
                var underBossAdded = false
                if (finalBoss.hp > 0) {
                    finalBoss.finalBossActions(heroes, underBoss)
                }
            }



        // Check if FinalBoss is defeated
            if (finalBoss.hp <= 0) {
                // UnderBoss takes action only when FinalBoss is defeated
                if (underBoss.hp > 0) {
                    underBoss.underBossActions(heroes)
                }
            } else {
                // FinalBoss takes action as long as it has HP
                if (finalBoss.hp > 0) {
                    finalBoss.finalBossActions(heroes, underBoss)
                }
            }

            // Print the current state of the battle
            printBattleState()
        }

        // Determine the winner
        determineWinner()
    }

    private fun determineWinner() {
        if (heroes.all { it.hp <= 0 }) {
            // If all heroes have HP less than or equal to 0, print that the Final Boss and UnderBoss are the winners
            println("Final Boss and UnderBoss are the winners!")
        } else if (finalBoss.hp <= 0 && underBoss.hp <= 0) {
            // If both the finalBoss and underBoss have HP less than or equal to 0, print that the Heroes are the winners
            println("Heroes are the winners!")
        }
    }

    private fun printBattleState() {
        println("\nCurrent Battle State:")
        // Iterate through each hero in the 'heroes' list
        heroes.forEach { hero ->
            // Print the name and HP of each hero
            println("${hero.name}: HP = ${hero.hp}")
        }
        // Print the HP of the finalBoss and underBoss
        println("Final Boss: HP = ${finalBoss.hp}")
        println("UnderBoss: HP = ${underBoss.hp}\n")
    }
}

