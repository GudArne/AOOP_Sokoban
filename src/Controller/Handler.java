package Controller;

import java.awt.event.*;
import Models.PlayerModel;

public abstract class Handler implements ActionListener, KeyListener {

    private boolean macro = false;
    private PlayerModel playerModel;

    public Handler(PlayerModel playerModel) {
        this.playerModel = playerModel;
    }

    // Updates the data model with a event change
    public void moveUp(){
        playerModel.update("up");
    }
    public void moveDown(){
        playerModel.update("down");
    }
    public void moveLeft(){
        playerModel.update("left");
    }
    public void moveRight(){
        playerModel.update("right");
    }
    public void restart(){
        playerModel.update("esc");
    }

    // Gets the boolean macro
    public boolean getMacro(){
        return macro;
    }
    // Sets the boolean macro
    public void setMacro(boolean macro){
        this.macro = macro;
    }
}
