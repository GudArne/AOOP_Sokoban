package Views;

import Controller.KeyHandler;
import Entities.Player;
import Main.GamePanel;
import Models.DataModel;
import Models.PlayerModel;

import java.awt.*;

public class PlayerView extends PlayerModel {
  KeyHandler keyHandler;
  GamePanel gamePanel;
  DataModel dataModel;
    PlayerView(GamePanel gamePanel, DataModel dataModel){
        super(gamePanel, dataModel);
    }
    public void draw(Graphics2D graphics2D){
        graphics2D.drawImage(playerImage,getX(),getY(), gamePanel.tileSize,gamePanel.tileSize,null);
    }
}
