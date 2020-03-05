package com.kp.tictactoe.model

class Game(playerOne: String, playerTwo: String){

    private val BOARD_SIZE = 3
    val player1 =  Player(playerOne, "x")
    val player2 = Player(playerTwo, "o")
    var currentPlayer = player1
    var cells = Array(BOARD_SIZE) { Array(BOARD_SIZE) { Cell(null) } }

    fun switchPlayer() {
        currentPlayer = if (currentPlayer === player1) player2 else player1
    }

    fun isWinnerAvailable(): Boolean = hasThreeSameHorizontalCells() || hasThreeSameVerticalCells() || hasThreeSameDiagonalCells()

    fun hasThreeSameHorizontalCells(): Boolean {
        for (i in 0 until BOARD_SIZE)
            if (areEqual(cells[i][0], cells[i][1], cells[i][2]))
                return true
        return false
    }

    fun hasThreeSameVerticalCells(): Boolean {
        for (i in 0 until BOARD_SIZE)
            if (areEqual(cells[0][i], cells[1][i], cells[2][i]))
                return true
        return false
    }

    fun hasThreeSameDiagonalCells(): Boolean {
        for (i in 0 until 3)
            if (areEqual(cells[0][0], cells[1][1], cells[2][2])|| areEqual(cells[0][2], cells[1][1], cells[2][0]))
                return true
        return false
    }

    fun isBoardFull(): Boolean {
        for (row in cells)
            for (cell in row)
                if (cell.isEmpty) return false
        return true
    }

    fun areEqual(vararg cells: Cell): Boolean {
        if (cells.isEmpty()) return false
        for (cell in cells)
            if (cell.player?.value.isNullOrEmpty()) return false
        val comparisonBase = cells[0]
        for (i in 1 until cells.size)
            if (!comparisonBase.player?.value.equals(cells[i].player?.value)) return false
        return true
    }
}