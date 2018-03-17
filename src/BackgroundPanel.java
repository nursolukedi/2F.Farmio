package src;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel
{

    private Image img2 = Toolkit.getDefaultToolkit().getImage("src/758e05cf2b472e1ba65c68b9c350a1ed.jpg");

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        // img2 = loadBackground("/home/demode29/IdeaProjects/2F.Farmio/src/758e05cf2b472e1ba65c68b9c350a1ed.jpg");

        g.drawImage(img2,0,0,640,480,this );
//
    }
}
