package Views;

import Main.GamePanel;
import Models.TileModel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Objects;

public class TileView extends TileModel {

    // Constructs a TileView object
    public TileView(GamePanel gamePanel) {
        super(gamePanel);
    }

    // Returns the image of the tile
    private BufferedImage getImage(String name){
        BufferedImage image;
        try {
            if(Objects.equals(name, "blank")){
                image = ImageIO.read(new File("src/Resources/Tiles/blank.png"));
                return image;
            }
            else if(Objects.equals(name, "blankmarked")){
                image = ImageIO.read(new File("src/Resources/Tiles/blankmarked.png"));
                return image;
            }
            else if(Objects.equals(name,"wall")){
                image = ImageIO.read(new File("src/Resources/Tiles/wall.png"));
                return image;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    // Draw the view
    public void draw(Graphics2D graphics2D) {
        int secondArray = 0;
        int firstArray = 0;

        int yPos = 0;
        int xPos = 0;
        GamePanel gamePanel = getGamePanel();

        while(firstArray < numTiles.size()){
            BufferedImage image = getImage(tiles.get(numTiles.get(firstArray).get(secondArray)).name);
            graphics2D.drawImage(image,xPos,yPos,gamePanel.tileSize ,gamePanel.tileSize,null);
            xPos += gamePanel.tileSize;
            secondArray++;

            if(secondArray == numTiles.get(firstArray).size()){
                secondArray = 0;
                xPos = 0;

                firstArray++;
                yPos += gamePanel.tileSize;
            }
        }
    }
}
