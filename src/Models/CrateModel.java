package Models;

import Entities.Crate;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class CrateModel {
    GamePanel gamePanel;
    public ArrayList<Crate> objectArrayList;
    public TileModel tileModel;
    //TODO get funktioner

    public CrateModel(GamePanel gamePanel,  TileModel tileModel){
        this.gamePanel = gamePanel;
        objectArrayList = new ArrayList<>();
        this.tileModel = tileModel;
        setObjects();
    }


    private void setObjects(){ // Sets the crates in the game
        try {
            objectArrayList.add(new Crate(3* gamePanel.tileSize, 2* gamePanel.tileSize, ImageIO.read(new File("src/Resources/Objects/crate.png")),false));
            objectArrayList.add(new Crate(4* gamePanel.tileSize, 3* gamePanel.tileSize, ImageIO.read(new File("src/Resources/Objects/crate.png")),false));
            objectArrayList.add(new Crate(4* gamePanel.tileSize, 4* gamePanel.tileSize, ImageIO.read(new File("src/Resources/Objects/crate.png")),false));
            objectArrayList.add(new Crate(3* gamePanel.tileSize, 6* gamePanel.tileSize, ImageIO.read(new File("src/Resources/Objects/crate.png")),false));
            objectArrayList.add(new Crate(1* gamePanel.tileSize, 6* gamePanel.tileSize, ImageIO.read(new File("src/Resources/Objects/crate.png")),false));
            objectArrayList.add(new Crate(4* gamePanel.tileSize, 6* gamePanel.tileSize, ImageIO.read(new File("src/Resources/Objects/crate.png")),false));
            objectArrayList.add(new Crate(5* gamePanel.tileSize, 6* gamePanel.tileSize, ImageIO.read(new File("src/Resources/Objects/crate.png")),false));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Crate getCrate(int x, int y){
        for(int i = 0; i<objectArrayList.size();i++)
        {
            if(objectArrayList.get(i).yPos == y && objectArrayList.get(i).xPos == x)
                return objectArrayList.get(i);
        }
        return null;
    }
    public void swapImage(int x, int y) {
        try {
            if(!getCrate(x, y).marked)
                getCrate(x,y).image = ImageIO.read(new File("src/Resources/Objects/cratemarked.png"));
            else
                getCrate(x,y).image = ImageIO.read(new File("src/Resources/Objects/crate.png"));
        } catch (Exception e) {
            e.printStackTrace();
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
                if (!tileModel.tiles.get(tileModel.getTile(x, y - 2 * gamePanel.tileSize)).collision && getCrate(x, y - 2 * gamePanel.tileSize) == null) {
                    return true;
                }
            }

            case "down" -> {
                if (!tileModel.tiles.get(tileModel.getTile(x, y + 2 * gamePanel.tileSize)).collision && getCrate(x, y + 2 * gamePanel.tileSize) == null) {
                    return true;
                }
            }

            case "left" -> {
                if (!tileModel.tiles.get(tileModel.getTile(x - 2 * gamePanel.tileSize, y )).collision && getCrate(x - 2 * gamePanel.tileSize, y ) == null) {
                    return  true;
                }
            }

            case "right" -> {
                if (!tileModel.tiles.get(tileModel.getTile(x + 2 * gamePanel.tileSize, y)).collision && getCrate(x + 2 * gamePanel.tileSize, y) == null) {
                    return true;
                }
            }
        }
        return false;
    }
    public void moveCrate(Crate crate, String direction){
        switch (direction){
            case "up" -> {
                crate.setyPos(crate.yPos - gamePanel.tileSize);
            }
            case "down" -> {
                crate.yPos += gamePanel.tileSize;
            }
            case "left" -> {
                crate.xPos -= gamePanel.tileSize;
            }
            case "right" -> {setCrateX(crate, 0);
            }
        }
    }
    public ArrayList<Crate> getObjectArrayList() {
        return objectArrayList;
    }
    public void setCrateX(Crate crate, int x){
        objectArrayList.get(x).xPos += gamePanel.tileSize;
    }
}
