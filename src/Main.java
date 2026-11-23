public class Main {

    public static void main(String[] args) {

        Volvo240 volvo = new Volvo240(0,0, 0, "");

        Saab95 saab = new Saab95(0,0, 1, "");

        // engine start
        volvo.startEngine();
        saab.startEngine();


        volvo.gas(1);
        saab.gas(1);

        // show current speed
        System.out.println(volvo.getCurrentSpeed());
        System.out.println(saab.getCurrentSpeed());

        // Saab turbo on
        saab.setTurboOn();
        saab.gas(1);

        System.out.println(saab.getCurrentSpeed());

        //Task 2: Movement
        //reset Saab current speed
        saab.startEngine();
        saab.gas(1);

        saab.turnRight();
        saab.move();

        System.out.println("Saab 95 X: " + saab.getX()); //With turbo
        System.out.println("Saab 95 Y: " + saab.getY()); //With turbo


        volvo.turnRight();
        volvo.move();

        System.out.println("Volvo240 X: " + volvo.getX());
        System.out.println("Volvo240 Y: " + volvo.getY());
    }
}