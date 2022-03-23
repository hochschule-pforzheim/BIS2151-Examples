package gammeloop;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexander Vondrous
 */
public class GameLoopThread extends Thread
{

    private GamePanel gamePanel;

    public boolean runGame = false;

    public GameLoopThread(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;
    }

    public void run()
    {
        runGame = true;
        while (runGame)
        {
            try
            {
                //System.out.println("sleep 100 ms");
                sleep(100);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(GameLoopThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            // TODO: change shape to rectangle after 100 iterations, then back to circle.
            gamePanel.updateGame();
        }
    }
}
