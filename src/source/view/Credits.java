package src.source.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Credits extends JPanel
{
    private ImageIcon background;
    public Credits(JPanel contentPanel, CardLayout cards)
    {
        background = new ImageIcon("src/images/credits.png");
        JButton returnButton = new JButton("Return To Menu");
        returnButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                cards.show(contentPanel,"main");
            }
        } );
        add(returnButton);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(background.getImage(),0,0,null);
    }


}
