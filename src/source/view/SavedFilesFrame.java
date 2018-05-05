package src.source.view;

import src.source.model.SavedFile;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SavedFilesFrame
{
    private JFrame jFrame;

    private JPanel jPanel;

    private JScrollPane scrollPane;

    private ArrayList<SavedFile> savedFiles;

    private int current_index;

    private GamePanel gamePanel;


    public SavedFilesFrame(GamePanel gamePanel)
    {
        jFrame = new JFrame("Saved Files");

        this.gamePanel = gamePanel;

        jFrame.setLayout(new FlowLayout());

        jPanel = new JPanel();

        scrollPane = new JScrollPane(jPanel,JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        jFrame.add(scrollPane);

        jFrame.setSize(200,200);

        jFrame.setVisible(true);
    }


    //this function adds buttons for saved files. When user clicks that button specific file will be loaded and opened
    public void updatePanel(ArrayList<SavedFile> savedFiles)
    {
        this.savedFiles = savedFiles;

        System.out.println("Saved");

        for (int i = 0; i < savedFiles.size(); i++)
        {
            SavedFile savedFile = savedFiles.get(i);
            JButton newButton = new JButton("" + savedFile.getCurrent_index());
            newButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    currentSelectedFile(savedFile.getCurrent_index());

                    gamePanel.setMap();

                    gamePanel.startManagerGameLoop(true);

                    jFrame.setVisible(false);

                    gamePanel.returnGame();
                }

            });

            jFrame.add(newButton);
            jFrame.validate();
            jFrame.repaint();
        }
    }

    public void currentSelectedFile(int index)
    {
        this.current_index = index;
    }

    public int getCurrent_index()
    {
        return current_index;
    }

}
