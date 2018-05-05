package src.source.view;

import src.source.controller.GameManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


//GamePanel is façade class for view objects
public class GamePanel extends JPanel
{

    private DrawPanel mapPanel;

    private PlayerInfoPanel playerInfoPanel;

    private CardLayout cards;

    private InventoryAction inventoryAction;

    private JPanel contentPanel;

    private SideMenu sideMenu;

    private SavedFilesFrame savedFilesFrame;

    private SideMenuAction sideMenuAction;

    private StoreAction storeAction;

    private boolean firstLoadGame;

    private boolean isInvokedFromSideMenu;

    private GameManager gameManager;

    private InventoryFrame inventoryFrame;

    private StoreFrame storeFrame;


    public GamePanel( )
    {
        firstLoadGame = true;
        isInvokedFromSideMenu = false;

        setLayout(new BorderLayout());


        //gameManager singleton object and pass game view for gui updates
        gameManager = GameManager.getGameManagerInstance(this);


        //create a side menu
        sideMenu = new SideMenu(gameManager,this);


        //map panel and add map panel to game panel
        mapPanel = new DrawPanel(this);
        mapPanel.setPreferredSize( new Dimension(1000,935));
        add(mapPanel, BorderLayout.NORTH);


        playerInfoPanel = new PlayerInfoPanel();


        //key binding for ESC action
        sideMenuAction = new SideMenuAction();
        getInputMap().put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0),"doESCAction" );
        getActionMap().put("doESCAction",sideMenuAction);


        //key binding for I action
        inventoryAction = new InventoryAction();
        getInputMap().put( KeyStroke.getKeyStroke( KeyEvent.VK_I, 0),"doINVAction" );
        getActionMap().put("doINVAction",inventoryAction);


        //key binding for S action
        storeAction = new StoreAction();
        getInputMap().put( KeyStroke.getKeyStroke( KeyEvent.VK_S, 0),"doStoreAction" );
        getActionMap().put("doStoreAction",storeAction);


        requestFocusInWindow();

    }

    public GamePanel getGamePanel()
    {
        return this;
    }

    public PlayerInfoPanel getPlayerInfoPanel()
    {
        return playerInfoPanel;

    }

    public void setFirstLoadGame()
    {
        firstLoadGame = false;
    }


    //opens a frame that shows saved files
    public void openSavedFilesFrame()
    {
        //create a new load frame
        savedFilesFrame = new SavedFilesFrame(this);
        //if user saved some games and wants to see them on this frame
        if( !firstLoadGame )
        {
            savedFilesFrame.updatePanel(sideMenu.getSaved_files());
        }
    }

    //sets map according to selected saved file in load game section and then starts the loaded game
    public void setMap()
    {
        gameManager.setMap( savedFilesFrame.getCurrent_index() );
    }
    //sets card layout for returning and showing main menu. This function is invoked from GUIMaın
    public void setCards(JPanel contentPanel,CardLayout cards)
    {
        this.contentPanel = contentPanel;
        this.cards = cards;
    }

    // shows game view
    public void returnGame()
    {
        cards.show(contentPanel,"gameView");
    }

    //shows main menu
    public void returnMenu()
    {
        cards.show(contentPanel,"main");
    }

    //this tells game manager to start game loop
    public void startManagerGameLoop( boolean isLoaded )
    {
        gameManager.startGameLoop(isLoaded);
        playerInfoPanel.setMap(gameManager.getMapManager().getMap());
        add(playerInfoPanel,BorderLayout.SOUTH);
    }

    public DrawPanel getMapPanel()
    {
        return mapPanel;
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }


    //inner class for escape input action. Opens a side menu
    private class SideMenuAction extends AbstractAction
    {
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(null,sideMenu,"SideMenu",JOptionPane.PLAIN_MESSAGE);
            sideMenu.requestFocusInWindow();
        }
    }


    //inner class for I key actions. Opens Inventory
    private class InventoryAction extends AbstractAction
    {
        public void actionPerformed(ActionEvent e)
        {
            inventoryFrame=new InventoryFrame(gameManager.getMapManager());
            inventoryFrame.setInventoryItems(gameManager.getMapManager().getMap());
        }
    }

    //inner class for S action. Opens store
    private class StoreAction extends AbstractAction
    {
        public void actionPerformed(ActionEvent e)
        {
            storeFrame = new StoreFrame(gameManager.getMapManager().getMap());
        }

    }

    //update player info panel
    public void updatePlayerPanel()
    {
        playerInfoPanel.updateLabel();
    }
}
