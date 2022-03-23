package guitesting;

/**
 *
 * @author Prof. Werner Burkard
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class MyDialog extends JDialog implements ActionListener
{

    public MyDialog(Frame parent)
    {
        super(parent, "MyDialog", true);
        Point parentLocation = parent.getLocation();
        setBounds(parentLocation.x + 30, parentLocation.y + 30, 400, 300);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        //make a panel and customize it. Then set it into my center
        JPanel panel = new JPanel();
        customizeLayout(panel);
        add(panel, BorderLayout.CENTER);
        //make an End button and tell him , that I am listening to his events!
        JButton button = new JButton("End");
        button.addActionListener(this);
        add(button, BorderLayout.SOUTH);  // put the button in the bottom of my display area
        //make a Window-Listener and configure me to know, that he listens to me and calles my endDialog()-method when invoked
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent event)
            {
                endDialog();
            }
        }
        );
        pack();
    }

    private void customizeLayout(JPanel panel)
    {
        // here, example code will be filled in. 
        // We use this method to test some of the widgets available in Java Swing ...
    }

    // The method to handle events when the End button was clicked (same as clicking the cross in right upper corner)
    public void actionPerformed(ActionEvent event)
    {
        if (event.getActionCommand().equals("End"))
        {
            endDialog();
        }
    }

    // The mmethod to handle events when the windowListener is triggered (user clicked the cross sign)
    private void endDialog()
    {
        setVisible(false);		// dialog sets itself unvisible
        dispose();			// disconnects from system
        ((Window) getParent()).toFront();	// brings parent window to foreground …
        getParent().requestFocus();		// … and gives back the focus to the parent window
    }
}
