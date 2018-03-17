package src.source.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;

// sources used:
// https://www.youtube.com/watch?v=rWzINXeC0lY
// https://www.youtube.com/watch?v=FUgn-PA7yzc

public class TileLayer {
    
    // instance variables
    
    
    // int matrix to illustrate the map
    private int[][] map;
    
    
    // main tile image
    private BufferedImage seed, redSeed, treeTop;
    
    
    private static int ROW_NUMBER = 6;
    private static int COL_NUMBER = 8;
    
    
    // constructor
    public TileLayer(int[][] existingMap) {
        
        
        // fill the map according to the previously saved one
        
        
        map = new int[existingMap.length][existingMap[0].length];
        
        
        for (int y = 0; y < map.length; y++) 
        {
            for (int x = 0; x < map[y].length; x++)  
            {
                
                map[y][x] = existingMap[y][x];
                
            }
        }
        
        
        seed = loadTileSheet("src/images/redSeed80x80.png");
        redSeed = loadTileSheet("src/images/redSeed80x80.png");
        treeTop = loadTileSheet("src/images/treetop80x80.png");
        
    } // constructor
    
    
    
    // default constructor
    public TileLayer (int width, int height) {
        
        map = new int[height][width];
        
    }
    
    
    
    // reads the text file
    public static TileLayer readTextFile(String mapFileName) {
          
        
        TileLayer layer = null;
        
        
        
        int[][] tempLayout = new int[ROW_NUMBER][COL_NUMBER];
        
        
        
        // try reading the text file
        
        try (BufferedReader reader = new BufferedReader(new FileReader(mapFileName))) {
            
            
            String line; // a line (row) of the text file
            
            
            int i = 0; // index to access rows
            int j; // index to access columns
            
            
            
            // read a single line of the text file
            
            while (i < ROW_NUMBER && (line = reader.readLine()) != null) {
                
                
                
                // make sure the column index is initialized back to 0
                j = 0;
                
                
                
                
                if (line.isEmpty()) // to skip empty spaces in the text file
                    continue;
                
                
                // get the values (from a row of the text file)
                // which are separated by empty spaces (" ")
                
                String[] readValues = line.trim().split(" ");
                
                
                
                // for each value other than a space (" ")
                
                for (String singleVal : readValues) {
                    
                    
                    if (!singleVal.isEmpty()) { // if the read token is not empty
                        
                        
                        // convert that value to an integer
                        
                        int id = Integer.parseInt(singleVal);
                        
                        
                        // assign the respective cell of the matrix to that value
                        // i.e. fill the 2-D array
                        
                        tempLayout[i][j++] = id;
                        
                        
                        // for tracing purposes
                        System.out.print(id + " ");
                        
                     
                    } // if
                
                    
                } // a line from the text file is consumed, move the next line
                
                i++; // move to the next row
                
                // for tracing purposes
                
                System.out.println("");
                
                
            } // while
            
        } // try block
        
        
        
        catch (IOException exc) {
            
            System.out.println("Could not read the text file!");
            
        }
        
        
        
        layer = new TileLayer(COL_NUMBER, ROW_NUMBER);
        
        
        
        for (int y = 0; y < ROW_NUMBER; y++) {
            
            for (int x = 0; x < COL_NUMBER; x++) {
                
                layer.map[y][x] = tempLayout[y][x];
                
            }
            
        }
        
        
        
        layer.seed = layer.loadTileSheet("src/images/seed80x80.png");
        layer.redSeed = layer.loadTileSheet("src/images/redSeed80x80.png");
        layer.treeTop = layer.loadTileSheet("src/images/treetop80x80.png");
        
        
        
        return layer;
        
        
    } // readTextFile()
    
    
    
    public BufferedImage loadTileSheet(String fileName) {
        
        
        BufferedImage image = null;
        
        
        try {
            
            image = ImageIO.read(new File(fileName));
            
        }
        
        
        catch(IOException exc) {
            
            System.out.println("Cannot load image!");
            
        }
        
        return image;
        
    } // loadTileSheet
    
    
    
    public void drawLayer(Graphics g) {
        

        BufferedImage img2 = loadTileSheet("src/images/758e05cf2b472e1ba65c68b9c350a1ed.jpg");

        g.drawImage(img2,0,0,640,480,null);

        for (int row = 0; row < ROW_NUMBER; row++) {
            
            
            for (int col = 0; col < COL_NUMBER; col++) {
                
                
                
                int rc = map[row][col]; // 
                
                
                
                if (rc == 0) 
                
                {
                    g.drawImage(treeTop, col * 80, row * 80, null);
                }
                
                
                
                else if (rc == 1)
                    
                {
                    g.drawImage(seed, col * 80, row * 80, null);
                }
                
                
                
                else if (rc == 2)
                    
                {
                    g.drawImage(redSeed, col * 80, row * 80, null);
                }
                
                
                
            } // columns
            
        } // rows
        
        
        
    } // drawLayer()
    
} // TileLayer
