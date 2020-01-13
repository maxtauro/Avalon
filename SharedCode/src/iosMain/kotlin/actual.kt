package com.maxtauro.avalon

import platform.UIKit.UIDevice

actual fun platformName(): String {
    return UIDevice.currentDevice.systemName() +
            " " +
            UIDevice.currentDevice.systemVersion
}

actual fun postFirebaseHelloWorld() {
    TODO("Do the ios implementation later")
}