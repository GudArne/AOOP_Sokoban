package Controller;

import java.awt.event.*;

import Models.PlayerModel;

public class MouseHandler extends Handler {

    public MouseHandler(PlayerModel playerModel) {
        super(playerModel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String code = e.getActionCommand();

        if(code.equals("up"))
            moveUp();

        if(code.equals("left"))
            moveLeft();

        if(code.equals("down"))
            moveDown();

        if(code.equals("right"))
            moveRight();

        if(code.equals("restart"))
            restart();
        
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
