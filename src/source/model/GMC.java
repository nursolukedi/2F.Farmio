package src.source.model;

import javax.swing.*;

public class GMC extends PowerUp
{
    private int sellingPrice;
    private ImageIcon image;

    public GMC()
    {
        super();

        image = new ImageIcon("src/images/GMC.png");

        sellingPrice = 100;
    }

    @Override
    public void applyPowerUp(Seed a)
    {
        a.setGMCStatus(true);
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
        return "GMC";
    }

    @Override
    public ImageIcon getImage()
    {
        // TODO Auto-generated method stub
        return image;
    }

}
