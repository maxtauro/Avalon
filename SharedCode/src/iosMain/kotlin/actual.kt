package com.maxtauro.avalon

import platform.UIKit.UIDevice
import cocoapods.FirebaseDatabase.FIRDatabase
import cocoapods.FirebaseDatabase.FIRDatabaseReference

actual fun platformName(): String {
    return UIDevice.currentDevice.systemName() +
            " " +
            UIDevice.currentDevice.systemVersion
}

actual fun postFirebaseHelloWorld() {
    val ref: FIRDatabaseReference = FIRDatabase.database().reference().child("message")
    ref.setValue(createApplicationScreenMessage())
}