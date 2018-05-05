package src.source.model;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
public class Tomato extends Food{
	private ImageIcon image= new ImageIcon("src/images/tomato.png");

	//private BufferedImage image = loadTileSheet("src/images/tomato.png");

	private final int healthPoints=25;
	private final int storePrice=5;
	private final String name="corn";
	
	public Tomato(int x, int y)
	{
		super(x, y);
	}
	
	public int getHealthPoints(){
		return healthPoints;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getStoreSellingPrice(){
		return storePrice;
	}

	public ImageIcon getImage(){

		return image;
	}

	public void draw(Graphics g)
	{
		g.drawImage(image.getImage(),getX(),getY(),40,40,null);
	}


}