import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Concert {
    int ticketNum=0;
    String city;
    String country;
    String date;
    List<Act> actList = new ArrayList<>();

    public Concert(String city, String country, String date) {
        this.city = city;
        this.country = country;
        this.date = date;
    }

    public void addAct(Act act) {
        this.actList.add(act);
    }

    public List<Act> getActs() {
        return this.actList;
    }

    public String getCity() {
        return city;
    }

    public String getDate() {
        return date;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return Objects.equals(city, concert.city) &&
                Objects.equals(country, concert.country) &&
                Objects.equals(date, concert.date) &&
                Objects.equals(actList, concert.actList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, date, actList);
    }

    public boolean isValid(Ticket ticket) {
        return this.equals(ticket.getConcert());
    }

    public boolean participates(Artist artist) {
        for(Act act : actList)
        {
            if(act instanceof Artist) {
                if (act.equals(artist))
                    return true;
            }
            else
                if(((Band)act).containsArtist(artist))
                    return true;

        }
        return false;
    }

    public int buyTicket() {
        this.ticketNum++;
        return this.ticketNum;
    }
}
