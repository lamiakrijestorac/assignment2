import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController
{
    // The delay (ms) corresponds to 20 updates/second (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // TODO A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    public void startTimer()
    {
        if (!timer.isRunning())
        {
            timer.start();
        }
    }

    public void stopTimer()
    {
        this.timer.stop();
    }


    /* Each step, the TimerListener moves all cars in the list and tells the
     * view to update its images. TODO Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars)
            {
                if (car.getY() < 0 ||
                        car.getX() < 0 ||
                        car.getY() + frame.drawPanel.getDimension(car.getUniqID()).height > frame.drawPanel.getHeight() ||
                        car.getX() + frame.drawPanel.getDimension(car.getUniqID()).width > frame.drawPanel.getWidth())
                {
                    car.turnRight();
                    car.turnRight();
                    car.move();
                    int x = (int) Math.round(car.getX());
                    int y = (int) Math.round(car.getY());
                    frame.drawPanel.moveit(x, y, car.getUniqID());

                    // repaint() calls the paintComponent method of the panel
                    frame.drawPanel.revalidate();
                    frame.drawPanel.repaint();
                }
                else
                {
                    car.move();
                    int x = (int) Math.round(car.getX());
                    int y = (int) Math.round(car.getY());
                    frame.drawPanel.moveit(x, y, car.getUniqID());

                    // repaint() calls the paintComponent method of the panel
                    frame.drawPanel.revalidate();
                    frame.drawPanel.repaint();
                }
            }
        }
    }

    void gas(int amount)
    {
        double gas = ((double) amount) / 100;
        for (Car car : cars)
        {
            car.gas(gas);
        }
    }

    void brake(double amount)
    {
        double brake = ((double) amount) / 100;
        for (Car car : cars)
        {
            car.brake(brake);
        }
    }

    void turnRight()
    {
        for (Car car : cars)
        {
            car.turnRight();
        }
    }

    void turnLeft()
    {
        for (Car car : cars)
        {
            car.turnLeft();
        }
    }

    void setTurboOn()
    {
        for (Car car : cars)
        {
          if (car instanceof Saab95 saab95)
          {
              saab95.setTurboOn();
          }
        }
    }

    void setTurboOff()
    {
        for (Car car : cars)
        {
            if (car instanceof Saab95 saab95)
            {
                saab95.setTurboOff();
            }
        }
    }
}
