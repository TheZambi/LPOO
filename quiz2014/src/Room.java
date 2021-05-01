import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
import java.util.List;


public class Room implements Facility{
    Building building;
    String number;
    int floor;
    int capacity = 0;
    List<User> authorizedUsers = new ArrayList<>();

    public void authorize(User user)
    {
        authorizedUsers.add(user);
    }

    public Room(Building b, String s, int i) throws DuplicateRoomException {
        if(i<b.getMinFloor() || i>b.getMaxFloor())
            throw new IllegalArgumentException();
        for(Room str : b.getRooms())
            if(str.getNumber().equals(s))
                throw new DuplicateRoomException();
        this.building = b;
        this.number = s;
        this.floor = i;
        b.addRoom(this);
    }

    public Room(Building b, String s, int i, int cap) {
        if(i<b.getMinFloor() || i>b.getMaxFloor())
            throw new IllegalArgumentException();

        this.building = b;
        this.number = s;
        this.floor = i;
        this.capacity = cap;
        b.addCap(cap);
    }

    public int getCapacity() {
        return capacity;
    }

    public Building getBuilding() {
        return building;
    }

    public int getFloor() {
        return floor;
    }

    public String getNumber() {
        return number;
    }

    public String getName()
    {
        return this.building.getName() + this.getNumber();
    }

    @Override
    public String toString() {
        return "Room(" + this.building.getName() + "," + this.number + ")";
    }

    public boolean canEnter(User user)
    {
        for(User u : authorizedUsers)
        {
            if(u.equals(user))
                return true;
        }
        return false;
    }
}
