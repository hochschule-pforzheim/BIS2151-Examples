package gammeloop;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Alexander Vondrous
 */
public class GamePanel extends JPanel
{

    public int x = 100;
    public int y = 250;

    public int directionX = 10;
    public int directionY = 10;

    public GamePanel()
    {
        setSize(500, 500);
    }

    @Override
    public void paint(Graphics g)
    {
        g.clearRect(0, 0, 500, 500);

        g.drawOval(x, y, 50, 50);
        //System.out.println("paint");
    }

    public void updateGame()
    {
        x += directionX;
        y += directionY;

        if (x >= 450 || x <= 0)
        {
            directionX *= -1;
        }

        if (y >= 450 || y <= 0)
        {
            directionY *= -1;
        }

        this.repaint();
        //System.out.println("updateGame");
    }

}
