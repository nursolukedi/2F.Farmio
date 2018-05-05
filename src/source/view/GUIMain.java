package src.source.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUIMain extends JFrame
{

     private CardLayout cards;

     private JPanel contentPane;

     private Menu menu;
     private Credits credits;
     private GamePanel gameView;

     private HowToPlay howToPlay;

     private static int MENU_SIZE_WIDTH = 1000;
     private static int MENU_SIZE_HEIGHT = 1000;


     private GUIMain()
     {

         setTitle("Farmio");

         setSize(MENU_SIZE_WIDTH,MENU_SIZE_WIDTH);

         setResizable(false);

         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         contentPane = new JPanel();
         cards = new CardLayout(0, 0);
         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
         contentPane.setLayout(cards);


         gameView = new GamePanel();

         menu = new Menu(contentPane,cards,gameView);

         credits = new Credits(contentPane,cards);

         howToPlay = new HowToPlay(contentPane,cards);


         contentPane.add(menu, "main");

         contentPane.add(credits, "credits");

         contentPane.add(gameView, "gameView");

         contentPane.add(howToPlay,"howToPlay");


         cards.show(contentPane, "main");

         setVisible(true);

         setContentPane(contentPane);

     }


     public static void main(String[] args)
     {

         new GUIMain();
     }

}
