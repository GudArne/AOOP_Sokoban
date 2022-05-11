package Models;

import Entities.Crate;
import Main.GamePanel;
import Views.StatsView;

import javax.imageio.ImageIO;
import java.io.File;
import java.net.CacheRequest;
import java.util.ArrayList;

public class CrateModel {
    GamePanel gamePanel;
    public ArrayList<Crate> objectArrayList;
    public TileModel tileModel;
    private int crateMarked = 0;
    StatsView statsView;
    //TODO get funktioner

    public CrateModel(GamePanel gamePanel, TileModel tileModel, StatsView statsView) {
        this.gamePanel = gamePanel;
        objectArrayList = new ArrayList<>();
        this.tileModel = tileModel;
        this.statsView = statsView;
        setObjects();
        checkStart();
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
            crateMarked = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void checkStart(){
        for(Crate crate: objectArrayList){
            if(tileModel.checkMarked(crate.getxPos(), crate.getyPos())){
                swapImage(crate);
            }
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
    public void swapImage(Crate crate) {
        try {
            if(!crate.getMarked() && tileModel.checkMarked(crate.getxPos(), crate.getyPos())){
                crate.image = ImageIO.read(new File("src/Resources/Objects/cratemarked.png"));
                crate.setMarked(true);
                crateMarked++;
                statsView.setMarkedCrates(crateMarked);
            }
            else if(crate.getMarked() && !tileModel.checkMarked(crate.getxPos(), crate.getyPos())){
                crate.image = ImageIO.read(new File("src/Resources/Objects/crate.png"));
                crate.setMarked(false);
                crateMarked--;
                statsView.setMarkedCrates(crateMarked);
            }
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
                if (!tileModel.tiles.get(tileModel.getTile(x, y - gamePanel.tileSize)).collision && getCrate(x, y - gamePanel.tileSize) == null) {
                    return true;
                }
            }

            case "down" -> {
                if (!tileModel.tiles.get(tileModel.getTile(x, y + gamePanel.tileSize)).collision && getCrate(x, y + gamePanel.tileSize) == null) {
                    return true;
                }
            }

            case "left" -> {
                if (!tileModel.tiles.get(tileModel.getTile(x - gamePanel.tileSize, y )).collision && getCrate(x - gamePanel.tileSize, y ) == null) {
                    return  true;
                }
            }

            case "right" -> {
                if (!tileModel.tiles.get(tileModel.getTile(x + gamePanel.tileSize, y)).collision && getCrate(x + gamePanel.tileSize, y) == null) {
                    return true;
                }
            }
        }
        return false;
    }
    public void moveCrate(Crate crate, String direction){
        switch (direction){
            case "up" -> crate.setyPos(crate.yPos - gamePanel.tileSize);
            case "down" -> crate.setyPos(crate.yPos + gamePanel.tileSize);
            case "left" -> crate.setxPos(crate.xPos - gamePanel.tileSize);
            case "right" -> crate.setxPos(crate.xPos + gamePanel.tileSize);
        }
    }
    public ArrayList<Crate> getObjectArrayList() {
        return objectArrayList;
    }
    public void setRestart(){
        objectArrayList.clear();
        setObjects();
        checkStart();
    }
}
