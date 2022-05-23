package Models;

import Entities.Tile;
import Main.GamePanel;
import java.io.*;
import java.util.ArrayList;

public class TileModel { // MapModel
    private GamePanel gamePanel;
    private ArrayList<ArrayList<Integer>> numTiles;
    private ArrayList<Tile> tiles;

    // Constructs a tile model
    public TileModel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        numTiles = new ArrayList<>();
        tiles = new ArrayList<>();

        readTile();
        readMap("src/Resources/Map/map1.txt");
    }

    // Adds the tiles to the tiles arraylist
    private void readTile() {
        tiles.add(new Tile("blank", false,false));
        tiles.add(new Tile("blankmarked", false,true));
        tiles.add(new Tile("wall", true,false));

    }
    // returns the game panel
    public GamePanel getGamePanel(){
        return this.gamePanel;
    }
    // returns an arraylist of the tiles
    public ArrayList<Tile> getTiles(){
        return this.tiles;
    }
    // returns an arraylist of the number of the tiles
    public ArrayList<ArrayList<Integer>> getNumTiles(){
        return this.numTiles;
    }

    // Reads the map and convert it to a 2d array
    private void readMap(String map) {

        int index = 0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(map)));
            String line;
            ArrayList<String> converter = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                converter.add(line);
                String[] temp = converter.get(index).split(" ");
                index++;
                ArrayList<Integer> intTiles = new ArrayList<>();
                for (String s : temp) {
                    intTiles.add(Integer.parseInt(s));
                }
                numTiles.add(intTiles);
            }
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Checks if a crate is marked or not
    public boolean checkMarked(int x, int y){
        x = x/ gamePanel.tileSize;
        y = y/ gamePanel.tileSize;
        if(tiles.get(numTiles.get(y).get(x)).getMarked())
            return true;
        else return false;
    }

    // Get the tile at a specific position
    public int getTile(int x, int y)
    {
        x = x/gamePanel.tileSize;
        y = y/gamePanel.tileSize;
        return numTiles.get(y).get(x);
    }
}
