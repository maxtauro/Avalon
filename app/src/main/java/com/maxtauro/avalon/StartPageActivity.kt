package com.maxtauro.avalon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.maxtauro.monopolywallet.DialogFragments.DialogFragmentCreateGame
import com.maxtauro.monopolywallet.DialogFragments.DialogFragmentJoinGame

class StartPageActivity : AppCompatActivity() {

    private lateinit var mCreateGameBtn: Button
    private lateinit var mJoinGameBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initButtons()
    }

    private fun initButtons() {
        mCreateGameBtn = findViewById(R.id.btn_create_game)
        mJoinGameBtn = findViewById(R.id.btn_join_game)

        mCreateGameBtn.setOnClickListener { onCreateGameClicked() }
        mJoinGameBtn.setOnClickListener { onJoinGameClicked() }
    }

    private fun onCreateGameClicked() {
        DialogFragmentCreateGame.createInstance(::createGame).dialog?.show()
    }

    private fun onJoinGameClicked() {
        DialogFragmentJoinGame.createInstance(::joinGame).dialog?.show()
    }

    private fun createGame(playerName: String) {

    }

    private fun joinGame(gameId: String, playerName: String) {

    }

    private fun startGameLobbyActivity() {

    }
}
