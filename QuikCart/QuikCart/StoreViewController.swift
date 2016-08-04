//
//  StoreViewController.swift
//  QuikCart
//
//  Created by Mario Oliver on 7/21/16.
//  Copyright © 2016 Oliver Games LLC. All rights reserved.
//

import UIKit
import Foundation

class StoreViewController: UIViewController {
    
    @IBOutlet var mapcontainer: UIView!
    let const_size:Int = 29
    
    override func viewDidLoad() {
        super.viewDidLoad()
        checkFile()
        //populate()
    }
    
    @IBAction func clickRepopulate(sender: AnyObject) {
        
        //populate()
        checkFile()
        
    }
    
    func checkFile(){
        let fileLocation = NSBundle.mainBundle().pathForResource("MapNumRep", ofType: "txt")!
        var text : String
        do
        {
            text = try String(contentsOfFile: fileLocation)
        }
        catch
        {
            text = ""
        }
        let array = init_array_from_file(text)
        populate(array)
       
    }
    
    func init_array_from_file(text:String) -> [[Int]]{
        //initialize the double array that will hold the contents of our map file
        var grid = [[Int]]()
        var curr_ind = 0
        for i in 0...const_size {
            var rowX = [Int]()
            for j in 0...const_size {
                //in swift you have to create n initialize a single array that gets added to the double array - add a row to the grid
                let index = text.startIndex.advancedBy(curr_ind++)
                let num = Int(String(text[index]))!
                rowX.append(num)
            }
            //add the recently made row to the grid
            grid.append(rowX)
            //there is an extra \n character in the files, so skip this
            curr_ind++
        }
        print(grid)
        return grid
    }
    
    func populate(text: [[Int]]) {
        //var randomnum = 0
        mapcontainer.backgroundColor = UIColor.blackColor()
        view.addSubview(mapcontainer)
        var x_var = 0
        var y_var = 0
        var firstCGPoint: CGPoint
        var firstFrame: CGRect
        let firstSize = CGSize(width: 10, height: 10)
        var firstView: UIView
        for row in 0...29 {
            for col in 0...29 {
                let randomnum = text[col][row]//Int(arc4random_uniform(3))
                x_var = row * 10
                y_var = col * 10
                firstCGPoint = CGPoint(x: x_var, y: y_var)
                firstFrame = CGRect(origin: firstCGPoint, size: firstSize)
                firstView = UIView(frame: firstFrame)
                firstView.layer.borderWidth = 1
                firstView.layer.borderColor = UIColor(red: 0, green: 0, blue: 0, alpha: 1).CGColor
                if randomnum == 0 {
                    firstView.backgroundColor = UIColor.whiteColor()
                } else if randomnum == 1 {
                    firstView.backgroundColor = UIColor.greenColor()
                } else if randomnum == 2 {
                    firstView.backgroundColor = UIColor.blueColor()
                } else if randomnum == 3 {
                    firstView.backgroundColor = UIColor.redColor()
                }
                mapcontainer.addSubview(firstView)
            }
        }
    }
}
