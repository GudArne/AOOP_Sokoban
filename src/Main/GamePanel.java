package Main;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import Controller.Handler;
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
    private String data = "";

    private Handler handler;
    private KeyHandler keyHandler;
    private MouseHandler mouseHandler;
    
    private DataModel dataModel;
    private TileModel tileModel;
    private CrateModel crateModel;
    private PlayerModel playerModel;

    private TileView tileView;
    private CrateView crateView;
    private PlayerView playerView;
    private StatsView statsView;
    private ButtonView buttonView;
    private ScreenView screenView;


    public GamePanel() {
        this.dataModel =  new DataModel(data);
        this.dataModel.attach(this);
        this.statsView = new StatsView("attempts: ",stepCount);
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
        this.setFocusable(true);
    }

    // sets which controller to use
    public void setController(Handler handler){
        this.handler = handler;
        if(handler.getClass() == MouseHandler.class)
        {
            this.mouseHandler = new MouseHandler(dataModel);
            this.buttonView = new ButtonView(handler);
        }
        else if(handler.getClass() == KeyHandler.class)
        {
            this.keyHandler = new KeyHandler(dataModel);
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
    // repaint the views
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D)graphics;

        tileView.draw(graphics2D);
        crateView.draw(graphics2D);
        playerView.draw(graphics2D);
        screenView.draw(graphics2D);
        graphics2D.dispose();
    }

    // Invoked when a controller triggers a change event.
    @Override
    public void stateChanged(ChangeEvent e) {
        playerModel.update();
        
        // If the auto complete button is pressed, the super method needs to be called. 
        // Otherwise, the game will not be updated visually for the user.
        if(handler.getMacro())
            super.paint(getGraphics());
        else
            repaint();
    }

}