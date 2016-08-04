//
//  SignUpViewController.swift
//  QuikCart
//
//  Created by Mario Oliver on 7/21/16.
//  Copyright © 2016 Oliver Games LLC. All rights reserved.
//

import UIKit

class SignUpViewController: UIViewController {
    
    @IBAction func singUpBtnPressed(sender: AnyObject) {
       // NSUserDefaults.standardUserDefaults().setObject(username_textField.text, forKey: "username")
        NSUserDefaults().setObject(username_textField.text, forKey: "username")
        if(password_textField.text == confirm_textField.text){
            NSUserDefaults.standardUserDefaults().setObject(password_textField.text, forKey: "password")
        }
    }
    
    @IBOutlet weak var confirm_textField: UITextField!
    @IBOutlet weak var password_textField: UITextField!
    @IBOutlet weak var username_textField: UITextField!
    
}
