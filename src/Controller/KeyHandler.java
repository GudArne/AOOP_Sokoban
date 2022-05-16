package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import Models.DataModel;

public class KeyHandler implements KeyListener {
    public boolean macro = false;
    DataModel dataModel;
    ArrayList<Integer> macroKeys = new ArrayList<Integer>();
    

    public KeyHandler(DataModel dataModel) {
        this.dataModel = dataModel;
        setPredefinedPath(macroKeys);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_0) { // loop through predefined path and update data model recursively
            macro = true;
            // Create a new KeyEvent to simulate the key press
            KeyEvent keyEvent = new KeyEvent(e.getComponent(), e.getID(), e.getWhen(), e.getModifiersEx(), e.getKeyCode(), e.getKeyChar());
            
            for (Integer key : macroKeys) {
                // wait 150 ms
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                // manipulate the key event
                keyEvent.setKeyCode(key);
                // send the KeyEvent to the key listener
                keyPressed(keyEvent);
            }
            macro = false;
            System.out.println("Macro done");
        }

        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
            dataModel.update("up");

        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT)
            dataModel.update("left");

        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)
            dataModel.update("down");

        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT)
            dataModel.update("right");
            
        if(code == KeyEvent.VK_ESCAPE){
            dataModel.update("esc");
            System.out.println("Game restarted");
        }
    }
    
    String direction;
    public void update(ArrayList<Integer> values){
        for (int dir : values) {
            switch (dir) {
                case 38:
                    direction = "up";
                    dataModel.update(direction);
                    break;
                case 40:
                    direction = "down";
                    dataModel.update(direction);
                    break;
                case 37:
                    direction = "left";
                    dataModel.update(direction);
                    break;
                case 39:
                    direction = "right";
                    dataModel.update(direction);
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void setPredefinedPath(ArrayList<Integer> macroKeys){
        this.macroKeys = macroKeys;
        macroKeys.add(KeyEvent.VK_ESCAPE);
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
        macroKeys.add(KeyEvent.VK_RIGHT);
    }
}
