package Views;

import Main.GamePanel;
import Models.CrateModel;
import Models.TileModel;

import java.awt.*;

public class CrateView extends CrateModel {
    public CrateView(GamePanel gamePanel, TileModel tileModel) {
        super(gamePanel, tileModel);
    }

    public void draw(Graphics2D graphics2D) { //view
        for(int i = 0; i < objectArrayList.size(); i++){
            graphics2D.drawImage(objectArrayList.get(i).image,objectArrayList.get(i).xPos,objectArrayList.get(i).yPos,tileModel.getGamePanel().tileSize, tileModel.getGamePanel().tileSize,null);
        }
    }
}
