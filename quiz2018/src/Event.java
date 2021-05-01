import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Event {
    String title;
    String date;
    String description;
    List<Person> audience = new ArrayList<>();

    public Event(String title) {
        this.title = title;
        this.date = "";
        this.description = "";
    }

    public Event(String title, String date) {
        this.title = title;
        this.date = date;
        this.description = "";
    }

    public Event(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public Event(Event e) {
        this.title = e.getTitle();
        this.description = e.getDescription();
        this.date = e.getDate();
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.getTitle() + " is a " + getDescription() + " and will be held at " + this.getDate() + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(title, event.title) &&
                Objects.equals(date, event.date) &&
                Objects.equals(description, event.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, date, description);
    }


    public void addPerson(Person person) {
        for(Person p : audience)
            if(p.getName().equals(person.getName())) return;
        this.audience.add(person);
    }

    public int getAudienceCount() {
        return audience.size();
    }
}
