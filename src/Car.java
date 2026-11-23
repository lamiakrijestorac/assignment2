import java.awt.Color;

public abstract class Car implements Movable {

    private int nrDoors; // nmbr of car doors
    private double enginePower; // car engine power
    private double currentSpeed; // car current speed
    private Color color; // car color
    private String modelName; // car model
    private int uniqID;
    private String imagePath;

    public Car(int nrDoors, double enginePower,
               Color color, String modelName, int startPositionX, int startPositionY, int uniqID, String imagePath)
    {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.x = startPositionX;
        this.y = startPositionY;
        this.uniqID = uniqID;
        this.imagePath = imagePath;

        stopEngine();
    }

    //Getters


    public String getImagePath()
    {
        return imagePath;
    }

    public int getUniqID()
    {
        return uniqID;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    protected void scaleCurrentSpeed(double factor) {
        currentSpeed *= factor;
    }

    public Color getColor() {
        return color;

    }

    public String getModelName() {
        return modelName;
    }

    //Setter
    public void setColor(Color color) {
        this.color = color;
    }

    //Engine
    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    //abstract --> each subclass gives its own speedfactor()
    protected abstract double speedFactor();

    //New speed = CurrentSpeed(0.1) + SpeedFactor(1.25) * Amount(10)
    private void incrementSpeed(double amount) {
        double newSpeed = currentSpeed + speedFactor() * amount;

        //T4
        if (newSpeed > enginePower) {
            currentSpeed = enginePower; //speed cannot exceed enginepower
        } else {
            currentSpeed = newSpeed;
        }
    }


    private void decrementSpeed(double amount) {
        double newSpeed = currentSpeed - speedFactor() * amount;

        if (newSpeed < 0){
            currentSpeed = 0;
        } else {
            currentSpeed = newSpeed;
        }
    }


    //Public methods
    public void gas(double amount) {
        //T4 Sanity Checks
        if (amount < 0 || amount > 1) {
            return; //stops the method, if amount is invalid -> method do nothing
        }
        incrementSpeed(amount);
    }

    public void brake(double amount) {
        //T4
        if (amount < 0 || amount > 1) {
            return; //stops the method, if amount is invalid -> method do nothing
        }
        decrementSpeed(amount);

    }

    //Task 2
    //Movable
    private double x;
    private double y;
    private int direction;

    //@Override
    public void turnRight()
    {
        direction = (direction + 1) % 4;
    }

    //@Override
    public void turnLeft()
    {
        direction = (direction + 3) % 4;

        //Add 3 instead of sub 1 --> never becomes negative
    }

    //@Override
    public void move()
    {
        if (direction == 0)
        {
            y += getCurrentSpeed(); // same as y = y + getCurrentSpeed()
            //North
        } else if (direction == 1) {
            x += getCurrentSpeed();
            //East
        } else if (direction == 2) {
            y -= getCurrentSpeed(); // same as y = y - getCurrentSpeed()
            //South
        } else if (direction == 3) {
            x -= getCurrentSpeed();
            //West
        }
    }

    //Getters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    }
