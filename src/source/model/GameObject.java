package src.source.model;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
public abstract class GameObject implements java.io.Serializable {

    private int x;
	private int y;

	public GameObject(){


	}

	public GameObject(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public void setX(int x){
		this.x=x;
	}
	
	public void setY(int y){
		this.y=y;
	}
	
	public int getY(){
		return y;
	}
	public int getX(){
		return x;
	}

	public abstract String getName();

    public abstract ImageIcon getImage();

}
