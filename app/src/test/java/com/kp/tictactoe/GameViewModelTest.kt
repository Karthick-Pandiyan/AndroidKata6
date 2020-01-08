package com.kp.tictactoe

import androidx.databinding.ObservableArrayMap
import com.kp.tictactoe.model.Cell
import com.kp.tictactoe.model.Game
import org.junit.Assert
import org.junit.Test

class GameViewModelTest {

    lateinit var cells: ObservableArrayMap<String, String>
    private lateinit var game: Game

    private fun init(player1: String, player2: String) {
        game = Game(player1, player2)
        cells = ObservableArrayMap()
    }

    fun onClickedCellAt(row: Int, column: Int) {
        if (game.cells[row][column] == null || game.cells[row][column].isEmpty) {
            game.cells[row][column] = Cell(game.currentPlayer)
            cells[stringFromNumbers(row, column)] = game.currentPlayer.value
            if (!game.hasGameEnded())
                    game.switchPlayer()
        }
    }

    @Test
    fun `Given function should switch player to player 2 if the game is not ended`(){
        init("Karthick","Pandiyan")
        onClickedCellAt(0,0)
        Assert.assertEquals("Pandiyan", game.currentPlayer.name)
    }

    fun stringFromNumbers(vararg numbers: Int): String {
        val sNumbers = StringBuilder()
        for (number in numbers)
            sNumbers.append(number)
        return sNumbers.toString()
    }

    @Test
    fun `Given function should return player 1 name when init called from GameViewModel`(){
        init("Karthick","Pandiyan")
        Assert.assertEquals("Karthick", game.player1.name)
    }

    @Test
    fun `Given function should return String of given numbers`(){
        Assert.assertEquals("01", stringFromNumbers(0,1))
        Assert.assertEquals("02", stringFromNumbers(0,2))
        Assert.assertEquals("22", stringFromNumbers(2,2))
    }
}