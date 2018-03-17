package src;

import java.util.ArrayList;

public class Inventory
{

    ArrayList<Item> items;

    public Inventory()
    {
        initializeItems();
    }

    private void initializeItems()
    {
        items = new ArrayList<Item>();
        for (int i = 0; i < 7; i++ )
        {

    //       items.add(new Item("seed","1",) );
        }
    }
}
