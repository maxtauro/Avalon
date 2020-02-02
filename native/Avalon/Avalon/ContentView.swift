//
//  ContentView.swift
//  Avalon
//
//  Created by Max Tauro on 2020-02-01.
//  Copyright © 2020 Max Tauro. All rights reserved.
//

import SwiftUI
import FirebaseDatabase
import SharedCode

struct ContentView: View {
    var body: some View {
        Button(action: {
            var ref: DatabaseReference!
            ref = Database.database().reference().child("message")
            ref.setValue(CommonKt.createApplicationScreenMessage())
        }) {
            Text("Do some firebase")
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
