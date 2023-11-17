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
        if (heroes.isNotEmpty()) {
            val targetHero = heroes.random()
            val damage = 12
            targetHero.hp -= damage
        }
    }

    fun fireStrike(heroes: List<Hero>) {
        if (heroes.isNotEmpty()) {
            val damage = 7
            heroes.forEach { hero -> hero.hp -= damage }
        }
    }
}