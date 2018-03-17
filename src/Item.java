package src;

import javax.swing.*;
import java.awt.*;

public class Item
{

    private String name;

    private int ID;

    private ImageIcon icon;


    public Item(String name,int ID, ImageIcon icon)
    {
        this.name = name;
        this.ID = ID;
        this.icon = icon;
    }

    private String getName()
    {
        return name;
    }

    private int getID()
    {
        return ID;
    }

    private ImageIcon getIcon()
    {
        return icon;
    }


}
