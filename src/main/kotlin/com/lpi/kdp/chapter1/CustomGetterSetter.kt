package com.lpi.kdp.chapter1

/** examples of custom getter and setter
 * getter for unification
 * setter for validation
 */
class Player(name: String) {
    val name = name
        get() = field.uppercase()

    var score: Int = 0
        set(value) { // accept only non-negative values
            field = if (value < 0) {
                0
            } else {
                value
            }
        }
}

fun main() {
    val player = Player("Robert")
    player.score = -1

    println(player.name) // ROBERT
    println(player.score) // 0
}