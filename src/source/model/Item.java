package src.source.model;
public abstract class Item extends GameObject
{

	private boolean isSelected;


	public Item(){

	}

	public Item(int x, int y)
	{
		super(x, y);

	}
	
	public abstract int getStoreSellingPrice();


	public void setSelected(boolean isSelected)
	{
		this.isSelected = isSelected;
	}


}
