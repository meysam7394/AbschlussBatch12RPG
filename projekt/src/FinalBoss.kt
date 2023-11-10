class FinalBoss(name: String, hp: Int) : Boss(name, hp) {
    override val actions = mutableListOf("Fire Breath", "Curse")

    fun finalBossActions(heroes: List<Hero>, underBoss: UnderBoss) {
        println("$name, choose an action: $actions")
        val chosenAction = readln()

        when (chosenAction) {
            "Fire Breath" -> {
                val damage = 25 // Adjust the damage value as needed
                val targetHero = heroes.random()
                targetHero.hp -= damage
            }

            "Curse" -> {
                val damage = 12 // Adjust the damage value as needed
                heroes.forEach { hero -> hero.hp -= damage }
            }

            "UnderBoss" -> {
                if (hp <= 60 && !underBoss.isSummoned) {
                    println("$name summons the UnderBoss.")
                    underBoss.hp = 50 // Set the UnderBoss's HP when summoned
                    underBoss.isSummoned = true
                    println("UnderBoss HP: ${underBoss.hp}")
                    underBoss.underBossActions(heroes)
                } else {
                    println("$name cannot summon the UnderBoss now.")
                }
            }
        }
    }
}
