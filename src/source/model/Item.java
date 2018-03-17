package src.source.model;
public abstract class Item extends GameObject{
	
	public Item(int x, int y){
		super(x, y);
	}
	
	public abstract int getStoreSellingPrice();
	
	

}
