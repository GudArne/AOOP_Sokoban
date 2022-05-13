package Entities;

import java.awt.image.BufferedImage;

public class Tile {
    public BufferedImage tileImage;
    public boolean collision;
    public boolean marked;
    public String name;

    public Tile(String name, Boolean collision, Boolean marked)
    {
        this.name = name;
        this.collision = collision;
        this.marked = marked;
    }
}
