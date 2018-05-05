package src.source.view;

import src.source.controller.*;
import src.source.model.*;
//import src.source.model.Inventory;

import javax.lang.model.type.NullType;
import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class InventoryPanel extends JPanel
{

      private MapManager mapManager;

      private ArrayList<InventorySlot> slots;

      private ImageIcon background;


      public InventoryPanel( MapManager mapManager )
      {
            setLayout(new GridLayout(0,8));

            setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));

            background = new ImageIcon("src/images/inventorybackground2.jpg");

            this.mapManager = mapManager;

            slots = new ArrayList<>();
      }

      public void addToInvPanel(Item newItem)
      {
          InventorySlot newSlot = new InventorySlot( newItem, mapManager,this);

          add(newSlot);

          slots.add(newSlot);

          validate();
          repaint();
      }

      //this function checks for selected slot and then makes it blue.
      public void checkSelectedSlots()
      {
          for ( int i = 0; i < slots.size(); i++ )
          {
              InventorySlot slot = slots.get(i);
              if( slot.getIsClicked() )
              {
                  slot.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                  slot.setIsClicked(false);
              }
              else
              {
                  slot.setBorder(javax.swing.BorderFactory.createEmptyBorder());
              }
          }
      }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(background.getImage(), 0, 0, 700, 400, null);
    }

}
