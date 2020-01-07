package com.kp.tictactoe

import com.kp.tictactoe.model.Player
import org.junit.Assert
import org.junit.Test

class PlayerTest {

    val player1 = Player("Karthick", "x")
    val player2 = Player("Pandiyan", "o")

    @Test
    fun `Given function should return player name when value passed in Player constructor`(){
        Assert.assertEquals("Karthick", player1.name)
    }

    @Test
    fun `Given function should return player value when value passed in Player constructor`(){
        Assert.assertEquals("o", player1.value)
    }
}