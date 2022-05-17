package Testing;

import Entities.Crate;
import Main.GamePanel;
import Main.GameWindow;
import Models.CrateModel;
import Models.DataModel;
import Models.PlayerModel;

import org.junit.*;
import static org.junit.Assert.*;
import javax.swing.JFrame;

public class Tester {

    GamePanel gamePanel;
    DataModel dataModel = new DataModel("");
    PlayerModel playerModel;
    CrateModel crateModel;

    public Tester() {
        this.gamePanel = new GamePanel();
        this.dataModel = gamePanel.getDataModel();
        this.playerModel = gamePanel.getPlayerModel();
        this.crateModel = gamePanel.getCrateModel();
        
        GameWindow gameWindow = new GameWindow(new JFrame(), gamePanel);
    }
    
    // try to walk through a wall
    @Test public void wallTest(){
        // Player should not be able to move through a wall
        dataModel.update("up");
        assertEquals(48, playerModel.getX());
        assertEquals(48*2, playerModel.getY());
        dataModel.update("down");
        assertEquals(48, playerModel.getX());
        assertEquals(48*2, playerModel.getY());
        dataModel.update("left");
        assertEquals(48, playerModel.getX());
        assertEquals(48*2, playerModel.getY());
    }

    // Test if player can move to a "legit" position
    @Test public void MovePlayer(){
        // Player should be able to move right
        dataModel.update("right");
        assertEquals(48*2, playerModel.getX());
        assertEquals(48*2, playerModel.getY());
    }

    // Test if player can move a crate
    @Test public void MoveCrate(){
        // get closest crate
        Crate crate = crateModel.getCrate(48*3, 48*2);
        // Player should be able to move right and move the crate
        dataModel.update("right");
        dataModel.update("right");
        // verify test
        assertEquals(48*3, playerModel.getX());
        assertEquals(48*2, playerModel.getY());
        // crate should be moved one tile to the right
        assertEquals(crate.xPos, 48*4); 
    }


    // Move a crate to a wall
    @Test public void MoveCrateToWall(){
        // get closest crate
        Crate crate = crateModel.getCrate(48*3, 48*2);

        // Player should be able to move right and move the crate
        dataModel.update("right");
        dataModel.update("right");
        dataModel.update("right");
        assertEquals(48*4, playerModel.getX());
        assertEquals(48*2, playerModel.getY());
        // crate should be moved one tile to the right
        assertEquals(crate.xPos, 48*5);

        // Try to move crate through the wall. Should not be able to move
        dataModel.update("right");
        assertEquals(48*4, playerModel.getX());
        assertEquals(crate.xPos, 48*5);
    }

    // Move a crate to a crate
    @Test public void MoveCrateToCrate(){
        // get closest crates
        Crate crate1 = crateModel.getCrate(48*3, 48*2);
        Crate crate2 = crateModel.getCrate(48*4, 48*3);

        // Set up the player position
        dataModel.update("right");
        dataModel.update("right");
        dataModel.update("up");
        dataModel.update("right");

        // Try to move crate crate1 to crate2. Should not work.
        dataModel.update("down");
        assertEquals(crate1.xPos, 48*4);
        assertEquals(crate1.yPos, 48*2);
        assertEquals(crate2.xPos, 48*4);
        assertEquals(crate2.yPos, 48*3);
    }
}
