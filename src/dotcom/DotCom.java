package dotcom;

import java.util.ArrayList;

/**
 *
 * @author Prof. Werner Burkard
 */
class DotCom
{

    String name;
    ArrayList<String> zellorte;

    public String pruefDich(String zellorte)
    {
        // Still to do
        return zellorte;
    }

    public DotCom()
    {
    }

    public DotCom(String name, ArrayList<String> zellorte)
    {
        this.name = name;
        this.zellorte = zellorte;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ArrayList<String> getZellorte()
    {
        return zellorte;
    }

    public void setZellorte(ArrayList<String> zellorte)
    {
        this.zellorte = zellorte;
    }

}
