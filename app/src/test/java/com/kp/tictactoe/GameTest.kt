package com.kp.tictactoe

import com.kp.tictactoe.model.Game
import org.junit.Assert
import org.junit.Test

class GameTest {

    val game = Game("Karthick", "Pandiyan")

    @Test
    fun `Given Game should return current player as player 1, when game starts on first time`(){
        Assert.assertEquals(game.player1.name, game.currentPlayer.name)
    }

    @Test
    fun `Given function should return player 2 when switch player function called if current player is player 1`(){
        game.switchPlayer()
        Assert.assertEquals(game.player2.name, game.currentPlayer.name)
    }

    @Test
    fun `Given function should return false when game is not ended`(){
        Assert.assertFalse(game.hasGameEnded())
    }

    @Test
    fun `Given function should return false when game board is not full`(){
        Assert.assertFalse(game.isBoardFull())
    }

    @Test
    fun `Given function should return false when cells are not equal from areEqual()`(){
        Assert.assertFalse(game.areEqual(game.cells[0][1], game.cells[0][2]))
    }

    fun hasThreeSameHorizontalCells(): Boolean {
            for (i in 0 until 3)
                if (game.areEqual(game.cells[i][0], game.cells[i][1], game.cells[i][2]))
                    return true
            return false
    }

}