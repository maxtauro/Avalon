package com.maxtauro.avalon

import com.maxtauro.avalon.Firebase.FirebaseGameHelper

actual class FirebaseGameHelperImpl actual constructor(override val gameId: String) :
    FirebaseGameHelper {

    override fun createGame(hostName: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun joinGame(playerName: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun startGame() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        private const val TAG = "FireGameHelperImpl"
    }
}