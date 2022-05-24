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
    private GamePanel gamePanel;
    private DataModel dataModel;
    private PlayerModel playerModel;

    // Constructs a PlayerView object
    public PlayerView(GamePanel gamePanel, DataModel dataModel,TileModel tileModel, PlayerModel playerModel){
        this.gamePanel = gamePanel;
        this.dataModel = dataModel;
        this.playerModel = playerModel;
    }
    // Gets the image of the player
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

    // Draw the view
    public void draw(Graphics2D graphics2D){
        graphics2D.drawImage(getImage(),playerModel.getX(),playerModel.getY(), gamePanel.tileSize,gamePanel.tileSize,null);
    }
}
