package src.source.view;

import src.source.controller.MapManager;
import src.source.model.Food;
import src.source.model.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class InventorySlot extends JLabel
{

    private Item slotItem;

    private MapManager mapManager;

    private InventoryPanel inventoryPanel;

    private JPopupMenu menu = new JPopupMenu("Popup");


    private boolean isClicked;

    public InventorySlot( Item item, MapManager mapManager, InventoryPanel inventoryPanel )
    {
        this.slotItem = item;

        isClicked = false;

        this.mapManager = mapManager;

        this.inventoryPanel = inventoryPanel;



        //adds a menu to slot
        JMenuItem consume = new JMenuItem("eat");


        //this listens consume action.If consume is clicked, it tells map manager to update farmer health
        consume.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Consume is clicked");

                if(mapManager != null)
                {
                    mapManager.updateFarmerHealth((Food) slotItem);
                    Container parent = getLabelThis().getParent();
                    parent.remove(getLabelThis());
                    parent.validate();
                    parent.repaint();
                }
            }
        });

        menu.add(consume);


        addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent arg0)
            {

                //if this slot is left clicked. It tells map manager to update selected item.
                if(SwingUtilities.isLeftMouseButton(arg0))
                {
                    System.out.println("Yeah");

                    mapManager.onSelect(slotItem);

                    isClicked = true;

                    inventoryPanel.checkSelectedSlots();

                }
                //if right button is clicked and slot has food in it. Show a menu that has "consume" event in it.
                else if(slotItem instanceof Food && SwingUtilities.isRightMouseButton(arg0))
                {
                    menu.show(getLabelThis(),arg0.getX(),arg0.getY());
                }

                //tells map manager to deselect the selected item.
                else if(SwingUtilities.isRightMouseButton(arg0))
                {
                   mapManager.deSelect();

                   isClicked = false;

                   inventoryPanel.checkSelectedSlots();

                }

            }

        });

       // setBorder(BorderFactory.createLineBorder(Color.black));

        setPreferredSize(new Dimension(20, 20));

        Image image = item.getImage().getImage();

        Image newImg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way

        ImageIcon imageIcon = new ImageIcon(newImg);  // transform it back

        setIcon(imageIcon);
    }

    private JLabel getLabelThis() {
        return this;
    }

    public boolean getIsClicked()
    {
        return isClicked;
    }

    public void setIsClicked(boolean isClicked)
    {
       this.isClicked = isClicked;
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }



}
