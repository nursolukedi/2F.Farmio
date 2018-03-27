import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map {
	private int[][] map = new int[6][8];
	private Scanner mapScanner, lineScanner;
	
	public Map(boolean newGame) throws FileNotFoundException{
		
		if(newGame){
			for(int a=0; a<6; a++){
				for(int i=0; i<8;i++){
					map[a][i]=0;//g=====GRASS
				}
			}
		}
		else{
			mapScanner = new Scanner(new File("src/data/map.txt"));
			
			int indexLine=0;
			while(mapScanner.hasNext()){
				String line = mapScanner.nextLine();
				lineScanner = new Scanner(line);
				lineScanner.useDelimiter(" ");
				int[] row = new int[8];
				int index=0;
				while(lineScanner.hasNext()){
					String go = lineScanner.next();
					
					row[index] = Integer.parseInt(go);
					System.out.println("=====" + index+"---"+go);
					index++;
				}
				map[indexLine]=row;
				indexLine++;		
			}	
		}	
	}
	public int[][] getMap(){
		
		return map;
	}

}
