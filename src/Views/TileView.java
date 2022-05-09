package Views;

import Entities.Tile;
import Main.GamePanel;
import Models.TileModel;

import java.awt.*;
import java.util.ArrayList;

public class TileView extends TileModel {

    public TileView(GamePanel gamePanel) {
        super(gamePanel);
    }


    public void draw(Graphics2D graphics2D) { //View
        int secondArray = 0;
        int firstArray = 0;

        int yPos = 0;
        int xPos = 0;
        GamePanel gamePanel = getGamePanel();
        while(firstArray < numTiles.size())
        {
            graphics2D.drawImage(tiles.get(numTiles.get(firstArray).get(secondArray)).tileImage,xPos,yPos,gamePanel.tileSize ,gamePanel.tileSize,null);
            xPos += gamePanel.tileSize;
            secondArray++;

            if(secondArray == numTiles.get(firstArray).size())
            {
                secondArray = 0;
                xPos = 0;

                firstArray++;
                yPos += gamePanel.tileSize;

            }
        }
    }
}
