package gui.ws21;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

/**
 * Winter Semester 2021/22
 *
 * @author Prof. Werner Burkard
 */
public class GUIWS21221new extends JFrame implements ActionListener
{

    private String name;
    private JFrame petya;
    private JButton timm;
    private JButton sandra;
    private int luca = 0;     // counter for left label
    private int ivan = 0;     // counter for right label
    private JLabel marius;  // left label
    private JLabel alisa;   //right label

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        new GUIWS21221new().setVisible(true);

        //GUIWS21221new jennifer = new GUIWS21221new();
        //jennifer.setName("Jennifer");
        //jennifer.go();
    }

    public GUIWS21221new()
    {
        timm = new JButton("Timm: Leftclicker");  // create a first button
        sandra = new JButton("Sandra: Rightclicker");  // create a second button
        SouthListener theSouthListener = new SouthListener();
        NorthListener theNorthListener = new NorthListener();
        timm.addActionListener(theSouthListener);
        // setup window to close the app when it is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Jennifer");
        // put the button into the content pane of the frame
        Container linus = getContentPane();  // linus is the content pane...
        linus.add(BorderLayout.SOUTH, timm); // ... and now he gets Timm
        linus.add(BorderLayout.NORTH, sandra); // ... and now he gets Sandra
        // let us resize the frame
        setSize(300, 300);
        marius = new JLabel("Clicks left: " + luca);
        alisa = new JLabel("Clicks right: 0");
        // put these labels to the left / right part of petyas contentpane
        linus.add(BorderLayout.WEST, marius);
        linus.add(BorderLayout.EAST, alisa);
        // telling Timm that I am his listener
        timm.addActionListener(theSouthListener);
        sandra.addActionListener(theNorthListener);
        // let us make the frame visible
        petya.setVisible(true);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton theThrower = (JButton) e.getSource();
        if (theThrower == timm)
        {
            String newText = "Clicks left: " + ++luca;
            marius.setText(newText);
        }
        else // So it was Sandra!
        {
            String newText = "Clicks right: " + ++ivan;
            alisa.setText(newText);
        }
        //System.out.println("Hi, this is " + this.getName() + ": I got an event!");
    }

    // INNER CLASS for the listeners of Timm
    class SouthListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String newText = "Clicks left: " + ++luca;
            marius.setText(newText);
        }
    }

    class NorthListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String newText = "Clicks right: " + ++ivan;
            alisa.setText(newText);
        }

    }
}
