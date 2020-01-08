package com.kp.tictactoe

import com.kp.tictactoe.utilities.StringUtility.Companion.stringFromNumbers
import com.kp.tictactoe.viewmodel.GameViewModel
import org.junit.Assert
import org.junit.Test

class GameViewModelTest {

    val gameViewModel = GameViewModel()

    @Test
    fun `Given function should switch player to player 2 if the game is not ended`(){
        gameViewModel.init("Karthick","Pandiyan")
        gameViewModel.onClickedCellAt(0,0)
        Assert.assertEquals("Pandiyan", gameViewModel.game.currentPlayer.name)
    }

    @Test
    fun `Given function should return player 1 name when init called from GameViewModel`(){
        gameViewModel.init("Karthick","Pandiyan")
        Assert.assertEquals("Karthick", gameViewModel.game.player1.name)
    }

    @Test
    fun `Given function should return String of given numbers`(){
        Assert.assertEquals("01", stringFromNumbers(0,1))
        Assert.assertEquals("02", stringFromNumbers(0,2))
        Assert.assertEquals("22", stringFromNumbers(2,2))
    }

    @Test
    fun `Given function should return winning status when populateWinner called from GameViewModel`(){
        gameViewModel.init("Karthick","Pandiyan")
        gameViewModel.populateWinner(gameViewModel.game.player1)
        Assert.assertNotNull(gameViewModel.noWinner)
    }
}