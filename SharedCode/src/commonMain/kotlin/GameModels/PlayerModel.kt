package com.maxtauro.avalon.GameModels

class PlayerModel(
    var playerName: String,
    var playerId: String
) {

    @Deprecated("Need a no argument ctor for firebase, you should NEVER call this explicitly")
    constructor() : this("", "")

    companion object {
        private const val TAG = "PlayerModel"
    }
}