package src;

import javax.swing.*;
import java.awt.*;

public class InventoryPanel extends JPanel
{
    //  private Inventory inventory;

      public InventoryPanel()
      {

            setLayout(new GridLayout(2,8));

            JButton addItem1 = new JButton("item1");
            JButton addItem2 = new JButton("item1");
            JButton addItem3 = new JButton("item1");
            JButton addItem4 = new JButton("item1");

            add(addItem1);

            add(addItem2);

            add(addItem3);

            add(addItem4);

      }

      private void initiliazeObjects()
      {





      }
}
