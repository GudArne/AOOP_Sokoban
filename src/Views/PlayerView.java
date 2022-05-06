package Views;

import Controller.KeyHandler;
import Entities.Player;
import Main.GamePanel;
import Models.PlayerModel;

import java.awt.*;

public class PlayerView extends PlayerModel {
  KeyHandler keyHandler;
  GamePanel gamePanel;
    PlayerView(GamePanel gamePanel,KeyHandler keyHandler){
        super(gamePanel, keyHandler);
    }
    public void draw(Graphics2D graphics2D){
        graphics2D.drawImage(playerImage,getX(),getY(), gamePanel.tileSize,gamePanel.tileSize,null);
    }
}
