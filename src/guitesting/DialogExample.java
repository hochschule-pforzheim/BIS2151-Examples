package guitesting;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Prof. Werner Burkard
 */
public class DialogExample extends JFrame implements ActionListener
{

    /**
     *
     * @param args
     */
    public static void run(String[] args)
    {
        DialogExample wnd = new DialogExample();
        wnd.setSize(300, 200);
        wnd.setVisible(true);
    }

    public DialogExample()
    {
        super("dialog elements");
        setBackground(Color.lightGray);
        setLayout(new FlowLayout());
        // define Dialog-Button and End-Button
        JButton button = new JButton("dialog");
        button.addActionListener(this);
        add(button);
        button = new JButton("End");
        button.addActionListener(this);
        add(button);
        //Window-Listener
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent event)
            {
                event.getWindow().setVisible(false);
                event.getWindow().dispose();
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent event)
    {
        String cmd = event.getActionCommand();
        if (cmd.equals("Dialog"))
        {
            MyDialog dlg = new MyDialog(this);
            dlg.setVisible(true);
        }
        else if (cmd.equals("End"))
        {
            setVisible(false);
            dispose();
            System.exit(0);
        }
    }
}
