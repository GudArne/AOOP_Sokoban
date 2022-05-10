package Main;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


import Controller.KeyHandler;
import Models.DataModel;
import Models.PlayerModel;
import Models.TileModel;
import Views.CrateView;
import Views.PlayerView;
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
    TileModel tileModel = new TileModel(this);
    CrateView crateView = new CrateView(this,tileModel);
    PlayerModel playerModel;
    PlayerView playerView;


    public GamePanel(DataModel dataModel) {

        this.dataModel = dataModel;
        this.playerModel = new PlayerModel(this, dataModel,tileModel);
        this.playerView = new PlayerView(this,dataModel,tileModel,playerModel);
        this.add(new JLabel("test"));
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.addKeyListener(new KeyHandler(dataModel));
        this.setFocusable(true);

    }
    // get gamePanel
    public GamePanel getGamePanel(){
        return this;
    }
    public DataModel getDataModel(){
        return dataModel;
    }
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D)graphics;
        // if(interreaction.checkIfWon()){
        //     gameOver.draw(graphics2D);
        // }
        // else {
            tileView.draw(graphics2D);
            playerView.draw(graphics2D);
            crateView.draw(graphics2D);
           graphics2D.dispose();
        // }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        //a = dataModel.getData();
        playerModel.update();
        repaint();
        //System.out.println("stateChanged");
        
    }

}
