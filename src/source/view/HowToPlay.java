package src.source.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HowToPlay extends JPanel
{
    private ImageIcon background;

    public HowToPlay(JPanel contentPanel, CardLayout cards)
    {
        background = new ImageIcon("src/images/MAINHOWTOPLAY.png");

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
