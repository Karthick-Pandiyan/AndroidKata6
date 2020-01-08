package com.kp.tictactoe.model

class Cell(var player: Player?) {

    val isEmpty: Boolean
        get() = player == null || player?.value.isNullOrEmpty()
}