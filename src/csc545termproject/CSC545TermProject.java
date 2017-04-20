/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc545termproject;

import csc545termproject.GUI.*;
import csc545termproject.Command;

public class CSC545TermProject {

    //command to end the program, should release any 
    //additional resources necessary
    public static class EndProgram implements Command{
        public void execute(Object data){
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.onExit(new EndProgram());
        gui.Start();
        // TODO code application logic here
    }
    
}
