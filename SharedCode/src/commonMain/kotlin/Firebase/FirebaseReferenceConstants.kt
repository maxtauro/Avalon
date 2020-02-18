package com.maxtauro.avalon.Firebase

import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic

/**
 * Constants for firebase paths
 */

open class FirebaseReferenceConstants {

    // These constants are placed in a companion method in order to access them as static values
    companion object {
        const val PLAYER_LIST_NODE_KEY = "playerList"
        const val GAME_INFO_NODE_KEY = "gameInfo"
        const val GAME_ACTIVE_NODE_KEY = "gameActive"
        const val HOST_NAME_NODE_KEY = "hostName"
        const val PLAYER_ACTIVE_NODE_KEY = "playerActive"
        const val COMPLETED_GAMES_REF = "completedGames"
    }
}
