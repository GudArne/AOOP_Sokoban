package Models;

import Entities.Crate;
import Entities.Player;
import Main.GamePanel;

import java.awt.image.BufferedImage;
import java.util.Objects;

import Views.StatsView;
public class PlayerModel {
    private int stepCount = 0;
    private int attempts = 0;

    private GamePanel gamePanel;
    private DataModel dataModel;
    private TileModel tileModel;
    private CrateModel crateModel;
    //private BufferedImage playerImage;
    private StatsView statsView;
    private Player player;

    // Constructs a player model object
    public PlayerModel(GamePanel gamePanel, DataModel dataModel, TileModel tileModel, CrateModel crateModel, StatsView statsView) {
        this.gamePanel = gamePanel;
        this.dataModel = dataModel;
        this.tileModel = tileModel;
        this.crateModel = crateModel;
        this.statsView = statsView;

        player = new Player(gamePanel.tileSize, 2 * gamePanel.tileSize);
    }

    // Updates the player position and validates if its a correct move.
    // Also updates the step count and attempts.
    // Also updates the crates and validates if its a correct move.
    public void update(){
        String direction = dataModel.getData();
        if(!crateModel.checkIfWon()) {
            if (Objects.equals(direction, "up") && checkCollision(direction)) {
                Crate crate = crateModel.getCrate(getX(), checkNext(direction));
                if (crate == null) {
                    updatePlayer(direction); //move player
                    setStepCount(getStepCount() + 1);
                    statsView.setStepCounterLabel(getStepCount());
                } else if (crateModel.checkCrateCollision(direction, crate.getxPos(), crate.getyPos())) {
                    crateModel.moveCrate(crate, direction);
                    crateModel.swapMarked(crate);
                    updatePlayer(direction);
                    setStepCount(getStepCount() + 1);
                    statsView.setStepCounterLabel(getStepCount());
                }
            } else if (Objects.equals(direction, "down") && checkCollision(direction)) {
                Crate crate = crateModel.getCrate(getX(), checkNext(direction));
                if (crate == null) {
                    updatePlayer(direction); //move player
                    setStepCount(getStepCount() + 1);
                    statsView.setStepCounterLabel(getStepCount());
                } else if (crateModel.checkCrateCollision(direction, crate.getxPos(), crate.getyPos())) {
                    crateModel.moveCrate(crate, direction);
                    crateModel.swapMarked(crate);
                    updatePlayer(direction);
                    setStepCount(getStepCount() + 1);
                    statsView.setStepCounterLabel(getStepCount());
                }
            } else if (Objects.equals(direction, "left") && checkCollision(direction)) {
                Crate crate = crateModel.getCrate(checkNext(direction), getY());
                if (crate == null) {
                    updatePlayer(direction); //move player
                    setStepCount(getStepCount() + 1);
                    statsView.setStepCounterLabel(getStepCount());
                } else if (crateModel.checkCrateCollision(direction, crate.getxPos(), crate.getyPos())) {
                    crateModel.moveCrate(crate, direction);
                    crateModel.swapMarked(crate);
                    updatePlayer(direction);
                    setStepCount(getStepCount() + 1);
                    statsView.setStepCounterLabel(getStepCount());
                }
            } else if (Objects.equals(direction, "right") && checkCollision(direction)) {
                Crate crate = crateModel.getCrate(checkNext(direction), getY());
                if (crate == null) {
                    updatePlayer(direction); //move player
                    setStepCount(getStepCount() + 1);
                    statsView.setStepCounterLabel(getStepCount());
                } else if (crateModel.checkCrateCollision(direction, crate.getxPos(), crate.getyPos())) {
                    crateModel.moveCrate(crate, direction);
                    crateModel.swapMarked(crate);
                    updatePlayer(direction);
                    setStepCount(getStepCount() + 1);
                    statsView.setStepCounterLabel(getStepCount());
                }
            }
        }
        if (Objects.equals(direction, "esc")) { // Restarts the game if the user presses esc
            setRestart();
            crateModel.setRestart();
        }
    }
    // Checks if there will be a collision with the player. 
    private boolean checkCollision(String direction){
        switch (direction){
            case "up" ->{
                if(!tileModel.getTiles().get(tileModel.getTile(player.getPlayerX(), player.getPlayerY() - gamePanel.tileSize)).getCollision())
                    return true;
            }
            case "down" ->{
                if(!tileModel.getTiles().get(tileModel.getTile(player.getPlayerX(), player.getPlayerY() + gamePanel.tileSize)).getCollision())
                    return true;
            }
            case "left" ->{
                if(!tileModel.getTiles().get(tileModel.getTile(player.getPlayerX() - gamePanel.tileSize, player.getPlayerY())).getCollision())
                    return true;
            }
            case "right" ->{
                if(!tileModel.getTiles().get(tileModel.getTile(player.getPlayerX() + gamePanel.tileSize, player.getPlayerY())).getCollision())
                    return true;
            }
        }
        return false;
    }

    // Returns the next position of the player
    public int checkNext(String direction){
        int retInt = 0;
        switch (direction){
            case "up" -> retInt = player.getPlayerY() - gamePanel.tileSize;
            case "down" ->retInt = player.getPlayerY() + gamePanel.tileSize;
            case "left" -> retInt = player.getPlayerX() - gamePanel.tileSize;
            case "right" -> retInt = player.getPlayerX() + gamePanel.tileSize;
        }
        return retInt;
    }

    // Resets game statistics and positions of crates and player
    private void setRestart(){
        if(crateModel.checkIfWon()){
            setAttempts(0);
        }
        else
            setAttempts(getAttempts() + 1);

        statsView.setAttemptsLabel("Attempts:", getAttempts());
        setStepCount(0);
        statsView.setMarkedCrates(1);
        statsView.setStepCounterLabel(getStepCount());
        player.setPlayerX(gamePanel.tileSize);
        player.setPlayerY(2 * gamePanel.tileSize);

    }

    // Updates the player position
    private void updatePlayer(String direction){
        switch (direction){
            case "up" -> player.setPlayerY(getY() - gamePanel.tileSize);
            case "down" -> player.setPlayerY(getY() + gamePanel.tileSize);
            case "left" -> player.setPlayerX(getX() - gamePanel.tileSize);
            case "right" -> player.setPlayerX(getX() + gamePanel.tileSize);
        }
    }

    // get player X position
    public int getX(){
        return player.getPlayerX();
    }

    // get player Y position
    public int getY(){
        return player.getPlayerY();
    }

    // get player step count
    public int getStepCount(){
        return stepCount;
    }

    // set player step count
    public void setStepCount(int stepCount){
        this.stepCount = stepCount;
    }

    // get player attempts
    public int getAttempts(){
        return attempts;
    }

    // set player attempts
    public void setAttempts(int attempts){
        this.attempts = attempts;
    }
}
