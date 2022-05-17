package Controller;

import java.awt.event.*;

import Models.DataModel;

public abstract class Handler implements ActionListener, KeyListener {

    private DataModel dataModel;
    public boolean macro = false;

    public Handler(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    // Updated the data model with a event change
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
    
}
