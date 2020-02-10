package com.maxtauro.avalon.GameModels

import com.maxtauro.avalon.getSystemTime
import kotlin.random.Random

class AvalonGameModel(
    var hostName: String?,
    var gameId: String = generateRandomId(),
    var isGameActive: Boolean = false
) {

    @Deprecated("Need a no argument ctor for firebase, you should NEVER call this explicitly")
    constructor() : this("")

    companion object {
        private const val TAG = "AvalonGameModel"

        private const val alphanumericChars =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

        fun generateRandomId(): String {
            val random = Random(getSystemTime())

            var randomGameId = ""

            repeat((0..4).count()) {
                randomGameId += alphanumericChars[random.nextInt(
                    alphanumericChars.length
                )]
            }

            return randomGameId
        }

    }
}
