package Entities;

import java.awt.image.BufferedImage;

public class Tile {
    private BufferedImage tileImage;
    private boolean collision;
    private boolean marked;
    private String name;

    public Tile(String name, Boolean collision, Boolean marked){
        this.name = name;
        this.collision = collision;
        this.marked = marked;
    }

    // getters and setters
    public BufferedImage getTileImage(){
        return tileImage;
    }
    public void setTileImage(BufferedImage tileImage){
        this.tileImage = tileImage;
    }
    public boolean getCollision(){
        return collision;
    }
    public void setCollision(boolean collision){
        this.collision = collision;
    }
    public boolean getMarked(){
        return marked;
    }
    public void setMarked(boolean marked){
        this.marked = marked;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
