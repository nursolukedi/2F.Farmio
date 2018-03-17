package src;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel
{

    private DrawPanel mapPanel;

    private InventoryPanel inventoryPanel;


    public GamePanel()
    {

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        mapPanel = new DrawPanel();

        inventoryPanel = new InventoryPanel();

        inventoryPanel.setPreferredSize( new Dimension(640,-180));

        add(mapPanel);

        add(inventoryPanel);

    }




}
