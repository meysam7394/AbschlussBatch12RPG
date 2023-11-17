class Hero2(name: String, hp: Int, finalBoss: Boss, ) : Hero(name,hp, finalBoss) {
    override val actions = mutableListOf("SlingShot", "Shield", "Bag")
    override fun chooseAction(): String? {
        println("$name, choose an action: 1. SlingShot, 2. Shield, 3. Bag")
        return super.chooseAction()
    }

    fun hero2Actions(): String? {
        println("$name, choose an action: 1.SlingShot, 2. Shield, 3. Bag")
        val action = readln()

        when (action) {
            "1" -> {
                slingshot(finalBoss)
                println("Hero1 chooses to attack with SlingShot ")
            }
            "2" -> {
                shield(finalBoss)
                println("Hero1 chooses to use Shield")
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

    fun slingshot(finalBoss: Boss) {
        val damage = 10
        this.finalBoss.takeDamage(damage)
        hasLostHP = true
    }

    fun shield(finalBoss: Boss) {
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
