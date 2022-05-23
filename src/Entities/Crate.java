package Entities;

public class Crate {
    private int xPos;
    private int yPos;
    private boolean marked = false;

    public Crate(int xPos, int yPos,  boolean marked){
        this.xPos = xPos;
        this.yPos = yPos;
        this.marked = marked;
    }

    // Getters and setters.
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public boolean isMarked(){
        return this.marked;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }
}
