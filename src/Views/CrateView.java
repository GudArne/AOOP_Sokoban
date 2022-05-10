package Views;

import Main.GamePanel;
import Models.CrateModel;
import Models.DataModel;
import Models.TileModel;

import java.awt.*;

public class CrateView{
    CrateModel crateModel;
    GamePanel gamePanel;
    DataModel dataModel;
    public CrateView(GamePanel gamePanel, CrateModel crateModel, DataModel dataModel) {
        this.crateModel = crateModel;
        this.gamePanel = gamePanel;
        this.dataModel = dataModel;
    }

    public void draw(Graphics2D graphics2D) { //view
        for(int i = 0; i < crateModel.objectArrayList.size(); i++){
                    graphics2D.drawImage(crateModel.getObjectArrayList().get(i).image,crateModel.getObjectArrayList().get(i).xPos,crateModel.getObjectArrayList().get(i).yPos,gamePanel.tileSize, gamePanel.tileSize,null);
            System.out.println(crateModel.getObjectArrayList().get(i).xPos + " xpos at index" + i);
        }
    }
}
