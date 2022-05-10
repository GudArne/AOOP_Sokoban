package Views;

import Controller.KeyHandler;
import Entities.Player;
import Main.GamePanel;
import Models.DataModel;
import Models.PlayerModel;
import Models.TileModel;

import java.awt.*;

public class PlayerView {
  GamePanel gamePanel;
  DataModel dataModel;
  PlayerModel playerModel;
    public PlayerView(GamePanel gamePanel, DataModel dataModel,TileModel tileModel, PlayerModel playerModel){
        this.gamePanel = gamePanel;
        this.dataModel = dataModel;
        this.playerModel = playerModel;
    }
    public void draw(Graphics2D graphics2D){
        graphics2D.drawImage(playerModel.getPlayerImage(),playerModel.getX(),playerModel.getY(), gamePanel.tileSize,gamePanel.tileSize,null);
    }
}
