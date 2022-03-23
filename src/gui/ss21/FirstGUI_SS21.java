package gui.ss21;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Summer Semester 2021
 *
 * @author Prof. Werner Burkard
 */
public class FirstGUI_SS21 implements ActionListener
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        FirstGUI_SS21 myFirstGUI_App = new FirstGUI_SS21();
        myFirstGUI_App.go();
    }

    public void go()
    {
        JFrame myFrame = new JFrame();
        String buttonText = "click me";
        JButton myButton = new JButton(buttonText);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //put button into the frame
        myFrame.getContentPane().add(myButton);
        myFrame.setSize(300, 300);
        myButton.addActionListener(this);
        myFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Autsch!!");
        JButton theEventThrower = (JButton) e.getSource();
        theEventThrower.setText("AHA");
    }
}
