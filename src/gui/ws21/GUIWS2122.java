package gui.ws21;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Winter Semester 2021/22
 *
 * @author Prof. Werner Burkard
 */
public class GUIWS2122 extends JFrame
{

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
        new GUIWS2122().setVisible(true);  // create an ANONYMOUS object and set it visible
    }

    public GUIWS2122()
    {
        timm = new JButton("Timm Leftclicker");  // create a first button
        sandra = new JButton("Sandra Rightclicker");  // create a second button
        SouthListener maren = new SouthListener();
        timm.addActionListener(maren);
        NorthListener johannes = new NorthListener();
        sandra.addActionListener(johannes);
        // setup window to close the app when it is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Petya&Jennifer");
        // put the button into the content pane of the frame
        Container linus = getContentPane();  // linus is the content pane...
        linus.add(BorderLayout.SOUTH, timm); // ... and now he gets Timm
        linus.add(BorderLayout.NORTH, sandra); // ... and now he gets Sandra
        // let us resize the frame
        setSize(300, 300);
        marius = new JLabel("Marius Clicks left: " + luca);
        alisa = new JLabel("Alisa Clicks right: 0");
        // put these labels to the left / right part of petyas contentpane
        linus.add(BorderLayout.WEST, marius);
        linus.add(BorderLayout.EAST, alisa);
    }

    // a method to handle Timm's events
    private void timmsEventsHandledNow(ActionEvent e)
    {
        String newText = "Marius Clicks left: " + ++luca;
        marius.setText(newText);

    }

    // a method to handle Sandra's events
    private void sandrasEventsHandledNow(ActionEvent e)
    {
        String newText = "Alisa Clicks right: " + ++ivan;
        alisa.setText(newText);
    }

    // let us build inner classe SouthListener for the event handling from timm
    class SouthListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            timmsEventsHandledNow(e);
        }
    }

    // let us build inner classe NorthListener for the event handling from sandra
    class NorthListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            sandrasEventsHandledNow(e);
        }

    }
}
