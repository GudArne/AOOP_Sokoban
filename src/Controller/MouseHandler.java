package Controller;

import java.awt.event.*;

import Models.DataModel;

public class MouseHandler extends Handler {

    public MouseHandler(DataModel dataModel) {
        super(dataModel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String code = e.getActionCommand();
        System.out.println("Mouse clicked");

        if(code.equals("up"))
            moveUp();

        if(code.equals("left"))
            moveLeft();

        if(code.equals("down"))
            moveDown();

        if(code.equals("right"))
            moveRight();
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}
