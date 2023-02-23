package com.example.dnd.data.model

import com.example.dnd.StatusAdapter
import kotlin.random.Random

class Entity(
    var health: Int = 100,
    var attack: Int = 20,
    val protection: Int=20,
    val damage: Int = 6,
    private val cure: Int = 50,
    ):StatusAdapter() {
        private fun cubeRandom(start: Int = 1, end: Int = 6): Int {
            require(start <= end) { }
            val cubeRandom = Random(System.nanoTime())
            return (start..end).random(cubeRandom)
        }
        fun game(){
            if (health < 50) {
                health += cure
            }
            if (cubeRandom(start = 1, end = 6) > 4){
                health -= damage
                attack = (protection - attack) + 1

            }
            if(health == 0){
                return
            }
        }
    }

