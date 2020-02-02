package com.maxtauro.avalon

import platform.UIKit.UIDevice

actual fun platformName(): String {
    return UIDevice.currentDevice.systemName() +
            " " +
            UIDevice.currentDevice.systemVersion
}

actual fun postFirebaseHelloWorld() {
//    val ref: DatabaseReference = Database.database().reference()

    TODO("GOT HERE")
}