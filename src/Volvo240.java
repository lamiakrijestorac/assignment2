import java.awt.Color;

public class Volvo240 extends Car {

    private static final double TRIM_FACTOR = 1.0;//1.25;

    public Volvo240(int startPositionX, int startPositionY, int uniqID, String imagePath)
    {
        super(4, 100, Color.BLACK, "Volvo240", startPositionX, startPositionY, uniqID, imagePath);
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01 * TRIM_FACTOR;
    }
}
