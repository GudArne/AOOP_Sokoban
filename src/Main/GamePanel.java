package Main;



import Controller.KeyHandler;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{

    public final int tileSize = 48;
    public final int screenWidth = tileSize * 10;
    public final int screenHeight = tileSize * 9;
    private int attempts, stepCount = 0;

    KeyHandler keyHandler = new KeyHandler();


    public GamePanel(){

        this.add(new JLabel("test"));
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);

    }
}
