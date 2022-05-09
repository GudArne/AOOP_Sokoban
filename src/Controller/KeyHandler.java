package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Models.DataModel;

public class KeyHandler implements KeyListener {
    public boolean up, down, left, right, anyPressed, esc = false;
    DataModel dataModel;

    public KeyHandler(DataModel dataModel) {
        this.dataModel = dataModel;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            up = true; anyPressed = true;
            dataModel.update("up");
        }
        if(code == KeyEvent.VK_A)
        {
            left = true; anyPressed = true;
            dataModel.update("left");
        }
        if(code == KeyEvent.VK_S)
        {
            down = true; anyPressed = true;
            dataModel.update("down");
        }
        if(code == KeyEvent.VK_D){
            right = true; anyPressed = true;
            dataModel.update("right");
        }
        if(code == KeyEvent.VK_ESCAPE)
        {
            esc = true;
            dataModel.update("esc");
            System.out.println("Game restarted");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void addChangeListener(ChangeListener listener) {
        if(anyPressed)
            listener.stateChanged(new ChangeEvent(this));
    }
}
