package src.source.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Seed extends Item
{

    private String name = "Seed";

    private ImageIcon icon ;

    private int timeHolder;

    private int status;

    private boolean hasWater;

    private boolean isDeveloped;

    private boolean isPlanted;

    private boolean isSpoiled;

    private boolean isResumedPlant;


    private boolean isFertilized;

    public Timer seedTimer;

    private int selling_price;

    private int buying_price;

    private int growthTime;

    private boolean isGMCApplied;


    public Seed()
    {
        status = 0;

        icon = new ImageIcon("src/images/seed80x80.png");

        selling_price = 100;

        buying_price = 100;

        growthTime = 60;

        timeHolder = 0;

        hasWater = false;

        isDeveloped = false;

        isPlanted = false;
        isSpoiled = false;

        isFertilized = false;

        isResumedPlant = false;

        isGMCApplied = false;

    }

    public Seed(int selling_price,int buying_price,int growthTime,ImageIcon imageIcon)
    {
        this.selling_price = selling_price;

        this.buying_price = buying_price;

        this.growthTime = growthTime;

        this.icon = imageIcon;


        timeHolder = 0;
        hasWater = false;
        isDeveloped = false;
        isPlanted = false;
        isSpoiled = false;
        isFertilized = false;
        isResumedPlant = false;
        isGMCApplied = false;
    }


    public void plant()
    {
        isPlanted = true;

        if(isResumedPlant && hasWater)
        {
            hasWater = true;
        }
        else
        {
            hasWater = false;
        }

        seedTimer = new Timer(1000, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                timeHolder = timeHolder + 1;
             //   System.out.println("Hello I am seed");
                if ( hasWater && !isDeveloped )
                {
                    checkSeedTime();
                 //   System.out.println("I am planted ");
                    if (status == 1)
                    {
                        isDeveloped = true;
                        seedTimer.stop();

                    }
                }
            }
        });
        seedTimer.start();
    }

    public void resumeTimer()
    {
        setResumedPlant(true);
        plant();
    }

    public void stopTimer()
    {
     //   System.out.println("stop!!!!");
        seedTimer.stop();
    }

    public void setResumedPlant(boolean resumedPlant)
    {
        this.isResumedPlant = resumedPlant;
    }

    private void checkSeedTime()
    {

         if( (timeHolder % growthTime ) == 0  )
         {
             grow();
          //   System.out.println("I am growing");
             consumeWater();
         }
    }

    public void draw(Graphics g)
    {
        g.drawImage(icon.getImage(),getX(),getY(),40,40,null);
    }

    public int getStatus()
    {
        return status;
    }

    public boolean getHasWater()
    {
        return hasWater;
    }

    public int getStoreSellingPrice()
    {
        return selling_price;
    }
    public int getBuying_price()
    {
        return buying_price;
    }

    public String getName()
    {
        return name;
    }


    private void grow()
    {
        status = status + 1;
    }

    public void water()
    {
        hasWater = true;
        System.out.println("Watered");
    }

    private void consumeWater()
    {
        hasWater = false;

    }

    public boolean getDeveloped(){

        return isDeveloped;
    }

    public int getTimeHolder()
    {
        return timeHolder;
    }


    @Override
    public ImageIcon getImage() {
        return icon;
    }



    //gmc develops seed to full bu increases sell price
    public void setFertilizedStatus( boolean fertilized )
    {
        this.isFertilized = fertilized;
        if(fertilized && !isSpoiled )
        {
           // growSpeed += 20;
            selling_price += 5;
            isDeveloped = true;
        }
    }

    //gmc develops seed to full but decreases sell price
    public void setGMCStatus( boolean gmcStatus )
    {
        if(!isDeveloped && !isSpoiled && !isGMCApplied && gmcStatus)
        {
            isGMCApplied = gmcStatus ;

            if( gmcStatus )
            {
                isDeveloped = true;
                selling_price -= 5;
            }
        }
    }


}
