package com.maxtauro.avalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.maxtauro.avalon.Firebase.FirebaseGameHelperImpl
import com.maxtauro.avalon.dialogfragments.DialogFragmentCreateGame
import com.maxtauro.avalon.lobbyactivities.HostLobbyActivity
import com.maxtauro.avalon.lobbyactivities.PlayerLobbyActivity
import com.maxtauro.avalon.dialogfragments.DialogFragmentJoinGame

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

        // TODO, clean up like crazy, move most of the logic into the shared library
        val playerLobbyIntent = Intent(this, PlayerLobbyActivity::class.java)

        val firebaseHelper = FirebaseGameHelperImpl(gameId)
        var gameRef = firebaseHelper.gameRef

        gameRef.addListenerForSingleValueEvent(object : ValueEventListener {
            //TODO Tidy this up
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                //TODO get these ref paths from enum, create a util class that builds the path (builder pattern)
                val isGameActive = (dataSnapshot.child("gameInfo").child("gameActive").value ?: false) as Boolean

                if(dataSnapshot.exists() && !isGameActive) {
                    firebaseHelper.joinGame(playerName)
                    playerLobbyIntent.putExtra("playerName", playerName) // TODO have the name arg be from some enum
                    playerLobbyIntent.putExtra("gameId", gameId)
                    startActivity(playerLobbyIntent)
                }
                else if (isGameActive) {
                    DialogFragmentJoinGame.createInstance(::joinGameAsync).show(supportFragmentManager, "join game dialog")
                    //TODO add toast like pop up to explain that the game is active and cannot be joined
                    Log.e("DialogFragment", "Cannot join active game")
                }
                else {
                    DialogFragmentJoinGame.createInstance(::joinGameAsync).show(supportFragmentManager, "join game dialog")
                    //TODO add toast like pop up to explain that the game is invalid
                    Log.e("DialogFragment", "Tried to join invalid game")
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {}
        })

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
