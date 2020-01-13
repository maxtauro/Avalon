package com.maxtauro.avalon

expect fun platformName(): String

fun createApplicationScreenMessage() : String {
    return "Let's play Avalon on ${platformName()}"
}

expect fun postFirebaseHelloWorld()