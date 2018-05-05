package src.source.model;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


//map is façade class for gameobjects. In order to modify game objects map should be accessed.

public class Map implements java.io.Serializable
{

    private static int ROW_NUMBER = 10;

    private static int COL_NUMBER = 10;

    private static int OBJECT_SIZE = 100;

    private static int WIDTH_SIZE = 1000;

    private static int HEIGHT_SIZE = 1000;


    private ArrayList<Seed> plantedSeeds;

    private ArrayList<Tree> plantedTrees;

    private GameObject[][] gameObjects;


    private Inventory inventory;

    private int[][] landMap;

    private Farmer farmer;

    private boolean gameOver;

    private int farmerDelay;

    private Food harvestedFood;


    private int columnPos;

    private int rowPos;

    private FarmHouse farmHouse;

    private ImageIcon background;

    private ImageIcon treeTop;

    private Rain rain;


    public Map()
    {
        farmerDelay = 0;

        plantedSeeds = new ArrayList<>();

        farmer = new Farmer();

        gameOver = false;
    }


    public Map(int[][] readMap)
    {
        this.landMap = readMap;

        columnPos = 0;

        rowPos = 0;

        harvestedFood = null;

        farmerDelay = 0;

        plantedSeeds = new ArrayList<>();

        plantedTrees = new ArrayList<>();

        rain = new Rain();

        farmer = new Farmer();

        inventory = new Inventory();

        gameOver = false;

        gameObjects = new GameObject[ROW_NUMBER][COL_NUMBER];

        farmHouse = new FarmHouse();

        loadMap();

        treeTop = new ImageIcon("src/images/xd_tree.png");

        background = new ImageIcon("src/images/758e05cf2b472e1ba65c68b9c350a1ed.jpg");
    }

    //map also contains the food that wanted to be harvested.
    public void setHarvestedFood(Food harvestedFood)
    {
       this.harvestedFood = harvestedFood;
    }

    //this stops all seed timers. This function is needed when new map is created. To stop everything.
    public void stopAllSeeds()
    {
        for( int i = 0; i < plantedSeeds.size(); i++ )
        {
            Seed seed = plantedSeeds.get(i);
            seed.stopTimer();
        }
    }

    //stops all tree timers. This function is needed when new map is created.
    public void stopAllTrees()
    {
        for( int i = 0; i < plantedTrees.size(); i++ )
        {
            Tree tree = plantedTrees.get(i);
            tree.stopTimer();
        }
    }


    public Farmer getFarmer()
    {
        return farmer;
    }


    //regularly updates farmer health
    public void updateFarmer()
    {
        farmerDelay++;

        if( (farmerDelay % 20) == 0 )
        {
            farmer.decreaseHealth(1);

            System.out.println("Farmer health is" + farmer.getFarmerHealth());

            System.out.println("health is decreasing");

            if (farmer.getFarmerHealth() == 0)
            {
                gameOver = true;
            }
        }
    }


    //delete game object from map with x and y
    public void deleteFromMap(int x,int y)
    {
        gameObjects[y][x] = null;
    }

    //increase farmer health with the value of food
    public void increaseFarmerHealth(Food food)
    {
        inventory.useItem(food.getName());
        farmer.consumeFood(food);
    }

    //regularly updates farm, checks for developed seeds.If the seed is developed turns into associated fruit or tree
    public void updateFarm()
    {
        for(int i =0; i < plantedSeeds.size(); i++)
        {
            Seed seed = plantedSeeds.get(i);
            if(seed.getDeveloped())
            {
                //do staff
                System.out.println("I am ready to be turned into fruit");


                int x = seed.getX();
                int y = seed.getY();

                //checks seed and turns into food according to seed name
                if( seed instanceof TomatoSeed )
                {
                    Tomato tomato = new Tomato(x,y);
                    gameObjects[y/OBJECT_SIZE][x/OBJECT_SIZE] = tomato;
                }
                else if ( seed instanceof  PotatoSeed )
                {
                    Potato potato = new Potato(x,y);
                    gameObjects[y/OBJECT_SIZE][x/OBJECT_SIZE] = potato;
                }
                else if ( seed instanceof SunflowerSeed )
                {
                    Sunflower sunflower = new Sunflower(x,y);
                    gameObjects[y/OBJECT_SIZE][x/OBJECT_SIZE] = sunflower;
                }
                else if ( seed instanceof StrawberrySeed )
                {
                    Strawberry strawberry = new Strawberry(x,y);
                    gameObjects[y/OBJECT_SIZE][x/OBJECT_SIZE] = strawberry;
                }
                else if ( seed instanceof CornSeed )
                {
                    Corn corn = new Corn(x,y);
                    gameObjects[y/OBJECT_SIZE][x/OBJECT_SIZE] = corn;
                }

                plantedSeeds.remove(seed);
            }
        }

        rain.raining(plantedTrees);
    }

    //adds seed to map
    public void addSeedToLand( Seed seed, int x, int y)
    {
        //this checks the instance of seed(tomatoseed or sunflower seed or etc..)
        Seed newSeed = null;

        if( seed instanceof TomatoSeed)
        {
            newSeed = new TomatoSeed();
        }
        else if( seed instanceof StrawberrySeed )
        {
            newSeed = new StrawberrySeed();
        }
        else if ( seed instanceof SunflowerSeed )
        {
            newSeed = new SunflowerSeed();
        }
        else if ( seed instanceof PotatoSeed )
        {
           newSeed = new PotatoSeed();
        }
        else if ( seed instanceof CornSeed)
        {
            newSeed = new CornSeed();
        }

        //set x and y location of new seed
        newSeed.setX(columnPos*OBJECT_SIZE);
        newSeed.setY(rowPos*OBJECT_SIZE);

        //add new seed to planted seeds array
        plantedSeeds.add(newSeed);

        //add new seed to map
        gameObjects[rowPos][columnPos] = newSeed;


        //deselect item
        onDeselect();

        //remove planted seed from inventory
        inventory.useItem(newSeed.getName());

        //call plant method of new seed
        newSeed.plant();
    }

    //this fertilizes seed in specific x, y location using fertilizer object
    public void applyFertilizeSeed(Fertilizer fertilizer,int x, int y)
    {
        Seed fertilizedSeed = (Seed)gameObjects[y][x];
        fertilizer.applyPowerUp(fertilizedSeed);
        onDeselect();
    }

    //this applies gmc to seed using gmc object
    public void applyGMCSeed(GMC gmc,int x, int y)
    {
        Seed gmcSeed = (Seed)gameObjects[y][x];
        gmc.applyPowerUp(gmcSeed);
    }

    //this applies water to seed in map(x,y) using can object
    public void applyWaterToSeed(WateringCan can, int x, int y)
    {
        Seed wateredSeed = (Seed)gameObjects[y][x];
        can.water(wateredSeed);
    }

    //checks whether selected area has seed object
    public boolean checkSeedLand(int x,int y)
    {
        if( !checkFarmHouse(x,y))
        {
            columnPos = x/OBJECT_SIZE;

            rowPos = y/OBJECT_SIZE;

            GameObject object = gameObjects[rowPos][columnPos];

            if ( object instanceof Seed)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }

    }

    //checks the availability of the land.
    public boolean checkAvailability(int x,int y)
    {

        if( !checkFarmHouse( x, y))
        {
            columnPos = x / OBJECT_SIZE;

            rowPos = y / OBJECT_SIZE;

            GameObject object = gameObjects[rowPos][columnPos];

            if (object != null) {
                return false;
            } else {
                return true;
            }
        }
        else{
            return false;
        }
    }

    //checks whether user clicked to farm house. If x and y has farm house return true
    public boolean checkFarmHouse( int x, int y)
    {
        if( ( ( farmHouse.getX() <= x ) && ( x <= ( farmHouse.getX() + farmHouse.getWidth() ) ) )
                &&  ( (farmHouse.getY() <= y) && ( y <= ( farmHouse.getY() + farmHouse.getHeight() )  ) ) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //returns game object from 2d gameobjects array
    public GameObject getGameObject(int x,int y)
    {
        columnPos = x/OBJECT_SIZE;
        rowPos = y/ OBJECT_SIZE;
        return gameObjects[rowPos][columnPos];
    }

    //get gameover state
    public boolean getGameOver()
    {
        return gameOver;
    }

    //this load map from landMap object
    private void loadMap()
    {

        for(int i=0; i<ROW_NUMBER; i++)
        {
            for (int j = 0; j < COL_NUMBER; j++)
            {
                if( landMap[i][j]==1 )
                {
                    AppleTree appleTree = new AppleTree( j* OBJECT_SIZE, i*OBJECT_SIZE );
                    gameObjects[i][j] = appleTree;
                    plantedTrees.add(appleTree);
                }
                else if( landMap[i][j] ==2 )
                {
                    CherryTree cherryTree = new CherryTree( j* OBJECT_SIZE, i*OBJECT_SIZE );
                    gameObjects[i][j] = cherryTree;
                    plantedTrees.add(cherryTree);
                }
                else if( landMap[i][j] ==3 )
                {
                    RaspberryTree raspberryTree = new RaspberryTree(j* OBJECT_SIZE, i*OBJECT_SIZE);
                    gameObjects[i][j] = raspberryTree;
                    plantedTrees.add(raspberryTree);
                }
                else{
                    gameObjects[i][j] = null;
                }

            }
        }

    }
    //map can specify user's selected item
    public void onSelect(Item selectedItem)
    {
        inventory.selectItem(selectedItem);
    }

    //map can de select item.
    public void onDeselect()
    {
        if(inventory.getHasSelected())
        {
            inventory.deselectItem();
        }
    }

    //adds item to inventory
    public void addToInventory(Item newItem)
    {
        inventory.addItem(newItem);
    }

    //returns selected item
    public Item getSelectedItem()
    {
        if(inventory.getHasSelected())
        {
            Item a = inventory.getSelectedItem();
            System.out.println(a.getName() + "is selected");
            return a;
        }
        return null;
    }

    //resumes seed timers in planted seeds
    public void resumeSeedTimers(){

        for ( int i = 0; i < plantedSeeds.size(); i++)
        {
            Seed seed = plantedSeeds.get(i);
            seed.resumeTimer();
        }
    }

    //resume tree timers
    public void resumeTreeTimers()
    {

        for ( int i = 0; i < plantedTrees.size(); i++ )
        {
            Tree tree = plantedTrees.get(i);
            tree.resumeTimer();
        }
    }

    //returns inventory
    public Inventory getInventory()
    {
        return inventory;
    }

    //returns selected item from inventory
    public boolean isHasSelected()
    {
        return inventory.getHasSelected();
    }

    public Food getHarvestedFood()
    {
        return harvestedFood;
    }


    public GameObject[][] getGameObjects()
    {
        return gameObjects;
    }


    //draws game objects to screen
    public void drawMap(Graphics g)
    {
        g.drawImage(background.getImage(), 0, 0, WIDTH_SIZE, HEIGHT_SIZE, null);

        for (int row = 0; row < ROW_NUMBER; row++)
        {
            for (int col = 0; col < COL_NUMBER; col++)
            {
                GameObject object = gameObjects[row][col];

                if ( object instanceof PotatoSeed)
                {
                    ((PotatoSeed) object).draw(g);
                }
                else if(object instanceof SunflowerSeed)
                {
                    ((SunflowerSeed) object).draw(g);
                }
                else if(object instanceof StrawberrySeed)
                {
                    ((StrawberrySeed) object).draw(g);
                }
                else if(object instanceof TomatoSeed)
                {
                    ((TomatoSeed) object).draw(g);
                }
                else if(object instanceof  CornSeed )
                {
                    ((CornSeed) object).draw(g);
                }
                else if(object instanceof Tomato)
                {
                    ((Tomato) object).draw(g);
                }
                else if(object instanceof Sunflower )
                {
                    ((Sunflower) object).draw(g);
                }
                else if(object instanceof Strawberry )
                {
                    ((Strawberry) object).draw(g);
                }
                else if( object instanceof Potato)
                {
                    ((Potato) object).draw(g);
                }
                else if ( object instanceof AppleTree)
                {
                    ( (AppleTree) object ).draw(g);
                }
                else if ( object instanceof CherryTree)
                {
                    ( (CherryTree) object ).draw(g);
                }
                else if ( object instanceof  RaspberryTree)
                {
                    ( (RaspberryTree) object ).draw(g);
                }

            }
        }
        //draw house
        g.drawImage( (farmHouse.getImage()).getImage(),farmHouse.getX(),farmHouse.getY(),null);
    }
}
