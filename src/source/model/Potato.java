package src.source.model;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
public class Potato extends Food
{
	private ImageIcon imageIcon = new ImageIcon("src/images/potato.png");
	
	private final int healthPoints=1;
	private final int storePrice=1;
	private final String name="corn";
	
	public Potato(int x, int y){
		super(x, y);
	}
	
	public int getHealthPoints()
	{
		return healthPoints;
	}
	
	public String getName(){
		return name;
	}
	
	public int getStoreSellingPrice(){
		return storePrice;
	}


	public ImageIcon getImage(){
		return imageIcon;
	}

    public void draw(Graphics g)
    {
        g.drawImage(imageIcon.getImage(),getX(),getY(),40,40,null);
    }

}