package src.source.model;
import java.util.ArrayList;

public class Inventory {
	
	private ArrayList <Item> inventory;
	private int strawBerryCnt=0;
	private int cornCnt=0;
	private int sunFlowerCnt=0;
	private int strawberrySeedCnt=0;
	private int cornSeedCnt=0;
	private int sunFlowerSeedCnt=0;
	
	
	public Inventory(){
		inventory = new ArrayList<Item>();
	}
	
	public void addItem(Item ad){
		if (ad instanceof Corn) cornCnt++;
		if (ad instanceof Sunflower) sunFlowerCnt++;
		if (ad instanceof Strawberry) strawBerryCnt++;
		//if (ad instanceof CornSeed) cornSeedCnt++;
		//if (ad instanceof SunflowerSeed) sunFlowerSeedCnt++;
		//if (ad instanceof StrawberrySeed) strawberrySeedCnt++;
		inventory.add(ad);
	}
	
	public Item useItem(String usedItem){
		Item used = null;
		if(usedItem.equals("corn")){			
			for(int i=0; i<inventory.size(); i++){
				if(inventory.get(i).getName().equals("corn")){
					used= inventory.get(i);
					inventory.remove(i);
				}
			}
			
		}
		
		if(usedItem.equals("strawberry")){			
			for(int i=0; i<inventory.size(); i++){
				if(inventory.get(i).getName().equals("strawberry")){
					used= inventory.get(i);
					inventory.remove(i);
				}
			}
			
		}
		
		if(usedItem.equals("sunflower")){			
			for(int i=0; i<inventory.size(); i++){
				if(inventory.get(i).getName().equals("sunflower")){
					used= inventory.get(i);
					inventory.remove(i);
				}
			}
			
		}
		
		return used;
		
	}
	
	public int countOfCorn(){
		return cornCnt;
	}
	
	public int countOfSunflower(){
		return sunFlowerCnt;
	}
	public int countOfStrawberry(){
		return strawBerryCnt;
	}
	public int countOfStrawberrySeed(){
		return strawberrySeedCnt;
	}
	public int countOfSunflowerSeedCnt(){
		return sunFlowerSeedCnt;
	}
	public int countOfCornSeed(){
		return cornSeedCnt;
	}
	
	
}
