package com.maxtauro.avalon.Firebase

import com.google.firebase.database.FirebaseDatabase

actual fun getFirebaseInstance() = FirebaseDatabase.getInstance()
