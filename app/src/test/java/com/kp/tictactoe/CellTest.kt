package com.kp.tictactoe

import com.kp.tictactoe.model.Cell
import com.kp.tictactoe.model.Game
import org.junit.Assert
import org.junit.Test

class CellTest {
    val game = Game("Karthick", "Pandiyan")

    @Test
    fun `Given function should return not empty when player started the game`(){
        val cell = Cell(game.player1)
        Assert.assertFalse(cell.isEmpty)
    }

    @Test
    fun `Given function should return empty when player yet to start the game`(){
        game.player1.value = ""
        val cell = Cell(game.player1)
        Assert.assertTrue(cell.isEmpty)
    }
}