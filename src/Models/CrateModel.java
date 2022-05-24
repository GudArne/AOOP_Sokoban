package Models;

import Entities.Crate;
import Main.GamePanel;
import Views.StatsView;

import java.util.ArrayList;

public class CrateModel {
    private GamePanel gamePanel;
    private ArrayList<Crate> crates;
    private TileModel tileModel;
    private int crateMarked = 0;
    private StatsView statsView;

    public CrateModel(GamePanel gamePanel, TileModel tileModel, StatsView statsView) {
        this.gamePanel = gamePanel;
        this.crates = new ArrayList<>();
        this.tileModel = tileModel;
        this.statsView = statsView;
        setObjects();
        checkStart();
    }

    // Sets the crates in the game
    private void setObjects(){ 
        try {
            getCrates().add(new Crate(3* gamePanel.tileSize, 2* gamePanel.tileSize,false));
            getCrates().add(new Crate(4* gamePanel.tileSize, 3* gamePanel.tileSize,false));
            getCrates().add(new Crate(4* gamePanel.tileSize, 4* gamePanel.tileSize,false));
            getCrates().add(new Crate(3* gamePanel.tileSize, 6* gamePanel.tileSize,false));
            getCrates().add(new Crate(1* gamePanel.tileSize, 6* gamePanel.tileSize,false));
            getCrates().add(new Crate(4* gamePanel.tileSize, 6* gamePanel.tileSize,false));
            getCrates().add(new Crate(5* gamePanel.tileSize, 6* gamePanel.tileSize,false));
            crateMarked = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Checks if the crates stands on a marked tile in the beginning of the game
    private void checkStart(){
        for(Crate crate: getCrates()){
            if(tileModel.checkMarked(crate.getxPos(), crate.getyPos())){
                swapMarked(crate);
            }
        }
    }
    // returns a crate object
    public Crate getCrate(int x, int y){
        for(int i = 0; i<getCrates().size();i++)
        {
            if(getCrates().get(i).getyPos() == y && getCrates().get(i).getxPos() == x)
                return getCrates().get(i);
        }
        return null;
    }
    // returns an array of the crates
    public ArrayList<Crate> getCrates() {
        return crates;
    }
    // Swaps the the marked and unmarked crates
    public void swapMarked(Crate crate) {
        if(!crate.isMarked() && tileModel.checkMarked(crate.getxPos(), crate.getyPos())) {
            crate.setMarked(true);
            crateMarked++;
            statsView.setMarkedCrates(crateMarked, 7);
        }

        else if(crate.isMarked() && !tileModel.checkMarked(crate.getxPos(), crate.getyPos())) {
            crate.setMarked(false);
            crateMarked--;
            statsView.setMarkedCrates(crateMarked, 7);
        }
    }

    // Checks if all the crates are marked
    public boolean checkIfWon(){
        for(int i = 0; i < getCrates().size(); i++){
            if(!getCrates().get(i).isMarked())
                return false;
        }
        return true;
    }
    // Checks if the crate will collide in a speicific direction
    public boolean checkCrateCollision(String s, int x, int y){
        switch (s){
            case "up" -> {
                if (!tileModel.getTiles().get(tileModel.getTile(x, y - gamePanel.tileSize)).getCollision() && getCrate(x, y - gamePanel.tileSize) == null) {
                    return true;
                }
            }

            case "down" -> {
                if (!tileModel.getTiles().get(tileModel.getTile(x, y + gamePanel.tileSize)).getCollision() && getCrate(x, y + gamePanel.tileSize) == null) {
                    return true;
                }
            }

            case "left" -> {
                if (!tileModel.getTiles().get(tileModel.getTile(x - gamePanel.tileSize, y )).getCollision() && getCrate(x - gamePanel.tileSize, y ) == null) {
                    return  true;
                }
            }

            case "right" -> {
                if (!tileModel.getTiles().get(tileModel.getTile(x + gamePanel.tileSize, y)).getCollision() && getCrate(x + gamePanel.tileSize, y) == null) {
                    return true;
                }
            }
        }
        return false;
    }
    // Moves the crate in a specific direction
    public void moveCrate(Crate crate, String direction){
        switch (direction){
            case "up" -> crate.setyPos(crate.getyPos() - gamePanel.tileSize);
            case "down" -> crate.setyPos(crate.getyPos() + gamePanel.tileSize);
            case "left" -> crate.setxPos(crate.getxPos() - gamePanel.tileSize);
            case "right" -> crate.setxPos(crate.getxPos() + gamePanel.tileSize);
        }
    }

    // resets the position of the crates
    public void setRestart(){
        getCrates().clear();
        setObjects();
        checkStart();
    }
}
