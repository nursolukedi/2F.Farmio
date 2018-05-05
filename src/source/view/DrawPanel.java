/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.source.view;

import src.source.controller.MapManager;
import src.source.model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author
 */
public class DrawPanel extends JPanel
{

    private Map map;

    private MapManager mapManager;

    private int x;

    private int y;

    private JPopupMenu menu;

    private JMenuItem menuItem;

    private GamePanel gamePanel;


    public DrawPanel(GamePanel gamePanel) //Map loadedMap
    {
        menu = new JPopupMenu("Harvest");
        menuItem = new JMenuItem("Harvest");
        this.gamePanel = gamePanel;

        menuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                  Food harvestedFood = map.getHarvestedFood();
                  if(harvestedFood != null)
                  {
                      mapManager.deleteObject(x,y);
                      mapManager.addToInv(harvestedFood);
                  }
                  focusGet();
            }

        });
        menu.add(menuItem);

        //this listens click events on map. And if user wants to select something and clicks to map.
        // It tells manager to do according to selected item
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                x = e.getX();
                y = e.getY();
                if(  map.isHasSelected() )
                {
                   Item drawedItem = map.getSelectedItem();

                   if(drawedItem instanceof Seed)
                   {
                       mapManager.addSeedMap((Seed)drawedItem,x,y);
                   }
                   else if(drawedItem instanceof WateringCan)
                   {
                       mapManager.applyWater((WateringCan) drawedItem,x,y);
                   }
                   else if(drawedItem instanceof GMC )
                   {
                       mapManager.invokeGMC((GMC) drawedItem , x , y );
                   }
                   else if(drawedItem instanceof Fertilizer)
                   {
                       mapManager.invokeFertilizer((Fertilizer) drawedItem, x, y );
                   }
                }

                else if( SwingUtilities.isRightMouseButton(e) && mapManager.getGameObject(x,y) instanceof Food )
                {
                    menu.show(getPanel(),x,y);

                    mapManager.setHarvestedFood((Food)mapManager.getGameObject(x,y));
                }

               else
               {
                   JOptionPane.showMessageDialog(getPanel(),"Please choose item");
               }

               focusGet();
            }
        });
    }
    private void focusGet()
    {
        gamePanel.requestFocusInWindow();
    }

    public JPanel getPanel()
    {
        return this;
    }

    //sets map and map manager for drawing
    public void setMapManager(MapManager mapManager)
    {
        this.mapManager = mapManager;
        this.map = mapManager.getMap();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if ( mapManager.getMap() != null )
        {
            mapManager.drawMap(g);
        }
    }
    
}
