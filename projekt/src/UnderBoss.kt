class UnderBoss(name: String, override var hp: Int) : Boss(name, hp) {
    var underbossadded = false

    override val actions = mutableListOf("Thunder", "Fire strike")

    fun underBossActions(heroes: List<Hero>) {
        if (hp > 0) {
            val action = actions.random()

            when (action) {
                "Thunder" -> thunder(heroes)
                "Fire strike" -> fireStrike(heroes)
            }
        }
    }

    fun thunder(heroes: List<Hero>) {
        // Check if the list of heroes is not empty
        if (heroes.isNotEmpty()) {
            val targetHero = heroes.random() //// Select a random target hero from the list
            val damage = 12 // Define the damage value
            targetHero.hp -= damage  // Reduce the HP of the target hero by the damage amount
        }
    }

    fun fireStrike(heroes: List<Hero>) {
        if (heroes.isNotEmpty()) {  // Check if the list of heroes is not empty
            val damage = 7  // Define the damage value
            // repeats over each hero in the list using forEach and reduces their HP by the damage amount.
            heroes.forEach { hero -> hero.hp -= damage }  // Reduce the HP of each hero in the list by the damage amount
        }
    }
}