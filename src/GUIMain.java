package src;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUIMain extends JFrame
{

     private CardLayout cards;
     private JPanel contentPane;

     private Menu menu;
     private Credits credits;


     public GUIMain()
     {

         setTitle("Farmio");

         setSize(640,480);

         setResizable(false);

         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         contentPane = new JPanel();
         cards = new CardLayout(0, 0);
         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
         contentPane.setLayout(cards);


         menu = new Menu(contentPane,cards);

         credits = new Credits(contentPane,cards);


         contentPane.add(menu, "main");

         contentPane.add(credits, "credits");


         cards.show(contentPane, "main");

         setVisible(true);

         setContentPane(contentPane);

     }


     public static void main(String[] args)
     {

         new GUIMain();
     }

}
