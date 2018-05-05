package src.source.model;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Farmer extends GameObject
{

    private final String name = "Farmer";

    private int farmerHealth;

    private int farmerMoney;

    public Farmer()
    {
        farmerHealth = 100;

        farmerMoney = 100;
    }
    public String getName()
    {
        return name;
    }

    public ImageIcon getImage()
    {
        return null;
    }

    public void increaseMoney(int x)
    {
        farmerMoney += x;
    }

    public void decreaseMoney( int x)
    {
        farmerMoney -= x;
    }

    public void consumeFood(Food food)
    {
        farmerHealth += food.getHealthPoints();
    }

    public void decreaseHealth( int x)
    {
        farmerHealth -= x;
    }

    public void setFarmerMoney( int x )
    {
        farmerMoney = x;
    }


    public int getFarmerMoney()
    {
        return farmerMoney;
    }

    public int getFarmerHealth()
    {
        return farmerHealth;
    }

}
