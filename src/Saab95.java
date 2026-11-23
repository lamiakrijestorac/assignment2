import java.awt.Color;

public class Saab95 extends Car {

        private static final double TURBO_FACTOR = 1.3;
        private boolean turboOn;

        public Saab95(int startPositionX, int startPositionY, int uniqID, String imagePath)
        {
            super(2, 100,
                    Color.RED, "Saab95", startPositionX, startPositionY, uniqID, imagePath);
            turboOn = false;
        }

        public void setTurboOn()
        {
            if (!turboOn) {
                scaleCurrentSpeed(TURBO_FACTOR);
                turboOn = true;
            }
        }

        public void setTurboOff()
        {
            if (turboOn) {
                scaleCurrentSpeed(1 / TURBO_FACTOR);
                turboOn = false;
            }
        }

        @Override
        protected double speedFactor()
        {
            double turbo = 1;

            if (turboOn)
            {
                turbo = TURBO_FACTOR;
            }

            return getEnginePower() * 0.01 * turbo;
        }
    }
