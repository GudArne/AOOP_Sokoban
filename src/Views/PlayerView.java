package Views;

import Controller.KeyHandler;
import Entities.Player;
import Main.GamePanel;
import Models.DataModel;
import Models.PlayerModel;
import Models.TileModel;

import java.awt.*;

public class PlayerView extends PlayerModel {
  KeyHandler keyHandler;
  GamePanel gamePanel;
  DataModel dataModel;
  TileModel tileModel;
    public PlayerView(GamePanel gamePanel, DataModel dataModel,TileModel tileModel){
        super(gamePanel, dataModel, tileModel); //TODO why is this null?
        this.gamePanel = gamePanel;
        this.dataModel = dataModel;
        this.tileModel = tileModel;
    }
    public void draw(Graphics2D graphics2D){
        graphics2D.drawImage(playerImage,getX(),getY(), gamePanel.tileSize,gamePanel.tileSize,null);
    }
}
