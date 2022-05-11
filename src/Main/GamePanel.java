package Main;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


import Controller.KeyHandler;
import Models.CrateModel;
import Models.DataModel;
import Models.PlayerModel;
import Models.TileModel;
import Views.*;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements ChangeListener{

    public final int tileSize = 48;
    public final int screenWidth = tileSize * 8;
    public final int screenHeight = tileSize * 9;
    private int attempts, stepCount = 0;

    KeyHandler keyHandler;
    DataModel dataModel;
    TileView tileView = new TileView(this);
    TileModel tileModel = new TileModel(this);

    CrateModel crateModel;
    CrateView crateView;
    PlayerModel playerModel;
    PlayerView playerView;
    StatsView statsView;

    ScreenView screenView;


    public GamePanel(DataModel dataModel) {

        this.dataModel = dataModel;
        this.statsView = new StatsView("attempts: ",stepCount);
        this.crateModel = new CrateModel(this,tileModel, statsView);
        this.playerModel = new PlayerModel(this, dataModel,tileModel, crateModel, statsView);
        this.playerView = new PlayerView(this,dataModel,tileModel,playerModel);
        this.crateView =  new CrateView(this,crateModel);
        this.screenView = new ScreenView(this, crateModel);

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

        tileView.draw(graphics2D);
        crateView.draw(graphics2D);
        playerView.draw(graphics2D);
        screenView.draw(graphics2D);

        graphics2D.dispose();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        playerModel.update();
        repaint();
    }

}