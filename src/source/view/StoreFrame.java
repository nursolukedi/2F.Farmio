package src.source.view;

import src.source.model.Map;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class StoreFrame extends JFrame
{
    private StorePanel storePanel;

    public StoreFrame(Map map)
    {
        storePanel= new StorePanel(map,map.getInventory());

        add(storePanel.getContent());

        setSize(800, 800);
        setLocation(600, 200);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
}