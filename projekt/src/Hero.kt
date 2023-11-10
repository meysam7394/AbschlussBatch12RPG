open class Hero(val name : String, var hp:Int) {
  open val actions = mutableListOf("Attack", "Defend", "Bag")
  val bag = mutableListOf("Healing Potion", "Vitamin")
  //var vitaminUsed = false
 // var isDefeated = false
  var hasLostHP = false
 // var defending = false

  open fun chooseAction(): String {
    println("$name, choose an action: ${actions.joinToString(", ")}")
    return readln()
  }


  open fun attack(boss: Boss) {
    val damage = 20 // Adjust the damage value as needed
    boss.takeDamage(damage)
    hasLostHP = true
  }
  open fun defend(boss: Boss) {
    // When a hero chooses to defend, no action is taken by the boss.
    // Hero's HP remains the same.
    println("$name chooses to defend and takes no damage.")
  }

  open fun useBag() {
    if (hasLostHP) {
      println("$name, choose an item to use: ${bag.joinToString(", ")}")
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

