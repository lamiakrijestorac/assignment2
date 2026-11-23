public class CarTest {
    private static void reportResult(String testName, boolean success) {
        IO.println((success ? "SUCCESS: " : "FAILURE: ") + testName);
    }

    /** Tests whether a Saab95 with turbo enabled
     *  gains more speed than one without.
     */
    private static void testTurbo() {
        Saab95 slowSaab = new Saab95(0,0, 0, "");
        Saab95 fastSaab = new Saab95(0,0, 1, "");

        fastSaab.setTurboOn();
        slowSaab.setTurboOff();
        fastSaab.gas(0.5);
        slowSaab.gas(0.5);
        boolean result = slowSaab.getCurrentSpeed() < fastSaab.getCurrentSpeed();

        if (result == true) {
            reportResult("Turbo yields more speed", result);
        } else if (result == false) {
            reportResult("Turbo does not increase speed", result);
        }
    }

    private static void testTurboOffNormalizesSpeed() {
        Saab95 saab = new Saab95(0, 0, 0, "");
        Volvo240 volvo = new Volvo240(0, 0, 1, "");
        saab.startEngine();
        volvo.startEngine();

        saab.setTurboOn();
        boolean turboIncreasesSpeed = saab.getCurrentSpeed() > volvo.getCurrentSpeed();

        saab.gas(0.5);
        volvo.gas(0.5);
        saab.setTurboOff();
        double normalSpeed = saab.getCurrentSpeed();
        boolean normalized = Math.abs(normalSpeed - volvo.getCurrentSpeed()) < 1e-9;

        saab.setTurboOff();
        boolean repeatedOffIsSafe = Math.abs(saab.getCurrentSpeed() - normalSpeed) < 1e-9;

        saab.setTurboOn();
        double turboSpeed = saab.getCurrentSpeed();
        saab.setTurboOn();
        boolean repeatedOnIsSafe = Math.abs(saab.getCurrentSpeed() - turboSpeed) < 1e-9;
        saab.setTurboOff();

        reportResult("Turbo toggles speed and restores normal speed",
                turboIncreasesSpeed && normalized && repeatedOffIsSafe
                        && repeatedOnIsSafe
                        && Math.abs(saab.getCurrentSpeed() - volvo.getCurrentSpeed()) < 1e-9);
    }

    private static void testVolvoSpeed() {
        Volvo240 volvo = new Volvo240(0,0, 0, "");

        volvo.startEngine();
        volvo.gas(1);

        boolean result = volvo.getCurrentSpeed() == 1.35;

        //Testing
        if (result == true) {
            reportResult("Volvo accelerates correctly", result);
        } else if (result == false) {
            reportResult("Volvo accelerates incorrectly", result);
        }
    }

    private static void testBrakes() {
        Volvo240 volvo1 = new Volvo240(0,0, 0, "");
        Volvo240 volvoBrake = new Volvo240(0,0, 1, "");

        volvo1.startEngine();
        volvo1.gas(1);
        volvo1.getCurrentSpeed();

        volvoBrake.startEngine();
        volvoBrake.gas(1);
        volvoBrake.brake(0.5);
        volvoBrake.getCurrentSpeed();

        boolean result = volvo1.getCurrentSpeed() > volvoBrake.getCurrentSpeed();

        //Testing
        if (result == true) {
            reportResult("Brakes work", result);
        } else if (result == false) {
            reportResult("Brakes do not work", result);
        }
    }

    private static void testMove() {
        Volvo240 volvo = new Volvo240(0,0, 0, "");

        volvo.startEngine();
        volvo.turnRight(); //East
        volvo.move();

        /* && -> "and"
         * Checking if it actually changes directions,
         * if it did then x > 0
         * */
        boolean result = volvo.getX() > 0 && volvo.getY() == 0;

        //Testing
        if (result == true) {
            reportResult("Turned right", result);
        } else if (result == false) {
            reportResult("Did not turn right", result);
        }
    }
    static void main() {
        testTurbo();
        testTurboOffNormalizesSpeed();
        testVolvoSpeed();
        testBrakes();
        testMove();
    }
}
