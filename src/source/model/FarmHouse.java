package src.source.model;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FarmHouse extends GameObject
{
   String name;

   private ImageIcon icon;

   private static int width = 100;
   private static int height = 100;

   public FarmHouse()
   {
       super(400,400);
       icon = new ImageIcon("src/images/pokemon_tiles.png");
       name = "FarmHouse";
   }

   public FarmHouse(int x,int y)
   {
       super(x,y);
       name = "FarmHouse";
   }

   public String getName()
   {
      return name;
   }

   public ImageIcon getImage()
   {
       return icon;
   }



   public int getWidth(){
       return width;

   }

    public int getHeight(){
        return height;

    }
}
