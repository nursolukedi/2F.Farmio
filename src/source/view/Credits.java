package src.source.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Credits extends JPanel
{
    public Credits(JPanel contentPanel, CardLayout cards)
    {

        JTextPane textPane = new JTextPane();
        textPane.setText( "Demir Topaktaş\n Fuad Ahmed\n Nursena Kal\n Eray Şahin" );

        add(textPane);

        JButton returnButton = new JButton("Return To Menu");

        returnButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                cards.show(contentPanel,"main");
            }
        } );

        add(returnButton);


    }

}
