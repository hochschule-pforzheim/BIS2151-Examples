package gammeloop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Alexander Vondrous
 */
public class GameGUI extends JFrame
{

    private GamePanel gamePanel = new GamePanel();
    private JButton stopButton = new JButton("Stop");
    private GameLoopThread gameLoopThread;

    public GameGUI()
    {
        this.setSize(600, 600);
        this.add(gamePanel);
        this.gameLoopThread = new GameLoopThread(gamePanel);
        this.add(stopButton);

        stopButton.addActionListener(new StopGame());
    }

    class StopGame implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent arg0)
        {
            if (stopButton.getText().equalsIgnoreCase("Stop"))
            {
                stopGame();
                stopButton.setText("Start");
            }
            else
            {
                startGame();
                stopButton.setText("Stop");
            }

        }

    }

    public void startGame()
    {
        this.gameLoopThread.start();
    }

    public void stopGame()
    {
        this.gameLoopThread.runGame = false;
        this.gameLoopThread = new GameLoopThread(gamePanel);
    }
}
