package src.source.model;

import java.awt.*;

public abstract class Food extends Item
{
	public Food(int x,int y)
	{
		super(x,y);
	}
	
	public abstract int getHealthPoints();

}
