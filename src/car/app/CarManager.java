package car.app;

import car.data.Car;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prof. Werner Burkard
 */
public class CarManager
{

    private static CarManager theManager;
    private final ArrayList<Car> myCars;

    private CarManager()
    {
        // get the list of cars from class Car
        myCars = Car.getCarList();
    }

    public static CarManager getInstance()
    {
        if (theManager == null)
        {
            theManager = new CarManager();
        }
        return theManager;
    }

    public List<Car> getCars()
    {
        return myCars;
    }

    public void createSomeCars()
    {
        //adding 3 cars to the list of cars
        myCars.add(new Car(Car.getCarListNextID(), "BMW X1", 40000.0, false));
        Car.incrementCarListNextID();
        myCars.add(new Car(Car.getCarListNextID(), "Citroen C3", 17000.0, false));
        Car.incrementCarListNextID();
        myCars.add(new Car(Car.getCarListNextID(), "VW Up", 11000.0, true));
        Car.incrementCarListNextID();
    }

    public Car createCar()
    {
        // create an empty car 
        Car aCar = new Car(Car.getCarListNextID(), "please enter description", 0, false);
        return aCar;
    }

}
