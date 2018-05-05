package src.source.view;

import src.source.model.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



/**
 *
 * @author Eray
 */
public class StorePanel extends JPanel {


    // panels for the items in the store

    ItemPanel corn = null, strawberry = null, sunflower = null, potato = null, tomato = null;

    ItemPanel GMC = null, fertilizer = null;



    private Inventory inv = null; // reference to inventory



    private Map map;  // reference to map


    JPanel panel;

    JScrollPane scrollPane;



    // constructor

    public StorePanel(Map map, Inventory inv) {

        this.map = map; // assign the map
        this.inv = inv; // assign the inventory

       // add(getContent());

    }


    public JScrollPane getContent() {

        // we have adapted the use of scroll bar with panels from the following link:
        // https://www.java-forums.org/awt-swing/10373-adding-multiple-panels-single-scroll-bar-jframe.html

        panel = new JPanel(new GridBagLayout());


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;


        readInventoryItems(); // read the properties of items from inventory


        // add item panels to the actual panel
        panel.add(corn, gbc);
        panel.add(strawberry, gbc);
        panel.add(sunflower, gbc);
        panel.add(tomato, gbc);
        panel.add(potato, gbc);

        panel.add(GMC, gbc);
        panel.add(fertilizer, gbc);


        scrollPane = new JScrollPane(panel);

        return scrollPane;

    } // getContent



    // read the recent data from inventory and assign them to the individual item panels

    private void readInventoryItems() {


        corn = new ItemPanel("Corn",
                inv.getCornCnt(),
                "+50 HP",               // health points
                inv.getCornSeedCnt(),   // count of seeds
                35,                     // purchase price
                40,                     // selling price
                100,                    // farmer's initial money
                this,                   // pass a reference to update the
                // store screen upon purchases/sellings
                map
        );


        strawberry = new ItemPanel("Strawberry",
                inv.getStrawBerryCnt(),         // food count
                "+100 HP",                      // health points
                inv.getStrawberrySeedCnt(),     // count of seeds
                45,                             // purchase price
                50,                             // selling price
                100,                            // farmer's initial money
                this,                            // pass a reference to update the
                // store screen upon purchases/sellings
                map
        );

        sunflower = new ItemPanel("Sunflower",
                inv.getSunFlowerCnt(),          // food count
                "+25 HP",                       // health points
                inv.getSunFlowerSeedCnt(),      // count of seeds
                5,                              // purchase price
                10,                             // selling price
                100,                            // farmer's initial money
                this,                            // pass a reference to update the
                // store screen upon purchases/sellings
                map
        );

        tomato = new ItemPanel("Tomato",
                inv.getTomatoCnt(),             // food count
                "+25 HP",                       // health points
                inv.getTomatoSeedCnt(),         // count of seeds
                15,                             // purchase price
                20,                             // selling price
                100,                            // farmer's initial money
                this,                            // pass a reference to update the
                // store screen upon purchases/sellings
                map
        );

        potato = new ItemPanel("Potato",
                inv.getPotatoCnt(),         // food count
                "+1 HP",                    // health points
                inv.getPotatoSeedCnt(),     // count of seeds
                25,                         // purchase price
                30,                         // selling price
                100,                        // farmer's initial money
                this,                        // pass a reference to update the
                // store screen upon purchases/sellings
                map
        );

        GMC = new ItemPanel("GMC",
                inv.getGMCcnt(),
                "<html><body style='width: 160px'>Seeds grow faster but worth less when sold.",
                -1,
                100,                        // price
                -1,
                100,                        // farmer's initial money
                this,                        // pass a reference to update the
                // store screen upon purchases/sellings
                map
        );

        fertilizer = new ItemPanel("Fertilizer",
                inv.getFertilizerCnt(),
                "<html><body style='width: 160px'>Seeds grow faster and worth more when sold.",
                -1,
                85,                         // price
                -1,
                100,                        // farmer's initial money
                this,                        // pass a reference to update the
                // store screen upon purchases/sellings
                map
        );

    }

    public void updateView() {

        // update comboboxes

        corn.updateComboboxes();
        strawberry.updateComboboxes();
        sunflower.updateComboboxes();
        tomato.updateComboboxes();
        potato.updateComboboxes();
        GMC.updateComboboxes();
        fertilizer.updateComboboxes();

        // update the actual panel

        panel.updateUI();
    }

}