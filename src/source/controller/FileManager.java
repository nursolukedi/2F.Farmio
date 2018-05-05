package src.source.controller;
import src.source.model.Map;
import src.source.model.SavedFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class FileManager
{
    private int[][] readMap;

    ArrayList<SavedFile> savedFiles;

    private Scanner mapScanner, lineScanner;

    private final int WIDTH = 10;
    private final int HEIGHT = 10;

    private int file_index;

    public FileManager()
    {
        readMap = new int[WIDTH][HEIGHT];
        savedFiles = new ArrayList<>();
        file_index = 0;
    }

    public int[][] readMapData() throws FileNotFoundException
    {
        mapScanner = new Scanner(new File("src/data/map3.txt"));

        int indexLine=0;
        while(mapScanner.hasNext())
        {
            String line = mapScanner.nextLine();
            lineScanner = new Scanner(line);
            lineScanner.useDelimiter(" ");
            int[] row = new int[WIDTH];
            int index=0;
            while(lineScanner.hasNext())
            {
                String go = lineScanner.next();

                row[index] = Integer.parseInt(go);
                System.out.println("=====" + index+"---"+go);
                index++;
            }
            readMap[indexLine]=row;
            indexLine++;
        }

        return readMap;
    }

    public ArrayList<SavedFile> saveGameDataToFile( Map map )
    {
        //create new file for save
        SavedFile savedFile = new SavedFile(file_index);

        //add to list
        savedFiles.add(savedFile);

        //increment index
        ++file_index;

        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream(savedFile.getFile());
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(map);

            out.close();
            fileOut.close();

            System.out.println("Serialized data is saved in file: " + savedFile.getCurrent_index());

        } catch (IOException i)
        {
            i.printStackTrace();
        }

        return savedFiles;
    }

    public Map readMapFromData(int index)
    {
        Map map = null;
        try
        {
            System.out.println("Heyy");
            FileInputStream fileIn = new FileInputStream("src/data/savedFiles/file_"+index+".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            map = (Map) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Map class not found");
            c.printStackTrace();
            return null;
        }

        return map;
    }
    public ArrayList<SavedFile> getSavedFiles()
    {
        return savedFiles;
    }
}
