/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.OnDevelopmentStage;

import src.source.view.DrawPanel;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JFrame;

/**
 *
 * @author Eray
 */
public class main {
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("window");
        
      //  DrawPanel panel = new DrawPanel();
        
        frame.setSize(new Dimension(800, 600));
        
        // frame.setLocation(new Point(200, 200));
        
        frame.setLocationRelativeTo(null); // in the center
        
        frame.setResizable(false);
        
     //   frame.setContentPane(panel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
        
    }
    
}
