package src.source.model;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Store extends GameObject
{
     private final String name = "Store";

     private ImageIcon image;

     private ArrayList<Item> store;

     public Store()
     {
         store = new ArrayList<Item>();
         image = new ImageIcon("src/images/tiles.png");
     }

     public void addToStore(Item item)
     {
         store.add(item);
     }

     public String getName()
     {
         return name;
     }

    @Override
    public ImageIcon getImage() {
        return image;
    }
}
