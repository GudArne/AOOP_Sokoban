package Views;

import Main.GamePanel;
import Models.DataModel;
import Models.PlayerModel;
import Models.TileModel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class PlayerView {
  GamePanel gamePanel;
  DataModel dataModel;
  PlayerModel playerModel;
    public PlayerView(GamePanel gamePanel, DataModel dataModel,TileModel tileModel, PlayerModel playerModel){
        this.gamePanel = gamePanel;
        this.dataModel = dataModel;
        this.playerModel = playerModel;
    }
    private BufferedImage getImage(){
        BufferedImage image;
        try {
            image = ImageIO.read(new File("src/Resources/Player/player.png"));
            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void draw(Graphics2D graphics2D){
        graphics2D.drawImage(getImage(),playerModel.getX(),playerModel.getY(), gamePanel.tileSize,gamePanel.tileSize,null);
    }
}
