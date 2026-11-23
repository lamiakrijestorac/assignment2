import java.awt.*;

public class CarViewInfo
{
    public int uniqID;
    public Point position;
    public String imagePath;
    public CarViewInfo(int uniqID, Point position, String imagePath)
    {
        this.uniqID = uniqID;
        this.position = position;
        this.imagePath = imagePath;
    }
}