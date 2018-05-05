package src.source.view;

import src.source.controller.MapManager;
import src.source.model.*;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InventoryFrame extends JFrame
{

    private InventoryPanel inventoryPanel;

    public InventoryFrame(MapManager mapManager)
    {
        inventoryPanel = new InventoryPanel(mapManager);


        add(inventoryPanel);


        setSize(400, 400);
        setLocation(600, 200);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    public InventoryPanel getInventoryPanel(){
        return inventoryPanel;
    }

    public void setInventoryItems( Map map )
    {
        Inventory inventory = map.getInventory();

        for(int i = 0; i < inventory.getInventoryItems().size(); i++)
        {
            inventoryPanel.addToInvPanel(inventory.getInventoryItems().get(i));
        }

    }

}
