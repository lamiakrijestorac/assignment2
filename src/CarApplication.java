void main() {
    // Instance of this class
    CarController carController = new CarController();

    // TODO uncomment, and adapt if necessary
    carController.cars.add(new Volvo240(0,0, 0, "pics/Volvo240.jpg"));
    carController.cars.add(new Saab95(100, 0, 1, "pics/Saab95.jpg"));


    // Start a new view and send a reference to the controller
    carController.frame = new CarView("CarSim 1.0", carController);
    carController.startTimer();
}