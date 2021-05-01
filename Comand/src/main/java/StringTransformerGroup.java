import java.util.ArrayList;
import java.util.List;

public class StringTransformerGroup implements StringTransformer {

    List<StringTransformer> list = new ArrayList<>();

    StringTransformerGroup(List<StringTransformer> l)
    {
        list = l;
    }

    public void execute(StringDrink drink)
    {
        for(StringTransformer l : list)
            l.execute(drink);
    }
}
