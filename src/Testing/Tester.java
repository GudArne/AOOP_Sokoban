package Testing;

import Entities.Crate;
import Main.GamePanel;
import Main.GameWindow;
import Models.CrateModel;
import Models.PlayerModel;
import Controller.Handler;
import Controller.KeyHandler;

import org.junit.*;
import static org.junit.Assert.*;

import javax.swing.JFrame;

public class Tester {

    private GamePanel gamePanel;
    private PlayerModel playerModel;
    private CrateModel crateModel;
    private Handler keyHandler;

    public Tester() {
        this.gamePanel = new GamePanel();
        this.playerModel = gamePanel.getPlayerModel();
        this.crateModel = gamePanel.getCrateModel();
        this.keyHandler = new KeyHandler(playerModel);
        gamePanel.setController(keyHandler);
        
        new GameWindow(new JFrame(), gamePanel);
    }
    
    // try to walk through a wall
    @Test public void wallTest(){
        // Player should not be able to move through a wall
        playerModel.update("up");
        assertEquals(48, playerModel.getX());
        assertEquals(48*2, playerModel.getY());
        playerModel.update("down");
        assertEquals(48, playerModel.getX());
        assertEquals(48*2, playerModel.getY());
        playerModel.update("left");
        assertEquals(48, playerModel.getX());
        assertEquals(48*2, playerModel.getY());
    }

    // Test if player can move to a "legit" position
    @Test public void MovePlayer(){
        // Player should be able to move right
        playerModel.update("right");
        assertEquals(48*2, playerModel.getX());
        assertEquals(48*2, playerModel.getY());
    }

    // Test if player can move a crate
    @Test public void MoveCrate(){
        // get closest crate
        Crate crate = crateModel.getCrate(48*3, 48*2);
        // Player should be able to move right and move the crate
        playerModel.update("right");
        playerModel.update("right");
        // verify test
        assertEquals(48*3, playerModel.getX());
        assertEquals(48*2, playerModel.getY());
        // crate should be moved one tile to the right
        assertEquals(crate.getxPos(), 48*4); 
    }


    // Move a crate to a wall
    @Test public void MoveCrateToWall(){
        // get closest crate
        Crate crate = crateModel.getCrate(48*3, 48*2);

        // Player should be able to move right and move the crate
        playerModel.update("right");
        playerModel.update("right");
        playerModel.update("right");
        assertEquals(48*4, playerModel.getX());
        assertEquals(48*2, playerModel.getY());
        // crate should be moved one tile to the right
        assertEquals(crate.getxPos(), 48*5);

        // Try to move crate through the wall. Should not be able to move
        playerModel.update("right");
        assertEquals(48*4, playerModel.getX());
        assertEquals(crate.getxPos(), 48*5);
    }

    // Move a crate to a crate
    @Test public void MoveCrateToCrate(){
        // get closest crates
        Crate crate1 = crateModel.getCrate(48*3, 48*2);
        Crate crate2 = crateModel.getCrate(48*4, 48*3);

        // Set up the player position
        playerModel.update("right");
        playerModel.update("right");
        playerModel.update("up");
        playerModel.update("right");

        // Try to move crate crate1 to crate2. Should not work.
        playerModel.update("down");
        assertEquals(crate1.getxPos(), 48*4);
        assertEquals(crate1.getyPos(), 48*2);
        assertEquals(crate2.getxPos(), 48*4);
        assertEquals(crate2.getyPos(), 48*3);
    }
}
