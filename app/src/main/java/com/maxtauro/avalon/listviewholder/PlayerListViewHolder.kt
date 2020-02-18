package com.maxtauro.avalon.listviewholder

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.maxtauro.avalon.R


/**
 * ListViewHolder for players in the current game/game lobby
 */
class PlayerListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    val txtPlayerName: TextView = itemView.findViewById(R.id.txt_player_name)
    lateinit var playerId: String

    private val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Log.d("PlayerListViewHolder", "Click on player")
    }

    fun hideEntry() {
        params.height = 0
        itemView.layoutParams = params
    }
}