package src.source.view;

import javafx.scene.chart.Axis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//this is the main menu when game starts
public class Menu extends JPanel
{

    private Image img = Toolkit.getDefaultToolkit().getImage("src/images/mainmenubackground.png");

    private GamePanel gameView;

    private SavedFilesFrame savedFilesFrame;

    public Menu( JPanel contentPanel, CardLayout cards, GamePanel gameView )
    {
        this.gameView = gameView;

        gameView.setCards(contentPanel,cards);

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        add(Box.createVerticalStrut(190));

        JButton startGameButton = new JButton("START A NEW GAME");

        //action listener for start a new game action. It tells GameView to start the game.
        startGameButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
               cards.show(contentPanel,"gameView");

               gameView.startManagerGameLoop(false);
            }
        } );

        //action listener for loading saved map.It shows a frame that has saved files in it.
       JButton loadGameButton = new JButton("LOAD GAME");
       loadGameButton.addActionListener(new ActionListener()
       {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               gameView.openSavedFilesFrame();
           }

       });

       //how to play button
       JButton howToPlayButton = new JButton("How To Play");
       howToPlayButton.addActionListener(new ActionListener()
       {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               cards.show(contentPanel,"howToPlay");
           }
       });


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
       creditsButton.setAlignmentX(CENTER_ALIGNMENT);
       howToPlayButton.setAlignmentX(CENTER_ALIGNMENT);


       add(startGameButton);
       add(loadGameButton);
       add(howToPlayButton);
       add(creditsButton);

    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(img,0,0,1000,1000,this );

    }

}
