package com.kp.tictactoe.model

import androidx.lifecycle.MutableLiveData

class Game(playerOne: String, playerTwo: String){

    private val BOARD_SIZE = 3
    val player1 =  Player(playerOne, "x")
    val player2 = Player(playerTwo, "o")
    var currentPlayer = player1
    var cells = Array(BOARD_SIZE) {
        Array(BOARD_SIZE) {
            Cell(null)
        }
    }
    var winner: MutableLiveData<Player> = MutableLiveData()


    fun switchPlayer() {
        currentPlayer = if (currentPlayer === player1) player2 else player1
    }

    fun hasGameEnded(): Boolean {
        if(isBoardFull()) {
            winner.value = null
            return true
        }
        return false
    }

    fun isBoardFull(): Boolean {
        for (row in cells)
            for (cell in row)
                if (cell.isEmpty)
                    return false
        return true
    }

    private fun areEqual(vararg cells: Cell): Boolean {
        return true
    }
}