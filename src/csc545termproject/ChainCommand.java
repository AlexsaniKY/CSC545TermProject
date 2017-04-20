/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc545termproject;

public class ChainCommand implements Command{
    private Command firstCommand;
    private Command nextCommand;
    public ChainCommand(Command first, Command next){
        firstCommand = first;
        nextCommand = next;
    }
    public void setFirst(Command first){firstCommand = first;}
    public void setNext(Command next){nextCommand = next;}
    public void execute(Object data){
    if (firstCommand != null)
        firstCommand.execute(data);
    if (nextCommand != null)
        nextCommand.execute(data);
    };
}