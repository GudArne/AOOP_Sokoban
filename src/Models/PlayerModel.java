package Models;

import Entities.Crate;
import Entities.Player;
import Main.GamePanel;

public class PlayerModel extends DataModel{

    private GamePanel gamePanel;
    private TileModel tileModel;
    private CrateModel crateModel;
    private Player player;

    // Constructs a player model object
    public PlayerModel(GamePanel gamePanel, TileModel tileModel, CrateModel crateModel) {
        this.gamePanel = gamePanel;
        this.tileModel = tileModel;
        this.crateModel = crateModel;

        player = new Player(gamePanel.tileSize, 2 * gamePanel.tileSize);
    }

    // Updates the player position and validates if its a correct move.
    // Also updates the crates and validates if its a correct move.
    public void update(String direction) {
        if(!crateModel.checkIfWon()) {
            if (checkCollision(direction)) {
                Crate crate = null;
                if(direction == "up" || direction == "down"){
                    crate = crateModel.getCrate(getX(), checkNext(direction));
                }
                else{
                    crate = crateModel.getCrate(checkNext(direction), getY());
                }

                if (crate == null) {
                    updatePlayer(direction); 
                    firePropertyChange("stepCountIncreased");
                    firePropertyChange("gameUpdated");
                } else if (crateModel.checkCrateCollision(direction, crate.getxPos(), crate.getyPos())) {
                    crateModel.moveCrate(crate, direction);
                    crateModel.swapMarked(crate);
                    updatePlayer(direction); 
                    firePropertyChange("stepCountIncreased");
                    firePropertyChange("gameUpdated");
                }
            }
            
        }
        if (direction == "esc") { // Restarts the game if the user presses esc
            setRestart();
            crateModel.setRestart();
            firePropertyChange("gameUpdated");
        }
        else{
            firePropertyChange("gameWon");
        }

    }
    // Checks if there will be a collision with the player. 
    private boolean checkCollision(String direction){
        int posX = player.getPlayerX();
        int posY = player.getPlayerY();
        switch (direction){
            case "up" ->{
                if(!tileModel.getTiles().get(tileModel.getTile(posX, posY - gamePanel.tileSize)).getCollision())
                    return true;
            }
            case "down" ->{
                if(!tileModel.getTiles().get(tileModel.getTile(posX, posY + gamePanel.tileSize)).getCollision())
                    return true;
            }
            case "left" ->{
                if(!tileModel.getTiles().get(tileModel.getTile(posX - gamePanel.tileSize, posY)).getCollision())
                    return true;
            }
            case "right" ->{
                if(!tileModel.getTiles().get(tileModel.getTile(posX + gamePanel.tileSize, posY)).getCollision())
                    return true;
            }
        }
        return false;
    }

    // Returns the next position of the player
    private int checkNext(String direction){
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
            firePropertyChange("resetGame");
        }
        else{
            firePropertyChange("increaseAttempts");
        }
 
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
}
