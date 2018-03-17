package src;

import javafx.scene.chart.Axis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JPanel
{

    private Image img = Toolkit.getDefaultToolkit().getImage("/home/demode29/IdeaProjects/2F.Farmio/src/mainmenubackground.png");

    public Menu( JPanel contentPanel, CardLayout cards )
    {
       setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

       add(Box.createVerticalStrut(190));

       JButton startGameButton = new JButton("START GAME");

       startGameButton.addActionListener(new ActionListener()
       {
            public void actionPerformed(ActionEvent e)
            {
               cards.show(contentPanel,"gameView");
            }
       } );


       JButton loadGameButton = new JButton("LOAD GAME");
       JButton saveGameButton = new JButton("SAVE GAME");

       JButton creditsButton = new JButton("CREDITS");

       creditsButton.addActionListener(new ActionListener()
       {
            public void actionPerformed(ActionEvent e)
            {
                cards.show(contentPanel,"credits");
            }
       } );

       startGameButton.setAlignmentX(CENTER_ALIGNMENT);
       loadGameButton.setAlignmentX(CENTER_ALIGNMENT);
       saveGameButton.setAlignmentX(CENTER_ALIGNMENT);
       creditsButton.setAlignmentX(CENTER_ALIGNMENT);


       add(startGameButton);
       add(loadGameButton);
       add(saveGameButton);
       add(creditsButton);

    }


    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(img,0,0,640,480,this );

    }

}
