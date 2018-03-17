package src;

import java.awt.*;
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
    
    
    
    private int[][] map;


    
    private BufferedImage tileSheet;
    
    
    public TileLayer(int[][] existingMap) {
        
        
        
        map = new int[existingMap.length][existingMap[0].length];
        
        
        
        for (int y = 0; y < map.length; y++)
            
        {
            
            for (int x = 0; x < map[y].length; x++)
                
            {
                
                map[y][x] = existingMap[y][x];
                
            }
            
        }
        
        
        tileSheet = loadTileSheet("a.png");
        
        
    }
    
    public TileLayer (int width, int height) {
        
        map = new int[height][width];
        
    }
    
    
    public static TileLayer readTextFile(String mapFileName) {
        
        
        
        TileLayer layer = null;
        
        
        
        int ROW_NUM = 6;
        int COL_NUM = 8;
        
        
        
        int[][] tempLayout = new int[ROW_NUM][COL_NUM];
        
        
        
        try (BufferedReader reader = new BufferedReader(new FileReader(mapFileName))) {
            
            String line;
            
            int i = 0;
            int j = 0;
            
            while ((line = reader.readLine()) != null && i < ROW_NUM) {
                
                if (line.isEmpty()) // skip (do not care) spaces
                    continue;
                
                
                String[] readValues = line.trim().split(" ");
                
                
                while (j < COL_NUM) { // for (String singleVal : readValues) {
                    
                    if (!readValues[j].isEmpty() && j < COL_NUM) { // if (!singleVal.isEmpty()) {
                        
                        int id = Integer.parseInt(readValues[j]);
                        
                        tempLayout[i][j++] = id;
                        
                        System.out.print(id + " ");
                        
                    } // if
                
                }
                
                i++;
                
                System.out.println("");
                
            } // while
            
        }
        
        catch (IOException exc) {
            
            
            
        }
        
        int width = COL_NUM;
        
        int height = ROW_NUM;
        
        layer = new TileLayer(width, height);
        
        for (int y = 0; y < height; y++) {
            
            for (int x = 0; x < width; x++) {
                
                layer.map[y][x] = tempLayout[y][x];
                
            }
            
        }
        
        layer.tileSheet = layer.loadTileSheet("a.png");
        
        return layer;
        
    }
    
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



      //  g.drawImage(img,0,0,640,480,null );

        for (int row = 0; row < 300; row++) {
            
            for (int col = 0; col < 400; col++) {
                
                int rc = map[row][col];
                
                if (rc == 0) g.setColor(Color.GREEN);
                else if (rc == 1) g.setColor(Color.BLUE);
                
               // g.drawImage(tileSheet, 0 + col * 50, 0 + row * 50, null);
                
                g.fillRect(0 + col * 50, 0 + row * 50, 20, 20);
                
            }
        }
        
    }
    
}