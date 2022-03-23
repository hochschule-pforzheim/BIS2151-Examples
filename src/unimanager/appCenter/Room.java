package unimanager.appCenter;

/**
 *
 * @author Prof. Werner Burkard
 */
public class Room
{

    //features of a room
    String id;
    String description;
    int capacity;
    String building;

    public Room(String id, String description, int capacity, String building)
    {
        this.id = id;
        this.description = description;
        this.capacity = capacity;
        this.building = building;
    }

    @Override
    public String toString()
    {
        return "Room{" + "id=" + id + ", description=" + description + ", capacity=" + capacity + ", building=" + building + '}';
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    public String getBuilding()
    {
        return building;
    }

    public void setBuilding(String building)
    {
        this.building = building;
    }
}
