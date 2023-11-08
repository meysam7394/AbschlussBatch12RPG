open class Boss(var name: String, var hp: Int) {
    open val actions = mutableListOf("Fire Breath", "Curse")
    fun takeDamage(damage: Int) {
        hp -= damage
        if (hp <= 0) {
            hp = 0
            println("$name's HP is 0. $name is defeated!")
        }
    }
}