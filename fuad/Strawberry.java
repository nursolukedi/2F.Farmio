import java.awt.Image;
import javax.swing.ImageIcon;
public class Strawberry extends GameObject implements Food{
	private Image image= new ImageIcon("src/image/strawberry.png").getImage();
	
	private final int healthPoints=100;
	private final int storePrice=10;
	private final String name="strawberry";
	
	public Strawberry(int x, int y){
		super(x, y);

	}
	
	public int getHealthPoints(){
		return healthPoints;
	}
	
	public String getName(){
		return name;
	}
	
	public int getStoreSellingPrice(){
		return storePrice;
	}
	
	public Image getImage(){
		return image;
	}
	
}
