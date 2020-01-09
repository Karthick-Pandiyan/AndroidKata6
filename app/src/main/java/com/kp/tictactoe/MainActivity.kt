package com.kp.tictactoe

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.kp.tictactoe.databinding.ActivityMainBinding
import com.kp.tictactoe.viewmodel.GameViewModel
import android.os.Handler

class MainActivity : AppCompatActivity() {

    private lateinit var activityGameBinding: ActivityMainBinding
    private lateinit var gameViewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDataBinding()
    }

    private fun initDataBinding() {
        activityGameBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        gameViewModel = GameViewModel()
        gameViewModel.init("Player1", "Player2")
        activityGameBinding.setGameViewModel(gameViewModel)
        setUpOnGameEndListener()
    }

    private fun setUpOnGameEndListener() {
        gameViewModel.getWinner().observe(this, Observer { player ->
            gameViewModel.populateWinner(player)
        })
        gameViewModel.getIfNoWinner().observe(this, Observer{ message ->
            showIfNoWinner(message)
        })
        gameViewModel.getPlayerName().observe(this, Observer{playerName ->
            showWinnerName(playerName)
        })

    }

    private fun resetGame() {
        Handler().postDelayed(Runnable { initDataBinding() }, 1000)
    }

    private fun showWinnerName(playerName: String){
        Toast.makeText(this, "Winner is $playerName!", Toast.LENGTH_LONG).show()
        resetGame()
    }

    private fun showIfNoWinner(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        resetGame()
    }
}
