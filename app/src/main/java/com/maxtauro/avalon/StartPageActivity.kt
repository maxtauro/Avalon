package com.maxtauro.avalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.maxtauro.avalon.dialogfragments.DialogFragmentCreateGame
import com.maxtauro.avalon.lobbyactivities.HostLobbyActivity
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
        DialogFragmentCreateGame.createInstance(::enterHostLobby)
            .show(supportFragmentManager, CREATE_GAME_DIALOG_TAG)
    }

    private fun onJoinGameClicked() {
        DialogFragmentJoinGame.createInstance(::joinGameAsync)
            .show(supportFragmentManager, JOIN_GAME_DIALOG_TAG)
    }

    private fun joinGameAsync(gameId: String, playerName: String) {
        // First we check if the game exists, if it does, we
        // send the user to the game lobby
    }

    private fun enterHostLobby(hostName: String) {
        val hostLobbyIntent = Intent(this, HostLobbyActivity::class.java)
        hostLobbyIntent.putExtra("hostName", hostName)
        startActivity(hostLobbyIntent)
    }

    companion object {
        private const val CREATE_GAME_DIALOG_TAG = "DialogFragmentCreateGame.TAG"
        private const val JOIN_GAME_DIALOG_TAG = "DialogFragmentJoinGame.TAG"
    }
}
