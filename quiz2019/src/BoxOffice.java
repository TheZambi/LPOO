import java.util.ArrayList;
import java.util.List;

public class BoxOffice {
    public static List<Ticket> buy(Concert concert, int nTicks) throws InvalidTicket {
        List<Ticket> ret = new ArrayList<>();
        for(int i = 0 ; i < nTicks ; i++)
        {
            ret.add(new Ticket(concert.buyTicket(),concert));
        }
        return ret;
    }
}
