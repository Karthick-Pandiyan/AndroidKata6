package com.kp.tictactoe.viewmodel

import androidx.databinding.ObservableArrayMap
import com.kp.tictactoe.model.Cell
import com.kp.tictactoe.model.Game
import com.kp.tictactoe.utilities.StringUtility.Companion.stringFromNumbers

class GameViewModel {


    lateinit var cells: ObservableArrayMap<String, String>
    lateinit var game: Game

    fun init(player1: String, player2: String) {
        game = Game(player1, player2)
        cells = ObservableArrayMap()
    }

    fun onClickedCellAt(row: Int, column: Int) {
        if (game.cells[row][column].isEmpty) {
            game.cells[row][column] = Cell(game.currentPlayer)
            cells[stringFromNumbers(row, column)] = game.currentPlayer.value
            if (!game.hasGameEnded())
                game.switchPlayer()
        }
    }
}