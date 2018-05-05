package src.source.model;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
public class Sunflower extends Food{


	private ImageIcon icon  = new ImageIcon("src/images/sunflower.png");
	
	private final int healthPoints=25;
	private final int storePrice=5;
	private final String name="sunflower";
	
	public Sunflower(int x, int y)
	{
		super(x, y);
	}
	
	public int getHealthPoints()
	{
		return healthPoints;
	}
	
	public String getName(){
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
