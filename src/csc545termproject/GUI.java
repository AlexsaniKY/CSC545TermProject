/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc545termproject;

import javax.swing.*;
import java.awt.event.*;
import csc545termproject.Command;


class GUIFrameWindowListener extends WindowAdapter{
        private Command closeEvent = null;
        public GUIFrameWindowListener(Command closeCommand){
            closeEvent = closeCommand;
        }
        public void windowClosing(WindowEvent e){
            if(closeEvent != null){
                closeEvent.execute(null);
            }
        }
    }

class GUIFrame extends JFrame{
    //private Command exitHandler = null;
    
    public GUIFrame(){
        setTitle("Recipe Helper App");
        setSize(300,500);
        setLocation(0,0);
    }
    //currently passes exit command to windowlistener, can be used to
    //create exit handler on this class as well
    public void OnExit(Command handler){
        //exitHandler = handler;
        addWindowListener(new GUIFrameWindowListener(handler));
    }
    
    

};

public class GUI {
    private GUIFrame frame;
    public GUI(){
        frame = new GUIFrame();
    }
    
    //use this to set what happens when the frame exits
    public void onExit(Command handler){
        frame.OnExit(handler);
    }
    
    public void Start(){
        frame.setVisible(true);
    }
    
}
