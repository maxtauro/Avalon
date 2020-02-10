package com.maxtauro.avalon.Firebase

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.maxtauro.avalon.GameModels.AvalonGameModel

actual class FirebaseGameHelperImpl actual constructor(override val gameId: String) :
    FirebaseGameHelper {

    override val databaseRef: FirebaseDatabaseRef
    override val gameRef: FirebaseDatabaseRef

    init {
        databaseRef = FirebaseDatabase.getInstance().reference
        gameRef = databaseRef.child(gameId)
    }

    override fun createGame(hostName: String) {
        val game = AvalonGameModel(hostName)
        // TODO put these paths in constants
        gameRef.child("gameInfo").setValue(game)
    }

    override fun joinGame(playerName: String) {
        gameRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val gameIdExists = dataSnapshot.exists()
                if (gameIdExists) {
                    gameRef.child("")
                } else {
                    TODO("Handle this async stuff properly")
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })

    }

    override fun startGame() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        private const val TAG = "FireGameHelperImpl"
    }
}