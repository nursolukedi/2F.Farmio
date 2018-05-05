package src.source.model;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class Corn extends Food
{
	private ImageIcon icon = new ImageIcon("src/images/corn.png");
	
	private final int healthPoints=50;
	private final int storePrice=15;
	private final String name="corn";

	public Corn(int x,int y)
    {
		super(x,y);
    }

	public int getHealthPoints()
    {
		return healthPoints;
	}
	
	public String getName()
    {
		return name;
	}
	
	public int getStoreSellingPrice()
    {
		return storePrice;
	}

	public ImageIcon getImage()
    {
		return icon;
	}
	public void draw(Graphics g)
	{
		g.drawImage(icon.getImage(),getX(),getY(),40,40,null);
	}
	
}
