package src.source.view;

import src.source.model.*;

import java.awt.*;
import javax.swing.*;

public class PlayerInfoPanel extends JPanel
{
    private Map map;
    JLabel health, money;//labels for farmers money and health

    private ImageIcon icon;

    public PlayerInfoPanel(Map map)
    {
        this.map=map;
        setLayout(new FlowLayout());
        health = new JLabel("HEALTH: "+100, JLabel.LEFT);
        money = new JLabel("MONEY: "+100, JLabel.CENTER);
        add(health);
        add(money);//adding labels to panel

       icon = new ImageIcon("src/images/playerBackground.jpg");

    }


    public void updateLabel()
    {
        if(map.getFarmer().getFarmerHealth()<21) {//if players health is less than 21 it will make heath indicator red else balck
            health.setForeground(Color.red);
        }
        else{
            health.setForeground(Color.BLACK);
        }
        health.setText("HEALTH: "+map.getFarmer().getFarmerHealth());
        money.setText("MONEY: "+map.getFarmer().getFarmerMoney());//updating health and money
        repaint();
        updateUI();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

      //  g.drawImage(icon.getImage(),0,0,1000,15,null);

    }
}