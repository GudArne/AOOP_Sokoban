package Main;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


import Controller.KeyHandler;
import Controller.MouseHandler;
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
    private int stepCount = 0;

    KeyHandler keyHandler;
    DataModel dataModel;
    TileView tileView;
    TileModel tileModel;
    CrateModel crateModel;
    CrateView crateView;
    PlayerModel playerModel;
    PlayerView playerView;
    StatsView statsView;
    ButtonView buttonView;
    MouseHandler mouseHandler;

    ScreenView screenView;
    String data = "";

    public GamePanel() {

        this.dataModel =  new DataModel(data);
        this.dataModel.attach(this);

        this.keyHandler = new KeyHandler(dataModel);
        this.statsView = new StatsView("attempts: ",stepCount);
        this.mouseHandler = new MouseHandler(dataModel);
        this.buttonView = new ButtonView(mouseHandler);
        this.tileView = new TileView(this);
        this.tileModel = new TileModel(this);
        this.crateModel = new CrateModel(this,tileModel, statsView);
        this.playerModel = new PlayerModel(this, dataModel,tileModel, crateModel, statsView);
        this.playerView = new PlayerView(this,dataModel,tileModel,playerModel);
        this.crateView =  new CrateView(this,crateModel);
        this.screenView = new ScreenView(this, crateModel);

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }
    // get gamePanel
    public GamePanel getGamePanel(){
        return this;
    }
    public DataModel getDataModel(){
        return dataModel;
    }
    // get playerModel
    public PlayerModel getPlayerModel(){
        return playerModel;
    }
    // get crateModel
    public CrateModel getCrateModel(){
        return crateModel;
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
        if(keyHandler.macro)
        super.paint(getGraphics());
        else
            repaint();
    }

}