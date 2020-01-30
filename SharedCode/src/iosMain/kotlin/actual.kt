package com.maxtauro.avalon

import platform.UIKit.UIDevice
import cocoapods.FirebaseDatabase.FIRDatabaseReference

actual fun platformName(): String {
    return UIDevice.currentDevice.systemName() +
            " " +
            UIDevice.currentDevice.systemVersion
}

actual fun postFirebaseHelloWorld() {
    val ref: DatabaseReference = Database.database().reference()

    TODO("GOT HERE")
}