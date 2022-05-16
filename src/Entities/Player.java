package Entities;

public class Player {
    public int playerX,playerY;
    public Player(int playerX, int playerY){
        this.playerX = playerX;
        this.playerY = playerY;
    }

    // return playerX
    public int getPlayerX() {
        return playerX;
    }
    // return playerY
    public int getPlayerY() {
        return playerY;
    }
    // set playerX
    public void setPlayerX(int x) {
        this.playerX = x;
    }
    // set playerY
    public void setPlayerY(int y) {
        this.playerY = y;
    }
}


