//
//  LobbyViewController.swift
//  QuikCart
//
//  Created by Mario Oliver on 7/21/16.
//  Copyright © 2016 Oliver Games LLC. All rights reserved.
//

import UIKit

class LobbyViewController: UIViewController {
    
    @IBOutlet weak var WelcomeUserLabel: UILabel!
    
    override func viewDidLoad() {
        let username = NSUserDefaults().stringForKey("username")
        WelcomeUserLabel.text = "Welcome Matt!"//"Welcome \(username)"
    }
    
}
