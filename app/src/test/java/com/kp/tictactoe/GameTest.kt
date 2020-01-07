package com.kp.tictactoe

import com.kp.tictactoe.model.Game
import org.junit.Assert
import org.junit.Test

class GameTest {

    val game = Game("Karthick", "Pandiyan")

    @Test
    fun `Given Game should return current player as player 1, when game starts on first time`(){
        Assert.assertEquals("Karthick", game.currentPlayer.name)
    }
}