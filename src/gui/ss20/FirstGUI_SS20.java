package gui.ss20;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Summer Semester 2020
 *
 * @author Prof. Werner Burkard
 */
public class FirstGUI_SS20
{

    JLabel mylabelLeft, myLabelRight;
    int leftCounter;
    int rightCounter;
    JButton southButton, northButton;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        new FirstGUI_SS20().go();
    } // end of main

    // kernel method of our Gui1SS2020- Object
    public void go()
    {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        southButton = new JButton("Clickcounter left");
        northButton = new JButton("Clickcounter right");
        mylabelLeft = new JLabel("Clicks left side: 0");
        myLabelRight = new JLabel("Clicks right side: 0");
        frame.getContentPane().add(BorderLayout.SOUTH, southButton);
        frame.getContentPane().add(BorderLayout.NORTH, northButton);
        frame.getContentPane().add(BorderLayout.WEST, mylabelLeft);
        frame.getContentPane().add(BorderLayout.EAST, myLabelRight);
        frame.setSize(400, 400);
        southButton.addActionListener(new SouthListener());
        northButton.addActionListener(new NorthListener());
        frame.setVisible(true);
    }

    // Building of the inner classes for the listeners
    class SouthListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String updatedText;
            updatedText = "Clicks left side: " + ++leftCounter;
            mylabelLeft.setText(updatedText);
        }
    } // end of SouthListener

    class NorthListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String updatedText;
            updatedText = "Clicks right side: " + ++rightCounter;
            myLabelRight.setText(updatedText);
        }
    } // end of SouthListener

} // end of SimpleGui1    

