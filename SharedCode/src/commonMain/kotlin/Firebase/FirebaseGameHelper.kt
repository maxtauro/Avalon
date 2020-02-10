package com.maxtauro.avalon.Firebase

expect class FirebaseGameHelperImpl(gameId: String) :
    FirebaseGameHelper

interface FirebaseGameHelper {

    val gameId: String
    val databaseRef: FirebaseDatabaseRef
    val gameRef: FirebaseDatabaseRef

    fun createGame(hostName: String)
    fun joinGame(playerName: String)
    fun startGame()

    companion object {
        protected const val TAG = "FirebaseHelper"
    }
}