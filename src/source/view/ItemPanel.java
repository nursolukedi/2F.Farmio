package src.source.view;

import src.source.model.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Individual panel for items in Store.
 * @author Eray
 */
public class ItemPanel extends JPanel {


    // GUI-related variables
    private JPanel actualPanel;
    private JButton sellCollected, buySeeds;
    private JLabel description, icon, itemName, moneyContribution, totalCost, quantityFood, quantitySeed;
    private JComboBox<String> foodCount, seedCount;



    private String name = "", descriptionOfItem = "";


    private int currentFoodCnt = 0, currentSeedCnt = 0; // (owned) current count of item

    private int sellingPrice = 0, purchasePrice = 0;

    private int tempSeedCnt = 0, tempFoodCnt = 0; // to be used in comboboxes



    StorePanel storePanel = null; // reference to StorePanel (to update upon changes)
    private Map map = null; // reference to Map
    private Inventory inv = null; // reference to Inventory (to read recent data)


    // constructor

    public ItemPanel(String name,    // name of the item
                     int currentFoodCnt,      // current count of it in inventory
                     String descriptionOfItem,// description (such as health points)
                     int currentSeedCnt,      // current count of the item's seeds
                     int purchasePrice,       // purchase price
                     int sellingPrice,        // selling price
                     int farmersMoney,        // farmersMoney
                     StorePanel storePanel,  // reference to StorePanel (to update the view)
                     Map map                 // reference to Map
    ) {

        // assign fields

        this.name = name;
        this.descriptionOfItem = descriptionOfItem;
        this.sellingPrice = sellingPrice;
        this.purchasePrice = purchasePrice;
        this.storePanel = storePanel;
        this.currentFoodCnt = currentFoodCnt;
        this.currentSeedCnt = currentSeedCnt;

        this.map = map;
        this.inv = map.getInventory();

        initComponents();

    }

    // read quantities of items from the inventory

    public void updateCountValues() {

        currentFoodCnt = inv.getFoodCnt(name);
        currentSeedCnt = inv.getSeedCnt(name);



        if (currentFoodCnt == 0) { // if you do not have food

            sellCollected.setEnabled(false); // you cannot sell anything
        }



        // currentSeedCnt is assigned to "-1" (invalid) to distinguish
        // between items (which have seeds and foods) and power-ups (which do not have those)

        if (currentSeedCnt != -1) { // if the current panel is NOT for a power-up


            // assign the "sell" button
            sellCollected.setText("Sell Collected (" + currentFoodCnt + " left)");

            // assign the "buy" button
            buySeeds.setText("Buy Seeds (" + currentSeedCnt + " left)");

        }

        else { // for a power-up

            buySeeds.setText("Buy (" + currentFoodCnt + " left)");

            sellCollected.setVisible(false); // no power-up can be sold
        }

    }


    // to update comboboxes upon purchase & sellings

    public void updateComboboxes() {


        updateFoodCombobox();

        updateSeedCombobox();

    }

    private void updateSeedCombobox() {

        // determine the number of items that can be afforded according to the
        // current money of the farmer

        int maxQuantity = (int) (map.getFarmer().getFarmerMoney() / purchasePrice);


        if (map.getFarmer().getFarmerMoney() < purchasePrice) { // if the farmer is poor to afford anything
            buySeeds.setEnabled(false); // buy button is disabled
        }
        else
            buySeeds.setEnabled(true); // otherwise, it is enabled



        String[] seedQuantity = new String[maxQuantity + 1];

        for (int i = 0; i <= maxQuantity; i++)
            seedQuantity[i] = "" + i;


        seedCount.setModel(new javax.swing.DefaultComboBoxModel<>(seedQuantity));
        seedCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seedCountActionPerformed(evt);
            }
        });

        seedCount.updateUI();

    }

    private void updateFoodCombobox() {

        if (currentSeedCnt != -1) { // if it is NOT a power-up

            String[] foodQuantity = new String[currentFoodCnt + 1];


            // available number of food
            // ranging from 0 to the current (owned) quantity

            for (int i = 0; i <= currentFoodCnt; i++)
                foodQuantity[i] = "" + i;


            // mouse click listener

            foodCount.setModel(new javax.swing.DefaultComboBoxModel<>(foodQuantity));
            foodCount.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    foodCountActionPerformed(evt);
                }
            });

            foodCount.updateUI(); // update the food count (upon changes to combobox)

        }
        else { // if it is a power-up

            foodCount.setVisible(false); // there is NOT food of power-ups (invisible)

        }

        // print the remaining money of the farmer

        System.out.println("Current Money: " + map.getFarmer().getFarmerMoney());

    }


    // to initialize values

    private void initComponents() {

        actualPanel = new JPanel();
        icon = new JLabel();
        itemName = new JLabel();
        description = new JLabel();
        sellCollected = new JButton();
        buySeeds = new JButton();
        foodCount = new JComboBox<>();
        seedCount = new JComboBox<>();
        quantityFood = new JLabel();
        quantitySeed = new JLabel();
        moneyContribution = new JLabel();
        totalCost = new JLabel();



        // icon.setIcon(new ImageIcon(getClass().getResource("/images/"
        //           + name + ".png"))); // NOI18N



        // set the name label
        itemName.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        itemName.setText(name);


        // set description
        description.setText(descriptionOfItem);


        updateComboboxes();


        if (currentSeedCnt != -1) { // if NOT a power-up

            sellCollected.setText("Sell Collected (" + currentFoodCnt + " left)");
            buySeeds.setText("Buy Seeds (" + currentSeedCnt + " left)");
            quantityFood.setText("quantity:");

        }

        else {  // if it is a power-up

            sellCollected.setVisible(false); // nothing can be sold
            quantityFood.setVisible(false); // no food of power-ups exist
            buySeeds.setText("Buy (" + currentFoodCnt + " left)");

        }


        sellCollected.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellCollectedActionPerformed(evt);
            }
        });

        buySeeds.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buySeedsActionPerformed(evt);
            }
        });


        if (currentFoodCnt == 0) {
            sellCollected.setEnabled(false);
        }

        if (currentSeedCnt == -1) // power-ups cannot be sold
            sellCollected.setVisible(false);


        quantitySeed.setText("quantity:");


        updateBillingCalculators(); // update cost/earnings calculations


        // GUI-related allignments

        javax.swing.GroupLayout actualPanelLayout = new javax.swing.GroupLayout(actualPanel);
        actualPanel.setLayout(actualPanelLayout);
        actualPanelLayout.setHorizontalGroup(
                actualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(actualPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addGroup(actualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(itemName, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(actualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(actualPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(sellCollected, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, actualPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(actualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(moneyContribution, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(actualPanelLayout.createSequentialGroup()
                                                                .addComponent(quantityFood)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(foodCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(actualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(actualPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buySeeds, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, actualPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(actualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(totalCost)
                                                        .addGroup(actualPanelLayout.createSequentialGroup()
                                                                .addComponent(quantitySeed)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(seedCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        actualPanelLayout.setVerticalGroup(
                actualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(actualPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(actualPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(actualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(itemName)
                                        .addComponent(sellCollected)
                                        .addComponent(buySeeds))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(actualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(actualPanelLayout.createSequentialGroup()
                                                .addGroup(actualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(foodCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(seedCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(quantityFood)
                                                        .addComponent(quantitySeed))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(actualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(moneyContribution)
                                                        .addComponent(totalCost)))
                                        .addGroup(actualPanelLayout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(description, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(actualPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(actualPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 30, Short.MAX_VALUE))
        );
        actualPanel.setSize(300, 70);
    }


    // determines the cost (or earnings) related with current choices of
    // items to buy (or sell)

    private void updateBillingCalculators() {

        updateEarningsCalc();
        updateCostCalc();
    }

    private void updateEarningsCalc() {

        // calculate the earnings amount when selling an item

        if ((String) foodCount.getSelectedItem() != null)
            tempFoodCnt = Integer.parseInt((String) foodCount.getSelectedItem());

        if (currentSeedCnt != -1)
            moneyContribution.setText("Brings " + tempFoodCnt *
                    sellingPrice + " coins.");
        else {
            moneyContribution.setVisible(false);
        }

    }

    private void updateCostCalc() {

        // calculate the cost when buying an item

        if ((String) seedCount.getSelectedItem() != null)
            tempSeedCnt = Integer.parseInt((String) seedCount.getSelectedItem());


        totalCost.setText("Costs " + tempSeedCnt *
                purchasePrice + " coins.");

    }

    private void sellCollectedActionPerformed(java.awt.event.ActionEvent evt) {

        // to display "Are you sure you want to sell this item?"

        Dialog confirmationBox = new Dialog("sell", map, name, tempSeedCnt, tempFoodCnt,
                purchasePrice, sellingPrice, this);

    }


    private void buySeedsActionPerformed(java.awt.event.ActionEvent evt) {

        // to display "Are you sure you want to buy this item?"
        Dialog confirmationBox = new Dialog("buy", map, name, tempSeedCnt, tempFoodCnt,
                purchasePrice, sellingPrice, this);

    }

    private void foodCountActionPerformed(java.awt.event.ActionEvent evt) {

        tempFoodCnt = 0;

        updateEarningsCalc();

    }

    public void resetFoodCount() {

        tempFoodCnt = 0;

        if (currentSeedCnt != -1)
            moneyContribution.setText("Brings " + tempFoodCnt *
                    sellingPrice + " coins.");
        else {
            moneyContribution.setVisible(false);
        }

    }


    private void seedCountActionPerformed(java.awt.event.ActionEvent evt) {

        tempSeedCnt = 0;

        updateCostCalc();

    }

    public void resetSeedCount() {

        tempSeedCnt = 0;

        totalCost.setText("Costs " + tempSeedCnt *
                purchasePrice + " coins.");

    }
}