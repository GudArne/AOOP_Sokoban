package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean up, down, left, right, anyPressed, esc;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W)
            up = true; anyPressed = true;
        if(code == KeyEvent.VK_A)
            left = true; anyPressed = true;
        if(code == KeyEvent.VK_S)
            down = true; anyPressed = true;
        if(code == KeyEvent.VK_D)
            right = true; anyPressed = true;
        if(code == KeyEvent.VK_ESCAPE)
        {
            esc = true;
            System.out.println("Game restarted");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
