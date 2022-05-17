package Models;

import Entities.Crate;
import Main.GamePanel;
import Views.StatsView;

import java.util.ArrayList;

public class CrateModel {
    GamePanel gamePanel;
    public ArrayList<Crate> objectArrayList;
    public TileModel tileModel;
    private int crateMarked = 0;
    StatsView statsView;

    public CrateModel(GamePanel gamePanel, TileModel tileModel, StatsView statsView) {
        this.gamePanel = gamePanel;
        objectArrayList = new ArrayList<>();
        this.tileModel = tileModel;
        this.statsView = statsView;
        setObjects();
        checkStart();
    }

    // Sets the crates in the game
    private void setObjects(){ 
        try {
            objectArrayList.add(new Crate(3* gamePanel.tileSize, 2* gamePanel.tileSize,false));
            objectArrayList.add(new Crate(4* gamePanel.tileSize, 3* gamePanel.tileSize,false));
            objectArrayList.add(new Crate(4* gamePanel.tileSize, 4* gamePanel.tileSize,false));
            objectArrayList.add(new Crate(3* gamePanel.tileSize, 6* gamePanel.tileSize,false));
            objectArrayList.add(new Crate(1* gamePanel.tileSize, 6* gamePanel.tileSize,false));
            objectArrayList.add(new Crate(4* gamePanel.tileSize, 6* gamePanel.tileSize,false));
            objectArrayList.add(new Crate(5* gamePanel.tileSize, 6* gamePanel.tileSize,false));
            crateMarked = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Checks if the crates stands on a marked tile in the beginning of the game
    private void checkStart(){
        for(Crate crate: objectArrayList){
            if(tileModel.checkMarked(crate.getxPos(), crate.getyPos())){
                swapMarked(crate);
            }
        }
    }
    // returns a crate object
    public Crate getCrate(int x, int y){
        for(int i = 0; i<objectArrayList.size();i++)
        {
            if(objectArrayList.get(i).yPos == y && objectArrayList.get(i).xPos == x)
                return objectArrayList.get(i);
        }
        return null;
    }
    // Swaps the the marked and unmarked crates
    public void swapMarked(Crate crate) {
        if(!crate.getMarked() && tileModel.checkMarked(crate.getxPos(), crate.getyPos())) {
            crate.setMarked(true);
            crateMarked++;
            statsView.setMarkedCrates(crateMarked);
        }

        else if(crate.getMarked() && !tileModel.checkMarked(crate.getxPos(), crate.getyPos())) {
            crate.setMarked(false);
            crateMarked--;
            statsView.setMarkedCrates(crateMarked);
        }
    }

    // Checks if all the crates are marked
    public boolean checkIfWon(){
        for(int i = 0; i < objectArrayList.size(); i++){
            if(!objectArrayList.get(i).marked)
                return false;
        }
        return true;
    }
    // Checks if the crate will collide in a speicific direction
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
    // Moves the crate in a specific direction
    public void moveCrate(Crate crate, String direction){
        switch (direction){
            case "up" -> crate.setyPos(crate.yPos - gamePanel.tileSize);
            case "down" -> crate.setyPos(crate.yPos + gamePanel.tileSize);
            case "left" -> crate.setxPos(crate.xPos - gamePanel.tileSize);
            case "right" -> crate.setxPos(crate.xPos + gamePanel.tileSize);
        }
    }
    // returns the objectArrayList (ArrayList of crates)
    public ArrayList<Crate> getObjectArrayList() {
        return objectArrayList;
    }
    // resets the position of the crates
    public void setRestart(){
        objectArrayList.clear();
        setObjects();
        checkStart();
    }
}
