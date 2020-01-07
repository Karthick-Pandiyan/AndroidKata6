package com.kp.tictactoe.model

import android.text.TextUtils

class Cell(var player: Player?) {

    val isEmpty: Boolean
        get() = player == null || player?.value.isNullOrEmpty()
}