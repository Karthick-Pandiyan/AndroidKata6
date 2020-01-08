package com.kp.tictactoe

import com.kp.tictactoe.model.Cell
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

    @Test
    @Throws(Exception::class)
    fun `Given function should return true if it has three same horizontal cells at Row1`() {
        val cell = Cell(game.player1)
        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = cell
        Assert.assertTrue(game.hasThreeSameHorizontalCells())
    }

    @Test
    @Throws(Exception::class)
    fun `Given function should return true if it has three same horizontal cells at Row2`() {
        val cell = Cell(game.player1)
        game.cells[1][0] = cell
        game.cells[1][1] = cell
        game.cells[1][2] = cell
        Assert.assertTrue(game.hasThreeSameHorizontalCells())
    }

    @Test
    @Throws(Exception::class)
    fun `Given function should return true if it has three same horizontal cells at Row3`() {
        val cell = Cell(game.player1)
        game.cells[2][0] = cell
        game.cells[2][1] = cell
        game.cells[2][2] = cell
        Assert.assertTrue(game.hasThreeSameHorizontalCells())
    }

    @Test
    @Throws(Exception::class)
    fun `Given function should return false if it does not have three same horizontal cells`() {
        val cell = Cell(game.player1)
        val anotherCell = Cell(game.player2)
        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = anotherCell
        Assert.assertFalse(game.hasThreeSameHorizontalCells())
    }

    @Test
    @Throws(Exception::class)
    fun `Given function should return false if it does not have three same vertical cells`() {
        val cell = Cell(game.player1)
        val anotherCell = Cell(game.player2)
        game.cells[0][0] = cell
        game.cells[1][0] = cell
        game.cells[2][0] = anotherCell
        Assert.assertFalse(hasThreeSameVerticalCells())
    }

    fun hasThreeSameVerticalCells(): Boolean {
        for (i in 0 until 3)
            if (game.areEqual(game.cells[0][i], game.cells[1][i], game.cells[2][i]))
                return true
        return false
    }


}