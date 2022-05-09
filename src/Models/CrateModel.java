package Models;

import Entities.Crate;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class CrateModel {
    GamePanel gamePanel;
    ArrayList<Crate> objectArrayList;
    TileModel tileModel;

    public CrateModel(GamePanel gamePanel,  TileModel tileModel){
        this.gamePanel = gamePanel;
        objectArrayList = new ArrayList<>();
        this.tileModel = tileModel;
        setObjects();
    }

    private void setObjects(){ // Sets the crates in the game
        try {
            objectArrayList.add(new Crate(3* gamePanel.tileSize, 2* gamePanel.tileSize, ImageIO.read(new File("Pictures/Crate/crate.png")),false));
            objectArrayList.add(new Crate(4* gamePanel.tileSize, 3* gamePanel.tileSize, ImageIO.read(new File("Pictures/Crate/crate.png")),false));
            objectArrayList.add(new Crate(4* gamePanel.tileSize, 4* gamePanel.tileSize, ImageIO.read(new File("Pictures/Crate/crate.png")),false));
            objectArrayList.add(new Crate(3* gamePanel.tileSize, 6* gamePanel.tileSize, ImageIO.read(new File("Pictures/Crate/crate.png")),false));
            objectArrayList.add(new Crate(1* gamePanel.tileSize, 6* gamePanel.tileSize, ImageIO.read(new File("Pictures/Crate/crate.png")),false));
            objectArrayList.add(new Crate(4* gamePanel.tileSize, 6* gamePanel.tileSize, ImageIO.read(new File("Pictures/Crate/crate.png")),false));
            objectArrayList.add(new Crate(5* gamePanel.tileSize, 6* gamePanel.tileSize, ImageIO.read(new File("Pictures/Crate/crate.png")),false));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Crate getObject(int x, int y){
        for(int i = 0; i<objectArrayList.size();i++)
        {
            if(objectArrayList.get(i).yPos == y && objectArrayList.get(i).xPos == x)
                return objectArrayList.get(i);
        }
        return null;
    }
    public void swapImage(int x, int y) {
        try {
            if(!getObject(x, y).marked)
                getObject(x,y).image = ImageIO.read(new File("Pictures/Crate/cratemarked.png"));
            else
                getObject(x,y).image = ImageIO.read(new File("Pictures/Crate/crate.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2D) { //view
        for(int i = 0; i < objectArrayList.size(); i++){
            graphics2D.drawImage(objectArrayList.get(i).image,objectArrayList.get(i).xPos,objectArrayList.get(i).yPos,gamePanel.tileSize,gamePanel.tileSize,null);
        }
    }
    public boolean checkIfWon(){
        for(int i = 0; i < objectArrayList.size(); i++){
            if(!objectArrayList.get(i).marked)
                return false;
        }
        return true;
    }
    public boolean checkCrateCollision(String s, int x, int y){
        switch (s){
            case "up" -> {
                if (!tileModel.tiles.get(tileModel.getTile(x, y - 2 * gamePanel.tileSize)).collision && getObject(x, y - 2 * gamePanel.tileSize) == null) {
                    return true;
                }
            }

            case "down" -> {
                if (!tileModel.tiles.get(tileModel.getTile(x, y + 2 * gamePanel.tileSize)).collision && getObject(x, y + 2 * gamePanel.tileSize) == null) {
                    return true;
                }
            }

            case "left" -> {
                if (!tileModel.tiles.get(tileModel.getTile(x - 2 * gamePanel.tileSize, y )).collision && getObject(x - 2 * gamePanel.tileSize, y ) == null) {
                    return  true;
                }
            }

            case "right" -> {
                if (!tileModel.tiles.get(tileModel.getTile(x + 2 * gamePanel.tileSize, y)).collision && getObject(x + 2 * gamePanel.tileSize, y) == null) {
                    return true;
                }
            }
        }
        return false;
    }
}
