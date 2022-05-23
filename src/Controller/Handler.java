package Controller;

import java.awt.event.*;

import Models.DataModel;

public abstract class Handler implements ActionListener, KeyListener {

    private DataModel dataModel;
    private boolean macro = false;

    public Handler(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    // Updates the data model with a event change
    public void moveUp(){
        dataModel.update("up");
    }
    public void moveDown(){
        dataModel.update("down");
    }
    public void moveLeft(){
        dataModel.update("left");
    }
    public void moveRight(){
        dataModel.update("right");
    }
    public void restart(){
        dataModel.update("esc");
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
