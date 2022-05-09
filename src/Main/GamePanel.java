package Main;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


import Controller.KeyHandler;
import Models.DataModel;
import Models.TileModel;
import Views.TileView;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements ChangeListener{

    public final int tileSize = 48;
    public final int screenWidth = tileSize * 10;
    public final int screenHeight = tileSize * 9;
    private int attempts, stepCount = 0;

    KeyHandler keyHandler;
    DataModel dataModel;
    TileView tileView = new TileView(this);


    public GamePanel(DataModel dataModel) {

        this.dataModel = dataModel;
        this.add(new JLabel("test"));
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.addKeyListener(new KeyHandler(dataModel));
        this.setFocusable(true);

    }
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D)graphics;
        // if(interreaction.checkIfWon()){
        //     gameOver.draw(graphics2D);
        // }
        // else {
             tileView.draw(graphics2D);
        //     player.draw(graphics2D);
        //     interreaction.draw(graphics2D);
        //     graphics2D.dispose();
        // }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        //a = dataModel.getData();
        repaint();
        System.out.println("stateChanged");
        
    }

}
