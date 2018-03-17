import java.util.ArrayList;
public class Inventory {
	
	private ArrayList <Item> inventory;
	int strawBerryCnt=0;
	int cornCnt=0;
	int sunFlowerCnt=0;
	int strawberrySeedCnt=0;
	int cornSeedCnt=0;
	int sunFlowerSeedCnt=0;
	
	
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
