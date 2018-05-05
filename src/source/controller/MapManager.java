package src.source.controller;


import src.source.model.*;
import src.source.view.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MapManager
{

    private GameStatus gameStatus;

    private Map map;

    private FileManager fileManager;

    private GamePanel gamePanel;

    private static int OBJECT_SIZE = 100;

    private static MapManager mapManagerInstance = null;


    private MapManager( GamePanel gamePanel, FileManager fileManager )
    {
         gameStatus = GameStatus.GAME_RUNNING;

         this.fileManager = fileManager;

         this.gamePanel = gamePanel;
    }

    //create a new map and tell file manager to read from txt
    public void createNewMap()
    {
        //if map is not null, stop all previous seeds
        if( map != null)
        {
            map.stopAllSeeds();
            map.stopAllTrees();
        }
        try
        {
            map = new Map(fileManager.readMapData());
        }
        catch(FileNotFoundException e)
        {

        }
    }

    //map manager singleton design pattern approach
    public static MapManager getMapManagerInstance(GamePanel gamePanel, FileManager fileManager){
        if ( mapManagerInstance == null)
        {
            mapManagerInstance = new MapManager( gamePanel,fileManager);
            return mapManagerInstance;
        }else
            return mapManagerInstance;
    }

    //this tells map to apply gmc to seed in specific x, y location
    public void invokeGMC(GMC gmc,int x, int y)
    {
        if(map.checkSeedLand(x,y))
        {
            map.applyGMCSeed(gmc,x/OBJECT_SIZE,y/OBJECT_SIZE);
        }
    }

    //this tells map to apply fertilizer to available seed
    public void invokeFertilizer(Fertilizer fertilizer,int x,int y)
    {
        if(map.checkSeedLand(x,y))
        {
            map.applyFertilizeSeed(fertilizer,x/OBJECT_SIZE,y/OBJECT_SIZE);
        }
    }

    //this is stops all seed timers and changes game status to return menu
    public void exit()
    {
        gameStatus = GameStatus.RETURN_MENU;
        map.stopAllSeeds();

        map.stopAllTrees();
    }

    //this is sets game running
    public void setGameRunning()
    {
        gameStatus = GameStatus.GAME_RUNNING;
    }

    //Map manager sets the map according to index in file
    public void setMap(int index)
    {
        map = fileManager.readMapFromData(index);
        map.resumeSeedTimers();
        map.resumeTreeTimers();
    }

    //this is updates map objects and checks whether game is over or not
    public void updateMap()
    {
         map.updateFarmer();
         map.updateFarm();
         //updates player info
         gamePanel.updatePlayerPanel();

         if( map.getGameOver() )
         {
             gameStatus = GameStatus.GAME_OVER;
         }
    }
    //this is updates farmer in map
    public void updateFarmerHealth(Food food)
    {
        map.increaseFarmerHealth(food);
        System.out.println("Farmer health is increased by"+ food.getHealthPoints());
    }

    //this is adds to map
    public void addSeedMap(Seed seed,int x, int y)
    {
        boolean available = checkAvailability(x,y);
        System.out.println(available);
        if(available)
        {
            map.addSeedToLand(seed,x,y);
        }
        else {
            JOptionPane.showMessageDialog(gamePanel,"Not available land");
        }
    }
    //this is applies water to seed in map
    public void applyWater(WateringCan can, int x, int y)
    {
        boolean available = checkSeedLand(x,y);

        if( available )
        {
            map.applyWaterToSeed(can,x/OBJECT_SIZE,y/OBJECT_SIZE);
        }
        else
        {
            JOptionPane.showMessageDialog(gamePanel,"No seed here");
        }
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    //checks whether specific location has seed
    private boolean checkSeedLand(int x, int y)
    {
        return map.checkSeedLand(x,y);
    }

    //returns game object from x y location
    public GameObject getGameObject(int x,int y)
    {
        return map.getGameObject(x,y);
    }


    public GameStatus getGameStatus()
    {
        return gameStatus;
    }

    //tells map to draw itself
    public void drawMap(Graphics g)
    {
        map.drawMap(g);
    }

    public Map getMap()
    {
        return map;
    }

    //this is sets the food that will be harvested
    public void setHarvestedFood(Food harvestedFood)
    {
         map.setHarvestedFood(harvestedFood);
    }

    public void onSelect(Item item)
    {
        map.onSelect(item);
    }

    //adds item to inventory in map
    public void addToInv(Item item)
    {
        map.addToInventory(item);
    }

    //deselects selected item
    public void deSelect()
    {
        map.onDeselect();
    }

    //tells map to delete a specific object in x y location
    public void deleteObject(int x,int y)
    {
        map.deleteFromMap(x/OBJECT_SIZE,y/OBJECT_SIZE);
    }

    public GameObject[][] getGameMapObjects()
    {
        return map.getGameObjects();
    }

    //tells map to check availability of x and y
    private boolean checkAvailability(int x, int y)
    {
        return map.checkAvailability(x,y);
    }


}
