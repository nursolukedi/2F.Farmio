package src.source.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class PlayerPanel extends JPanel
{
    ImageIcon imgBackground;




    public PlayerPanel()
    {
        imgBackground = new ImageIcon("src/images/terrain_atlas.png");
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(imgBackground.getImage(), 0, 0, 100, 100, null);
    }



}
