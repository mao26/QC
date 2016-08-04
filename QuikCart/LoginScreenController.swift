//
//  LoginScreenController.swift
//  QuikCart
//
//  Created by Mario Oliver on 7/21/16.
//  Copyright © 2016 Oliver Games LLC. All rights reserved.
//

import UIKit

class LoginScreenController: UIViewController {
    
    @IBOutlet var currRunningCartXConstraint: NSLayoutConstraint!
    @IBOutlet var usernameLabel: UILabel!
    @IBOutlet var passwordLabel: UILabel!
    @IBOutlet var singInTextField: UITextField!
    @IBOutlet var passwordTextField: UITextField!
    @IBOutlet var singUpButton: UIButton!
    @IBOutlet var singInButton: UIButton!
    
    @IBAction func signInButtonPressed(sender: AnyObject) {
        
    }
    
    @IBAction func singUpButtonPressed(sender: AnyObject) {
        
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //let screenWidth = view.frame.width
        //self.currRunningCartXConstraint.constant -= screenWidth
        //animateRunningCartInLoginScreen()
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func animateRunningCartInLoginScreen(){
        let screenWidth = view.frame.width
        view.layoutIfNeeded()
        UIView.animateWithDuration(0.5, delay: 0, options: [.Repeat], animations: {
            self.currRunningCartXConstraint.constant += screenWidth
            }, completion: {_ in
                
        })
    }
    
    
}