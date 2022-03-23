package car.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Prof. Werner Burkard
 */
public class Car implements Serializable
{

    // a store for all cars
    private static ArrayList<Car> cars = new ArrayList<>();
    private static int carListNextID = 1;

    private int carID;
    private String carDescription;
    private double carPrice;
    private boolean available;

    @Override
    public boolean equals(Object c)
    {
        if (c == null)
        {
            return false;
        }
        if (!(c instanceof Car))
        {
            return false;
        }
        // Now we know: c is a car!
        Car aCar = (Car) c;
        if (this.carID != aCar.carID)
        {
            return false;
        }
        if (!this.carDescription.equals(aCar.carDescription))
        {
            return false;
        }
        if (this.carPrice != aCar.carPrice)
        {
            return false;
        }

        // now everything is identical, so we say it is equal
        return true;
    }

    public static ArrayList<Car> getCarList()
    {
        return cars;
    }

    public static int getCarListNextID()
    {
        return carListNextID;
    }

    public static void incrementCarListNextID()
    {
        Car.carListNextID++;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public void setAvailable(boolean available)
    {
        this.available = available;
    }

    public int getCarID()
    {
        return carID;
    }

    public void setCarID(int carID)
    {
        this.carID = carID;
    }

    public String getCarDescription()
    {
        return carDescription;
    }

    public void setCarDescription(String carDescription)
    {
        this.carDescription = carDescription;
    }

    public double getCarPrice()
    {
        return carPrice;
    }

    public void setCarPrice(double carPrice)
    {
        this.carPrice = carPrice;
    }

    public Car(int carID, String carDescription, double carPrice, boolean available)
    {
        this.carID = carID;
        this.carDescription = carDescription;
        this.carPrice = carPrice;
        this.available = available;
    }

    public static void saveCars()
    {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try
        {
            fos = new FileOutputStream("carData.ser", false);
            out = new ObjectOutputStream(fos);

            out.writeObject(cars);

            //for (Car aCar:cars){
            //    out.writeObject(aCar);
            //}
            //out.writeObject(null);
            out.close();
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();

        }
    }

    public static void readCars()
    {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        Car aCar;
        try
        {
            fis = new FileInputStream("carData.ser");
            in = new ObjectInputStream(fis);

            cars = (ArrayList<Car>) in.readObject();
            /*
            while ((aCar = (Car) in.readObject()) != null) {
                cars.add(aCar);
                System.out.println(aCar.getCarID() + " " + aCar.getCarDescription());
            }  */

        }
        catch (FileNotFoundException ex)
        {
            System.out.println("No cars actually in store");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

}
