package gammeloop;

/**
 *
 * @author Alexander Vondrous
 */
public class GammeLoopTester
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                GameGUI gameGui = new GameGUI();
                gameGui.setVisible(true);
                gameGui.startGame();
            }
        });

    }

}
