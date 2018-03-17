import java.awt.Image;
import javax.swing.ImageIcon;
public class Potato extends Food{
	private Image image= new ImageIcon("src/image/tomato.png").getImage();
	
	private final int healthPoints=1;
	private final int storePrice=1;
	private final String name="corn";
	
	public Potato(int x, int y){
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