package com.maxtauro.avalon.lobbyactivities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.maxtauro.avalon.Firebase.FirebaseGameHelper
import com.maxtauro.avalon.Firebase.FirebaseGameHelperImpl
import com.maxtauro.avalon.GameModels.PlayerModel
import com.maxtauro.avalon.R
import com.maxtauro.avalon.listviewholder.PlayerListViewHolder

class PlayerLobbyActivity : AppCompatActivity() {

    private lateinit var gameHelper: FirebaseGameHelper

    //RecyclerView
    lateinit var adapter: FirebaseRecyclerAdapter<PlayerModel, PlayerListViewHolder>
    lateinit var listPlayersRecyclerView: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
    }

    private fun setupView() {
        setContentView(R.layout.activity_lobby)

        gameHelper = FirebaseGameHelperImpl(intent.extras!!["gameId"] as String)

        setupButtons()
        setupPlayerList()
    }

    private fun setupButtons() {
        // TODO
    }

    private fun setupPlayerList() {
        listPlayersRecyclerView = findViewById<RecyclerView>(R.id.player_list)
        listPlayersRecyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        listPlayersRecyclerView.layoutManager = layoutManager

        val options = FirebaseRecyclerOptions.Builder<PlayerModel>()
            .setQuery(gameHelper.playerListRef, PlayerModel::class.java)
            .build()

        adapter = object : FirebaseRecyclerAdapter<PlayerModel, PlayerListViewHolder>(options) {

            override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
            ): PlayerListViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_holder_player_layout, parent, false)

                return PlayerListViewHolder(view)
            }

            override fun onBindViewHolder(
                holder: PlayerListViewHolder,
                position: Int,
                player: PlayerModel
            ) {
                holder.txtPlayerName.text = player.playerName
            }
        }

        adapter.startListening()
        listPlayersRecyclerView.adapter = adapter
    }

    companion object {
        private const val TAG = "PlayerLobyyActivity"
    }
}