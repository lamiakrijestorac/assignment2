import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel
{
    ArrayList<CarViewInfo> carViewInfoArrayList;

    // TODO: Make this general for all cars
    void moveit(int x, int y, int uniqID)
    {
        for (CarViewInfo carViewInfo :  this.carViewInfoArrayList)
        {
            if (carViewInfo.uniqID == uniqID)
            {
                carViewInfo.position.x = x;
                carViewInfo.position.y = y;
            }
        }
    }

    public Dimension getDimension(int uniqID)
    {
        for (CarViewInfo carViewInfo :  this.carViewInfoArrayList)
        {
            if (carViewInfo.uniqID == uniqID)
            {
                try
                {
                    BufferedImage image = ImageIO.read(DrawPanel.class.getResourceAsStream(carViewInfo.imagePath));
                    return new Dimension(image.getWidth(), image.getHeight());
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        return new Dimension(0, 0);
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<CarViewInfo> carViewInfoArrayList)
    {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.carViewInfoArrayList = carViewInfoArrayList;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for (CarViewInfo carViewInfo :  this.carViewInfoArrayList)
        {
            try
            {
                BufferedImage image = ImageIO.read(DrawPanel.class.getResourceAsStream(carViewInfo.imagePath));
                g.drawImage(image, carViewInfo.position.x, carViewInfo.position.y, null);
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
