/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc545termproject;

import javax.swing.*;
import java.awt.event.*;
import csc545termproject.Command;
import csc545termproject.ChainCommand;


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
    private ChainCommand exitHandler = null;
    private class CloseCommand implements Command{
        public void execute(Object data){
            //cleanup logic
        }
    }
    
    public GUIFrame(){
        setTitle("Recipe Helper App");
        setSize(300,500);
        setLocation(0,0);
        exitHandler = new ChainCommand(new CloseCommand(), null);
    }
    //passes exit command to windowlistener, will perform cleanup logic
    //before the passed exit command is called
    public void OnExit(Command handler){
        //exitHandler = handler;
        exitHandler.setNext(handler);
        addWindowListener(new GUIFrameWindowListener(exitHandler));
    }
    
    

};

public class GUI {
    private GUIFrame frame;
    
    public GUI(){
        frame = new GUIFrame();
    }
    
    //use this to set what happens when the frame exits.
    //to add additional destructor logic, add a ChainCommand
    //to this class
    public void onExit(Command handler){
        frame.OnExit(handler);
    }
    
    public void Start(){
        frame.setVisible(true);
    }
    
}
