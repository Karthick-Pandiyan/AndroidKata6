package com.kp.tictactoe.model

class Game(playerOne: String, playerTwo: String){

    private val player1 =  Player(playerOne, "x")
    private val player2 = Player(playerTwo, "o")
    var currentPlayer = player1

    fun switchPlayer() {
        currentPlayer = if (currentPlayer === player1) player2 else player1
    }
}