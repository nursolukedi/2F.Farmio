package src;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
public abstract class GameObject {
	private int x;
	private int y;
	
	private static int side=50; //planning to make an rectangle on every 
	//object to detect collision with mouse 
	private Rectangle rect;
	
	public GameObject(int x, int y){
		this.x=x;
		this.y=y;
		
		rect = new Rectangle(x, y, side, side);
	}
	
	public void setX(int x){
		this.x=x;
	}
	
	public void setY(int y){
		this.y=y;
	}
	
	public int getY(int y){
		return y;
	}
	
	public int getX(int y){
		return x;
	}
	
	
	public abstract String getName();
	public abstract Image getImage();
}
