package com.maxtauro.avalon

import com.google.firebase.database.FirebaseDatabase

actual fun platformName(): String {
    return "Android"
}

actual fun postFirebaseHelloWorld() {
    // Write a message to the database
    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("message")

    myRef.setValue(createApplicationScreenMessage())
}