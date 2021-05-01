import java.util.ArrayList;
import java.util.List;

public class Party extends Event{
    List<Event> events = new ArrayList<>();
    public Party(String location, String date, String description) {
        super(location,date,description);
    }

    public void addEvent(Event e) {
        this.events.add(e);
    }

    public int getAudienceCount() {
        int total = 0;
        for(Event e : events)
            total+=e.getAudienceCount();
        return this.audience.size() + total;
    }
}
