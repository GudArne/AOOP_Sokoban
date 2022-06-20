package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Models.PlayerModel;

public class KeyHandler extends Handler {
    private PlayerModel playerModel;
    private ArrayList<Integer> macroKeys = new ArrayList<Integer>();

    public KeyHandler(PlayerModel playerModel) {
        super(playerModel);
        setPredefinedPath(macroKeys);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    
    // Triggers the update to the data model via handler
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_0) { // loop through predefined path and update data model recursively
            setMacro(true);
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
            setMacro(false);
        }

        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
            moveUp();    

        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT)
            moveLeft();

        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)
            moveDown();
            

        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT)
            moveRight();

        if(code == KeyEvent.VK_ESCAPE){
            restart();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    // sets the predifined path for auto completion
    private void setPredefinedPath(ArrayList<Integer> macroKeys){
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

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
