class UnderBoss(name: String, hp: Int) : Boss(name, hp) {
    override val actions = mutableListOf("Fire Breath", "Curse")

    fun underBossActions(heroes: List<Hero>) {
        println("$name, choose an action against heroes: Fire Breath, Curse")
        val chosenAction = readln()

        when (chosenAction) {
            "Fire Breath" -> {
                val damage = 12 // Adjust this value as needed
                val targetHero = heroes.random()
                targetHero.hp -= damage
            }
            "Curse" -> {
                val damage = 7 // Adjust this value as needed
                heroes.forEach { hero -> hero.hp -= damage }
            }

        }
    }
}
