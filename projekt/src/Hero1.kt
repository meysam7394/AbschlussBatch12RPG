// Hero1 class
class Hero1(name: String, hp: Int, finalBoss: Boss) : Hero(name,hp, finalBoss) {
    override fun chooseAction(): String? {
        println("$name, choose an action: 1. Attack, 2. Defend, 3. Bag")
        return super.chooseAction()
    }
    override fun hero1Actions(): String? {
        println("$name, choose an action: 1. Attack, 2. Defend, 3. Bag")
        val action = readln()

        when (action) {
            "1" -> {
                attack(finalBoss)
                println("Hero1 choose to attack ")
            }
            "2" -> {
                defend(finalBoss)
                println("Hero1 choose to defend")
            }
            "3" -> {
                useBag()
                println("Hero1 choose to use bag ")
            }
            else -> {
                // Handle invalid input
                println("Invalid action. Please choose a valid action.")
            }
        }

        return action
    }
    override fun attack(boss: Boss) {
        val damage = 20 // Adjust the damage value as needed
        boss.takeDamage(damage)
        hasLostHP = true
    }

    override fun defend(boss: Boss) {
        // When a hero chooses to defend, no action is taken by the boss.
        // Hero's HP remains the same.
        println("$name chooses to defend and takes no damage.")
    }

    override fun useBag() {
        if (hasLostHP) {
            println("$name, choose an item to use: ${bag.joinToString(", ")}")
            val item = readlnOrNull()
            if (item == "Healing Potion" && bag.contains("Healing Potion")) {
                hp += 20 // Increase HP by 20
                bag.remove("Healing Potion")
                hasLostHP = false
                println("$name uses a Healing Potion and recovers 20 HP.")
            } else if (item == "Vitamin" && bag.contains("Vitamin")) {
                hp += 10 // Increase HP by 10
                bag.remove("Vitamin")
                hasLostHP = false
                println("$name uses a Vitamin and recovers 10 HP.")
            } else {
                println("$name cannot use that item or it's not in the bag.")
            }
        } else {
            println("$name cannot use the bag because they haven't lost HP in battle.")
        }
    }
}
