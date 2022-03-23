package unimanager.appCenter;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Prof. Werner Burkard
 */
public class RoomManager
{

    private static RoomManager roomManager;  // one lonely Room  Manager
    private final ArrayList<Room> rooms = new ArrayList();  // all rooms we manage

    private RoomManager()
    {
    }

    public static RoomManager getTheRoomManager()
    {
        // this method returns the one existing room manager
        // if there is no room manager, then make one:
        if (roomManager == null)
        {
            roomManager = new RoomManager();  // this line is executed ONLY ONCE!
        }
        return roomManager;
    }

    // next methods implement all the jobs a Room-Manager has to do
    public void create15TestRooms()
    {
        // Creates 5 rooms for testing purposes
        rooms.add(new Room("W2.2.12", "Java-Lab", 25, "W2"));
        rooms.add(new Room("W2.2.02", "Lab02", 18, "W2"));
        rooms.add(new Room("W2.2.03", "Future-Lab", 9, "W2"));
        rooms.add(new Room("W2.2.26", "Office Burkard", 2, "W2"));
        rooms.add(new Room("W1.3.01", "Lecture hall", 40, "W1"));
        rooms.add(new Room("W1.4.01", "Lecture hall", 40, "W1"));
        rooms.add(new Room("W1.5.01", "Lecture hall", 20, "W1"));
        rooms.add(new Room("W1.3.04", "Lecture hall", 80, "W1"));
        rooms.add(new Room("W1.3.05", "Lecture hall", 80, "W1"));
        rooms.add(new Room("W1.3.06", "Lecture hall", 60, "W1"));
        rooms.add(new Room("W1.3.02", "Lecture hall", 60, "W1"));
        rooms.add(new Room("W1.4.03", "Lecture hall", 50, "W1"));
        rooms.add(new Room("W1.5.05", "Lecture hall", 80, "W1"));
        rooms.add(new Room("W1.4.05", "Lecture hall", 80, "W1"));
        rooms.add(new Room("W1.5.06", "Lecture hall", 25, "W1"));
    }

    public Room getRoom(String roomID)
    {
        // returns the room with ID <roomID> or null if it does NOT exist
        for (Room theRoom : rooms)
        {  // for all rooms in ArrayList rooms:
            if (theRoom.getId().equals(roomID))
            {
                return theRoom;   // we found that room!
            }
        }
        return null;         // room not found!
    }

    public ArrayList<Room> getRooms()
    {
        return rooms;
    }

    public void printAllRooms()
    {
        for (Room aRoom : rooms)
        {
            System.out.println(aRoom);
        }
    }

    public void delete(String deleteThisID)
    {
        // deletes the room with the ID: deleteThisID  
        String roomID;
        for (Room theRoom : rooms)
        {  // for all rooms in ArrayList rooms:
            roomID = theRoom.getId();
            if (roomID.equals(deleteThisID))
            { // we found that room!
                rooms.remove(theRoom);
                break; // no need for further loops!
            }
        }
    }

    public boolean addRoom(String theRoomID, String theDescription, int theCapacity, String theRoomBuilding)
    {
        Room newRoom = new Room(theRoomID, theDescription, theCapacity, theRoomBuilding);
        // if this room is NOT in ArrayList then add this room to the list
        if (getRoom(theRoomID) == null)
        {  // list does NOT contain this room ...
            rooms.add(newRoom);  // so it is added to  list of rooms
            return true;
        }
        else
        {
            return false;  // we do nothing and send <false> to the caller
        }
    }

    public void fillModel(DefaultTableModel tableModel)
    {
        for (Room aRoom : rooms)
        {
            tableModel.addRow(new Object[]
            {
                aRoom.getId(), aRoom.getDescription(), aRoom.getCapacity(), aRoom.getBuilding()
            });
        }
    }

    public boolean isValidRoomID(String aRoomID)
    {
        return !aRoomID.isBlank();  // accept all non-blank strings
    }

    public boolean isValidRoomDescription(String aDescription)
    {
        return !aDescription.isBlank();  // accept all non-blank strings
    }

    public boolean isValidRoomBuilding(String aBuilding)
    {
        return !aBuilding.isBlank();  // accept all non-blank strings
    }

    public int intValueOfCapacity(String aRoomCapacity)
    {
        // is aRoomCapacity representing a non-negative int value?
        // if yes: return that value
        // if no:  return -1
        if (aRoomCapacity == null)
        {
            return -1;
        }
        if (aRoomCapacity.isBlank())
        {
            return -1;
        }
        int theValue;
        try
        {
            theValue = Integer.parseInt(aRoomCapacity);
        }
        catch (Exception e)
        {
            theValue = -1;
        }
        if (theValue < 0)
        { // any negative value is set to -1!
            return -1;
        }
        // all is fine!
        return theValue;
    }

    public void updateDescription(String theRoomID, String newDescription)
    {
        // updates the description of the room with id:  theRoomID
        Room room = getRoom(theRoomID);
        if (room == null)
        {
            return;  // return if room does NOT exist
        }
        room.setDescription(newDescription);
    }

    public void updateBuilding(String theRoomID, String newData)
    {
        // updates the building of the room with id:  theRoomID
        Room room = getRoom(theRoomID);
        if (room == null)
        {
            return;  // return if room does NOT exist
        }
        room.setBuilding(newData);
    }

    public void updateCapacity(String theRoomID, int newData)
    {
        // updates the capacity of the room with id:  theRoomID
        Room room = getRoom(theRoomID);
        if (room == null)
        {
            return;  // return if room does NOT exist
        }
        room.setCapacity(newData);
    }
}
