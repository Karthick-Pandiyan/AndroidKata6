package com.kp.tictactoe

import androidx.databinding.ObservableArrayMap
import com.kp.tictactoe.model.Game

class GameViewModelTest {

    lateinit var cells: ObservableArrayMap<String, String>
    private var game: Game? = null

    private fun init(player1: String, player2: String) {
        game = Game(player1, player2)
        cells = ObservableArrayMap()
    }
}