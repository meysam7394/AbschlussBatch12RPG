class Hero3 (name:String,hp:Int):Hero(name,hp){
    override val actions = mutableListOf("Attack", "Defend", "Bag")

 override fun chooseAction(): String {
        println("$name, choose an action: ${actions.joinToString(", ")}")
        return readln()
    }
    override fun attack(boss: Boss) {
        val damage = 20 // Adjust the damage value as needed
        boss.takeDamage(damage)
    }
    override fun defend(boss: Boss) {
        // When a hero chooses to defend, no action is taken by the boss.
        // Hero's HP remains the same.
        println("$name chooses to defend and takes no damage.")
    }
    override fun useBag() {
        if (hasLostHP) {
            val item = readln()
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