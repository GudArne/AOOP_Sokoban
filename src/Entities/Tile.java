package Entities;

import java.awt.image.BufferedImage;

public class Tile {
    public BufferedImage tileImage;
    public boolean collision = false;
    public boolean marked = false;
    
    public Tile(BufferedImage tileImage, Boolean collision, Boolean marked)
    {
        this.tileImage = tileImage;
        this.collision = collision;
        this.marked = marked;
    }
}
