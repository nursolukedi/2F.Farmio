/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Eray
 */
public class DrawPanel extends JPanel {
    
    
    private TileLayer layer;
    
    public DrawPanel() {
        
     //   layer = TileLayer.readTextFile("/home/demode29/IdeaProjects/2F.Farmio/src/map.txt");
        layer = new TileLayer(400,300);
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        layer.drawLayer(g);
        
    }
    
}
