package Main;

import Controller.GameController;
import Controller.Handler;
import Controller.KeyHandler;
import Controller.MouseHandler;
import Controller.StatsController;
import Models.CrateModel;
import Models.DataModel;
import Models.PlayerModel;
import Models.StatsModel;
import Models.TileModel;
import Views.*;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{

    public final int tileSize = 48;
    private final int screenWidth = tileSize * 8;
    private final int screenHeight = tileSize * 9;

    private Handler handler;
    private KeyHandler keyHandler;
    private MouseHandler mouseHandler;
    private GameController gameController;
    private StatsController statsController;
    
    private DataModel dataModel;
    private TileModel tileModel;
    private CrateModel crateModel;
    private PlayerModel playerModel;
    private StatsModel statsModel;

    private TileView tileView;
    private CrateView crateView;
    private PlayerView playerView;
    private StatsView statsView;
    private ButtonView buttonView;
    private ScreenView screenView;


    public GamePanel() {
        this.statsView = new StatsView();
        this.tileView = new TileView(this);
        this.statsModel = new StatsModel(statsView);
        this.tileModel = new TileModel(this);
        this.crateModel = new CrateModel(this, tileModel, statsView);
        this.playerModel = new PlayerModel(this, tileModel, crateModel);
        this.playerView = new PlayerView(this, playerModel);
        this.crateView =  new CrateView(this,crateModel);
        this.screenView = new ScreenView(this, crateModel);
        this.gameController = new GameController(crateView, playerView, tileView, screenView);
        this.statsController = new StatsController(statsModel);
        
        // Attach observers
        playerModel.addPropertyChangeListener(gameController);
        playerModel.addPropertyChangeListener(statsController);

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }

    // sets which controller to use
    public void setController(Handler handler){
        this.handler = handler;
        if(handler.getClass() == MouseHandler.class)
        {
            mouseHandler = new MouseHandler(playerModel);
            buttonView = new ButtonView(handler);
        }
        else if(handler.getClass() == KeyHandler.class)
        {
            keyHandler = new KeyHandler(playerModel);
            this.addKeyListener(handler);
        }
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

    // Repaint the view on game startup.
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D)graphics;

        tileView.draw(graphics2D);
        crateView.draw(graphics2D);
        playerView.draw(graphics2D);
        graphics2D.dispose();
    }
}