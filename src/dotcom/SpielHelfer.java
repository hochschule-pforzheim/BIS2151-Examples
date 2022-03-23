package dotcom;

/**
 *
 * @author Prof. Werner Burkard
 */
import java.io.*;
import java.util.*;

class SpielHelfer
{

    private static final String alphabet = "abcdefg";
    private int rasterLaenge = 7;
    private int rasterGroesse = 49;
    private int[] raster = new int[rasterGroesse];
    private int dotComAnzahl = 0;

    public String getBenutzereingabe(String prompt)
    {
        String eingabeZeile = null;
        System.out.print(prompt + "  ");
        try
        {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            eingabeZeile = is.readLine();
            if (eingabeZeile.length() == 0)
            {
                return null;
            }
        }
        catch (IOException e)
        {
            System.out.println("IOException: " + e);
        }
        return eingabeZeile.toLowerCase();
    }

    public ArrayList<String> platziereDotCom(int dotComGroesse)
    {
        ArrayList<String> alphaZellen = new ArrayList<String>();
        String[] alphaKoordinaten = new String[dotComGroesse];
        String temp = null;
        int[] koordinaten = new int[dotComGroesse];
        int versuche = 0;
        boolean erfolg = false;
        int ort = 0;

        dotComAnzahl++;
        int inkrement = 1;
        if ((dotComAnzahl % 2) == 1)
        {
            inkrement = rasterLaenge;
        }

        while (!erfolg & versuche++ < 200)
        {
            ort = (int) (Math.random() * rasterGroesse);
            //System.out.print(" Versuche " + ort);
            int x = 0;
            erfolg = true;
            while (erfolg && x < dotComGroesse)
            {
                if (raster[ort] == 0)
                {
                    koordinaten[x++] = ort;
                    ort += inkrement;
                    if (ort >= rasterGroesse)
                    {
                        erfolg = false;
                    }
                    if (x > 0 & (ort % rasterLaenge == 0))
                    {
                        erfolg = false;
                    }
                }
                else
                {
                    // System.out.print(" verwendet " + ort);
                    erfolg = false;
                }
            }
        }

        int x = 0;
        int zeile = 0;
        int spalte = 0;
        // System.out.println("\n");
        while (x < dotComGroesse)
        {
            raster[koordinaten[x]] = 1;
            zeile = (int) (koordinaten[x] / rasterLaenge);
            spalte = koordinaten[x] % rasterLaenge;
            temp = String.valueOf(alphabet.charAt(spalte));

            alphaZellen.add(temp.concat(Integer.toString(zeile)));
            x++;

            // System.out.print("  Koordinaten "+x+" = " + alphaZellen.get(x-1));
        }
        // System.out.println("\n");

        return alphaZellen;
    }
}
