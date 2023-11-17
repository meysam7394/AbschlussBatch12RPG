class FinalBoss(name: String, hp: Int) : Boss(name, hp) {
    val maxHP: Int = hp // assuming maxHP is equal to the initial HP
    private var isUnderBossSummoned = false
    override val actions = mutableListOf("Fire Breath", "Curse", "Summon UnderBoss")


    // In der FinalBoss-Klasse
    fun finalBossActions(heroes: List<Hero>, underBoss: UnderBoss) {
        println("$name, choose an action against heroes: 1. Fire Breath, 2. Curse")
        val action = readln()

        // Überprüfen, ob die Eingabe numerisch ist
        val actionIndex = action.toIntOrNull()

        when (actionIndex) {
            1 -> {
                fireBreath(heroes)
            }
            2 -> {
                curse(heroes)
            }
            else -> {
                println("Invalid input. Please choose a valid action.")
            }
        }
    }



    fun fireBreath(heroes: List<Hero>) {
        val damage = 25
        val targetHero = heroes.random()
        targetHero.hp -= damage
    }

    fun curse(heroes: List<Hero>) {
        val damage = 12
        heroes.forEach { hero -> hero.hp -= damage }
    }
}

