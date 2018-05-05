package src.source.controller;

import src.source.model.SavedFile;
import src.source.view.GamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class GameManager
{

    private final static int ONE_SECOND = 250;

    //singleton pattern
    private static GameManager gameManagerInstance = null;

    private boolean gameRunning;

    private GamePanel gameView;

    private MapManager mapManager;

    private Timer timer;

    private FileManager fileManager;

    public GameManager(GamePanel gameView)
    {
        this.gameView = gameView;

        fileManager = new FileManager();

        mapManager = MapManager.getMapManagerInstance(gameView,fileManager);

        gameRunning = false;
    }

    //starts game loop. isLoaded boolean variable is for checking loaded game or new game
    public void startGameLoop( boolean isLoaded )
    {
        if(!isLoaded)
        {
            createNewMap();
        }

        gameLoop();
        gameRunning = true;
        mapManager.setGameRunning();

        //sets map manager for map panel
        gameView.getMapPanel().setMapManager(mapManager);

    }

    //singleton design pattern
    public static GameManager getGameManagerInstance(GamePanel gameView)
    {
        if ( gameManagerInstance == null)
        {
            gameManagerInstance = new GameManager(gameView);
            return gameManagerInstance;
        }else
            {
            return gameManagerInstance;

        }
    }

    //sets map according to file index
    public void setMap( int index )
    {
        mapManager.setMap(index);
    }

    //tells file manager to return saved files
    public ArrayList<SavedFile> saveGameDataToFile()
    {
        return fileManager.saveGameDataToFile(mapManager.getMap());
    }

    //tells map manager to create new map
    private void createNewMap()
    {
        mapManager.createNewMap();
    }

    //tells map manager to exit
    public void exit()
    {
        mapManager.exit();
    }

    //main game loop for updating the game and repainting game
    private void gameLoop()
    {

        timer = new Timer(ONE_SECOND, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if( gameRunning )
                {
                    updateGame();

                    gameView.repaint();
                }
            }
        });
        timer.start();

    }


    //updates map manager and checks the state of the game
    private void updateGame()
    {
      if(mapManager.getGameStatus() == GameStatus.GAME_OVER)
      {
         timer.stop();
         gameRunning = false;
         int result = JOptionPane.showConfirmDialog(gameView,
                  "Game is over");
         if (result  == JOptionPane.YES_OPTION)
         {
              gameView.returnMenu();
         }
      }
      else if(mapManager.getGameStatus() == GameStatus.RETURN_MENU)
      {
         timer.stop();

         gameRunning = false;

         gameView.returnMenu();

         System.out.println("Exit selected");
      }
      else
      {
          mapManager.updateMap();
      }

    }


    public MapManager getMapManager()
    {
        if(mapManager != null)
        {
            return mapManager;
        }

        return null;
    }

}
