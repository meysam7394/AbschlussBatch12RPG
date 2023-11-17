open class Hero(val name: String, var hp: Int, val finalBoss: Boss) {
  open val actions = mutableListOf("Attack", "Defend", "Bag")
  val bag = mutableListOf("Healing Potion", "Vitamin")
  var hasLostHP = false
  open fun chooseAction(): String? {
    // Implementation for choosing action
    return readlnOrNull()
  }
  open fun hero1Actions(): String? {
    println("$name, choose an action: 1. Attack, 2. Defend, 3. Bag")
    val action = readln()

    when (action) {
      "1" -> {
        attack(finalBoss)
        println("Hero choose to attack ")
      }
      "2" -> {
        defend(finalBoss)
        println("Hero choose to defend")
      }
      "3" -> {
        useBag()
        println("Hero choose to use bag ")
      }
      else -> {
        // Handle invalid input
        println("Invalid action. Please choose a valid action.")
      }
    }

    return action
  }


  open fun attack(boss: Boss) {
    val damage = 20
    boss.takeDamage(damage)
    hasLostHP = true
  }

  open fun defend(boss: Boss) {
    println("$name chooses to defend and takes no damage.")
  }

  open fun useBag() {
    if (hasLostHP) {
      println("$name, choose an item to use: 1. Healing Potion, 2. Vitamin")
      val item = readln()
      if (item == "1" && bag.contains("Healing Potion")) {
        hp += 20
        bag.remove("Healing Potion")
        hasLostHP = false
        println("$name uses a Healing Potion and recovers 20 HP.")
      } else if (item == "2" && bag.contains("Vitamin")) {
        hp += 10
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
