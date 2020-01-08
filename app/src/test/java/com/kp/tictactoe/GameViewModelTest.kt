package com.kp.tictactoe

import androidx.databinding.ObservableArrayMap
import com.kp.tictactoe.model.Game
import org.junit.Assert
import org.junit.Test

class GameViewModelTest {

    lateinit var cells: ObservableArrayMap<String, String>
    private var game: Game? = null

    private fun init(player1: String, player2: String) {
        game = Game(player1, player2)
        cells = ObservableArrayMap()
    }

    @Test
    fun `Given function should return player 1 name when init called from GameViewModel`(){
        init("Karthick","Pandiyan")
        Assert.assertEquals("Karthick", game?.player1?.name)
    }
}