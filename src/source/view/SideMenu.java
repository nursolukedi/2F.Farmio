package src.source.view;

import src.source.controller.FileManager;
import src.source.controller.GameManager;
import src.source.controller.MapManager;
import src.source.model.Map;
import src.source.model.SavedFile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SideMenu extends JPanel
{

    JButton saveButton;

    JButton exitButton;

    ArrayList<SavedFile> saved_files;


    public SideMenu(GameManager gameManager, GamePanel gamePanel)
    {
        saveButton = new JButton("Save Game");

        exitButton = new JButton("ExitGame");

        exitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                   //if exit button is selected. tells game manager to exit.
                   gameManager.exit();

                   JOptionPane.getRootFrame().dispose();
            }
        });

        saveButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // if save button is selected. Tells game manager to save that map to file
                saved_files = gameManager.saveGameDataToFile();

                //it is for null pointer exception error when user first clicks load game
                gamePanel.setFirstLoadGame();
            }

        });

        add(saveButton);

        add(exitButton);
    }

    public ArrayList<SavedFile> getSaved_files()
    {

        return saved_files;

    }

}
