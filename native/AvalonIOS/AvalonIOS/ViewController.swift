//
//  ViewController.swift
//  AvalonIOS
//
//  Created by Max Tauro on 2020-01-12.
//  Copyright © 2020 Max Tauro. All rights reserved.
//

import UIKit
import SharedCode
import FirebaseDatabase

class ViewController: UIViewController {
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let label = UILabel(frame: CGRect(x: 0, y: 0, width: 300, height: 21))
        label.center = CGPoint(x: 160, y: 285)
        label.textAlignment = .center
        label.font = label.font.withSize(25)
        label.text = CommonKt.createApplicationScreenMessage()
        view.addSubview(label)
        
        
    }
    @IBAction func onClick(_ sender: Any) {
        var ref: DatabaseReference!
        ref = Database.database().reference().child("message")
        ref.setValue(CommonKt.createApplicationScreenMessage())
    }
}
