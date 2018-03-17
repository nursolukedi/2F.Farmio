package doc.fuad;
import java.awt.Image;
import javax.swing.ImageIcon;
public class Corn extends GameObject implements Food{
	private Image image= new ImageIcon("src/image/corn.png").getImage();
	
	private final int healthPoints=50;
	private final int storePrice=15;
	private final String name="corn";
	
	public Corn(int x, int y){
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
