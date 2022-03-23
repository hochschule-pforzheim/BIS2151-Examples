package generic;

import java.util.Date;

/**
 * Summer Semester 2021
 *
 * @author Prof. Werner Burkard
 */
public class Speedtest
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("\nTesting the speed of the computer");
        System.out.println("Java Vrtual Machine has to loop 1 Billion times: 1.000.000.000");
        long a = 0, b = 1, c = 2;
        long numberOfLoops = 1000000000L; // ONE BILLION LOOPS, wow!
        Date now = new Date(); // get actual time
        long startMillis = now.getTime();
        System.out.println("Starting at: " + now + ", In Milliseconds: " + startMillis);
        // A little bit later...
        // Acually: No more statements
        for (int i = 0; i < numberOfLoops; i++)
        {
            a += 5;
            b += a + 2;
            c = a + b;
        }
        // How much time did it need to loop so many times?
        now = new Date(); // get actual time again!
        long endMillis = now.getTime();
        System.out.println("  Ending at: " + now + ", in Milliseconds: " + endMillis);

        System.out.println("\nTime needed for all the loops is " + (endMillis - startMillis) + " Milliseconds");
    }

}
