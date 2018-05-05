package src.source.model;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

public class Inventory implements java.io.Serializable
{
	
	private ArrayList <Item> inventory;

	private int foodCnt;

	private int seedCnt;


	private int strawBerryCnt;
	private int cornCnt;
	private int sunFlowerCnt;
	private int strawberrySeedCnt;
	private int cornSeedCnt;
	private int sunFlowerSeedCnt;
	private int potatoSeedCnt;
	private int potatoCnt;
	private int tomatoCnt;

	private int tomatoSeedCnt;

	private int GMCcnt;

	private int fertilizerCnt;



	private Item selectedItem;

	private boolean hasSelectedItem;

	public Inventory()
	{
		inventory = new ArrayList<Item>();

		seedCnt = 0;
		foodCnt = 0;

		fertilizerCnt = 0;
		GMCcnt = 0;


		strawBerryCnt = 0;
		sunFlowerCnt = 0;
        cornCnt = 0;
        potatoCnt = 0;
		tomatoCnt = 0;

		strawberrySeedCnt = 0;
		cornSeedCnt = 0;
		sunFlowerSeedCnt = 0;
		potatoSeedCnt = 0;
		tomatoSeedCnt = 0;

		init();
	}
	
	public void addItem(Item ad)
	{
		if (ad instanceof Corn) cornCnt++;
		if (ad instanceof Sunflower) sunFlowerCnt++;
		if (ad instanceof Strawberry) strawBerryCnt++;
		if (ad instanceof CornSeed) cornSeedCnt++;
		if (ad instanceof SunflowerSeed) sunFlowerSeedCnt++;
		if (ad instanceof StrawberrySeed) strawberrySeedCnt++;
        if (ad instanceof Potato) potatoCnt++;
        if (ad instanceof Tomato) tomatoCnt++;
        if (ad instanceof PotatoSeed) potatoSeedCnt++;
        if (ad instanceof TomatoSeed) tomatoSeedCnt++;
        if (ad instanceof GMC) GMCcnt++;
        if (ad instanceof Fertilizer) fertilizerCnt++;

		inventory.add(ad);
	}

	public Item deleteItem( String name )
	{
		for(int i = 0; i < inventory.size(); i++ )
		{
			if( (inventory.get(i)).getName().equals(name) )
			{
				return inventory.remove(i);
			}
		}

		System.out.println("Not Found");
		return null;
	}

	public Item getItem(int index)
	{
		return inventory.get(index);
	}

	public void selectItem(Item selectedItem)
	{
		System.out.println(selectedItem.getName());

		this.selectedItem = selectedItem;

		hasSelectedItem = true;
	}

    public void addPurchasedItems(String name, int count, int purchasePrice) {

        for (int i = 0; i < count; i++) {

            switch (name) {
                case "Corn":
                    addItem(new CornSeed());
                    break;

                case "Sunflower":
                    addItem(new SunflowerSeed());
                    break;

                case "Potato":
                    addItem(new PotatoSeed());
                    break;

                case "Tomato":
                    addItem(new TomatoSeed());
                    break;

                case "Strawberry":
                    addItem(new StrawberrySeed());
                    break;

                case "GMC":
                    addItem(new GMC());
                    break;

                case "Fertilizer":
                    addItem(new Fertilizer());
                    break;

                default:
                    System.out.println("Problem in addPurchasedSeeds");
                    break;

            }

        }
        System.out.println("-" + purchasePrice * count);
        // setFarmersMoney(getFarmersMoney() - purchasePrice * count);

    }



    public boolean isWateringCan( Item item )
	{
		if( item.getName().equals("WateringCan") )
		{
			return true;
		}
		return false;
	}

	public Item getSelectedItem()
	{
		return selectedItem;
	}

	public void deselectItem()
	{
		hasSelectedItem = false;
		selectedItem = null;
	}

	public boolean getHasSelected()
	{
		return hasSelectedItem;
	}


	public ArrayList<Item> getInventoryItems()
    {
	    return inventory;
    }

	public void init(){
		//CornSeed crns = new CornSeed();

		PotatoSeed seed = new PotatoSeed();

		WateringCan wtrcan = new WateringCan();
		GMC gmc = new GMC();
		addItem( seed);
		addItem( wtrcan );
		addItem( gmc );
	}

	
	public Item useItem(String usedItem)
	{
		Item used = null;

		for(int i=0; i<inventory.size(); i++)
		{
		    used = inventory.get(i);

			if(inventory.get(i).getName().equals(usedItem))
			{
                if (used instanceof Corn) {

                    System.out.println("entered a");

                    cornCnt--;
                }
                else if (used instanceof CornSeed) {

                    System.out.println("entered b");

                    cornSeedCnt--;
                }
                else if(used instanceof Tomato) {

                    System.out.println("entered c");

                    tomatoCnt--;
                }
                else if(used instanceof TomatoSeed) {

                    System.out.println("entered d");

                    tomatoSeedCnt--;
                }
                else if (used instanceof Potato) {

                    System.out.println("entered e");

                    potatoCnt--;
                }
                else if (used instanceof PotatoSeed) {

                    System.out.println("entered f");

                    potatoSeedCnt--;
                }
                else if (used instanceof Strawberry) {

                    System.out.println("entered g");

                    strawBerryCnt--;
                }
                else if (used instanceof StrawberrySeed) {

                    System.out.println("entered h");

                    strawberrySeedCnt--;
                }
                else if (used instanceof Sunflower) {

                    System.out.println("entered i");

                    sunFlowerCnt--;
                }
                else if (used instanceof SunflowerSeed) {

                    System.out.println("entered j");

                    sunFlowerSeedCnt--;
                }
                else if (used instanceof GMC) {

                    System.out.println("entered k");

                    GMCcnt--;
                }
                else if (used instanceof Fertilizer) {

                    System.out.println("entered l");

                    fertilizerCnt--;
                }
                else {
                    System.out.println(used.getName());
                    System.out.println("Problem!!!");
                }

                inventory.remove(used);
                return used;
			}
		}
		return null;
	}

    public void removeSoldItems(String name, int count, int sellingPrice) {

        for (int i = 0; i < count; i++) {

            useItem(name.toLowerCase());

        }
        System.out.println("+" + sellingPrice * count);
        // setFarmersMoney(getFarmersMoney() + sellingPrice * count);

    }
	public int getCornCnt(){
		return cornCnt;
	}
	
	public int getSunFlowerCnt(){
		return sunFlowerCnt;
	}
	public int getStrawBerryCnt(){
		return strawBerryCnt;
	}
	public int getStrawberrySeedCnt(){
		return strawberrySeedCnt;
	}
	public int getSunFlowerSeedCnt(){
		return sunFlowerSeedCnt;
	}
	public int getCornSeedCnt(){
		return cornSeedCnt;
	}

	public int getFoodCnt( String name)
    {
        return  foodCnt;
    }
	public int getSeedCnt( String name )
    {
        return  seedCnt;
    }

	public int getTomatoCnt() {return tomatoCnt;}

	public int getPotatoCnt() {return  potatoCnt; }

    public int getPotatoSeedCnt() {return  potatoSeedCnt; }

    public int getTomatoSeedCnt() {return tomatoSeedCnt; }

    public int getGMCcnt() {return  GMCcnt;}


    public int getFertilizerCnt() { return fertilizerCnt; }
}
