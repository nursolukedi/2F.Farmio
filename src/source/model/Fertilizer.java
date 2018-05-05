package src.source.model;

import javax.swing.*;

public class Fertilizer extends PowerUp
{
    private int sellingPrice;
    private ImageIcon image;

    public Fertilizer()
    {
        super();
        image = new ImageIcon("src/images/fertilizer.png");
        sellingPrice=85;
    }

    @Override
    public void applyPowerUp(Seed a)
    {
        a.setFertilizedStatus(true);
    }

    @Override
    public int getStoreSellingPrice()
    {
        return sellingPrice;
    }

    @Override
    public String getName()
    {
        // TODO Auto-generated method stub
        return "Fertilizer";
    }

    @Override
    public ImageIcon getImage()
    {
        // TODO Auto-generated method stub
        return image;
    }
}
