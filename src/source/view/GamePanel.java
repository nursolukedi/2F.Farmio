package src;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel
{
    private DrawPanel mapPanel;

    private InventoryPanel inventoryPanel;


    private Image img = Toolkit.getDefaultToolkit().getImage("/home/demode29/IdeaProjects/2F.Farmio/src/758e05cf2b472e1ba65c68b9c350a1ed.jpg");

    public GamePanel()
    {

        mapPanel = new DrawPanel();

        inventoryPanel = new InventoryPanel();



        add(mapPanel);

        add(inventoryPanel);

    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(img,0,0,640,480,this );

    }

}
