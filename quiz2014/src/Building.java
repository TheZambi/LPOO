import java.util.ArrayList;
import java.util.List;

public class Building implements Facility {
    String name;
    int minFloor;
    int maxFloor;
    int capacity = 0;
    List<Room> rooms = new ArrayList<>();
    List<User> authorizedUsers = new ArrayList<>();

    public void authorize(User user)
    {
        authorizedUsers.add(user);
    }

    public Building(String name, int min, int max) throws Exception{
        if(max<min) {
            throw new IllegalArgumentException();
        }
        this.name=name;
        this.maxFloor=max;
        this.minFloor=min;
    }

    public Building(String name, int min, int max, int cap) throws Exception{
        if(max<min) {
            throw new IllegalArgumentException();
        }
        this.name=name;
        this.maxFloor=max;
        this.minFloor=min;
        this.capacity = cap;
    }

    public String getName() {
        return name;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public int getMinFloor() {
        return minFloor;
    }

    @Override
    public String toString() {
        return "Building(" + this.name + ")";
    }

    public int getCapacity() {
        return capacity;
    }

    public void addCap(int cap)
    {
        this.capacity += cap;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room)
    {
        this.rooms.add(room);
    }

    public boolean canEnter(User user)
    {
        for(Room room : rooms) {
            if (room.canEnter(user))
                return true;
        }
        return false;
    }
}
