import java.util.ArrayList;
import java.util.List;

public class Band implements Act{
    String name;
    String country;
    List<Artist> artists = new ArrayList<>();

    public Band(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public void addArtist(Artist artist) {
        this.artists.add(artist);
    }

    public List<Artist> getArtists() {
        return this.artists;
    }

    public boolean containsArtist(Artist artist) {
        for(Artist art : artists)
            if(art.equals(artist))
                return true;
        return false;
    }
}
