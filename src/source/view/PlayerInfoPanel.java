package src.source.view;

import src.source.model.*;

import java.awt.*;
import javax.swing.*;

public class PlayerInfoPanel extends JPanel
{
    private Map map;
    JLabel health, money;//labels for farmers money and health

    private ImageIcon icon;

    public PlayerInfoPanel()
    {
        setLayout(new FlowLayout());

        health = new JLabel();
        money = new JLabel();

        add(health,FlowLayout.LEFT);
        add(money, FlowLayout.CENTER);//adding labels to panel

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
    }


    public void setMap(Map map)
    {
        this.map = map;
        health.setText("HEALTH: "+map.getFarmer().getFarmerHealth());
        money.setText("MONEY: "+map.getFarmer().getFarmerMoney());
    }


    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }
}