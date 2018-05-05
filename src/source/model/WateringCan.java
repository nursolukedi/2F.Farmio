package src.source.model;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class WateringCan extends Item
{
    private final int price = 10;

    private ImageIcon icon;

    private final String name = "WateringCan";

    public WateringCan()
    {
        super(0,0);
        icon = new ImageIcon("src/images/watering_can.png");
    }

    public void water ( Seed seedToWater )
    {
        seedToWater.water();
    }

    public String getName()
    {
        return name;
    }

    public ImageIcon getImage()
    {
        return icon;
    }

    public int getStoreSellingPrice()
    {
        return price;
    }

}
