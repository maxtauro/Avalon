package com.maxtauro.avalon

import cocoapods.FirebaseDatabase.FIRDatabase

actual typealias FirebaseDatabase = FIRDatabase

actual fun getFirebaseInstance(): FirebaseDatabase = FIRDatabase.database()
