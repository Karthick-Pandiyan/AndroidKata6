package com.kp.tictactoe.viewmodel

import androidx.databinding.ObservableArrayMap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kp.tictactoe.model.Cell
import com.kp.tictactoe.model.Game
import com.kp.tictactoe.model.Player
import com.kp.tictactoe.utilities.StringUtility.Companion.stringFromNumbers

class GameViewModel {

    lateinit var cells: ObservableArrayMap<String, String>
    lateinit var game: Game
    var winnerName = MutableLiveData<String>()
    var noWinner = MutableLiveData<String>()

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

    fun getWinner(): LiveData<Player> {
        return game.winner
    }

    fun populateWinner(player: Player){
        if (getWinner().value == null ||
            getWinner().value?.name.isNullOrEmpty()) {
            noWinner.postValue("No Winner!")
        } else {
            winnerName.postValue( player.name)
        }
    }

    fun getPlayerName(): MutableLiveData<String> {
        return winnerName
    }
    fun getIfNoWinner(): MutableLiveData<String> {
        return noWinner
    }
}