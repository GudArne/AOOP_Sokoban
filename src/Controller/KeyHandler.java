package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Models.DataModel;

public class KeyHandler implements KeyListener {
    public boolean up, down, left, right, anyPressed, esc, macro = false;
    DataModel dataModel;
    ArrayList<Integer> macroKeys = new ArrayList<Integer>();
    

    public KeyHandler(DataModel dataModel) {
        this.dataModel = dataModel;
        setPredefinedPath(macroKeys);
    }
    public void setPredefinedPath(ArrayList<Integer> macroKeys){
        this.macroKeys = macroKeys;
        macroKeys.add(KeyEvent.VK_RIGHT);
        macroKeys.add(KeyEvent.VK_RIGHT);
        macroKeys.add(KeyEvent.VK_UP);
        macroKeys.add(KeyEvent.VK_RIGHT);
        macroKeys.add(KeyEvent.VK_RIGHT);
        macroKeys.add(KeyEvent.VK_DOWN);
        macroKeys.add(KeyEvent.VK_DOWN);
        macroKeys.add(KeyEvent.VK_DOWN);
        macroKeys.add(KeyEvent.VK_DOWN);
        macroKeys.add(KeyEvent.VK_LEFT);
        macroKeys.add(KeyEvent.VK_DOWN);
        macroKeys.add(KeyEvent.VK_RIGHT);
        macroKeys.add(KeyEvent.VK_UP);
        macroKeys.add(KeyEvent.VK_UP);
        macroKeys.add(KeyEvent.VK_UP);
        macroKeys.add(KeyEvent.VK_UP);
        macroKeys.add(KeyEvent.VK_LEFT);
        macroKeys.add(KeyEvent.VK_LEFT);
        macroKeys.add(KeyEvent.VK_LEFT);
        macroKeys.add(KeyEvent.VK_RIGHT);
        macroKeys.add(KeyEvent.VK_DOWN);
        macroKeys.add(KeyEvent.VK_RIGHT);
        macroKeys.add(KeyEvent.VK_DOWN);
        macroKeys.add(KeyEvent.VK_RIGHT);
        macroKeys.add(KeyEvent.VK_DOWN);
        macroKeys.add(KeyEvent.VK_DOWN);
        macroKeys.add(KeyEvent.VK_LEFT);
        macroKeys.add(KeyEvent.VK_LEFT);
        macroKeys.add(KeyEvent.VK_DOWN);
        macroKeys.add(KeyEvent.VK_LEFT);
        macroKeys.add(KeyEvent.VK_LEFT);
        macroKeys.add(KeyEvent.VK_UP);
        macroKeys.add(KeyEvent.VK_UP);
        macroKeys.add(KeyEvent.VK_DOWN);
        macroKeys.add(KeyEvent.VK_RIGHT);
 
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_0) {
            macro = true;
            dataModel.update(macroKeys);
        }

        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            up = true; anyPressed = true;
            dataModel.update("up");
        }
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            left = true; anyPressed = true;
            dataModel.update("left");
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            down = true; anyPressed = true;
            dataModel.update("down");
        }
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            right = true; anyPressed = true;
            dataModel.update("right");
        }
        if(code == KeyEvent.VK_ESCAPE){
            esc = true;
            dataModel.update("esc");
            System.out.println("Game restarted");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void addChangeListener(ChangeListener listener) {
        if(anyPressed || macro)
            listener.stateChanged(new ChangeEvent(this));
    }
}
