package com.kp.tictactoe.viewmodel

import androidx.databinding.ObservableArrayMap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kp.tictactoe.model.Cell
import com.kp.tictactoe.model.Game
import com.kp.tictactoe.utilities.StringUtility.Companion.stringFromNumbers

class GameViewModel : ViewModel() {

    lateinit var cells: ObservableArrayMap<String, String>
    lateinit var game: Game
    lateinit var player1: String
    lateinit var player2: String
    var winner = MutableLiveData<String>()
    var noWinner = MutableLiveData<String>()

    fun init(player1: String, player2: String) {
        this.player1 = player1
        this.player2 = player2
        game = Game(player1, player2)
        cells = ObservableArrayMap()
    }

    fun getWinner(): LiveData<String> = winner

    fun getNoWinner(): LiveData<String> = noWinner

    fun onClickedCellAt(row: Int, column: Int) {
        if (game.cells[row][column].isEmpty) {
            game.cells[row][column] = Cell(game.currentPlayer)
            cells[stringFromNumbers(row, column)] = game.currentPlayer.value
            if (!hasGameEnded()) game.switchPlayer()
        }
    }

    fun hasGameEnded(): Boolean {
        if(game.isWinnerAvailable()){
            winner.postValue(game.currentPlayer.name)
            return true
        }
        if(game.isBoardFull()) {
            noWinner.postValue("No Winner!")
            return true
        }
        return false
    }

    fun reset(){
        init(player1, player2)
        winner = MutableLiveData()
        noWinner = MutableLiveData()
    }
}