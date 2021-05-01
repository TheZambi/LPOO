import java.util.ArrayList;
import java.util.List;

public class StringRecipe {
    List<StringTransformer> list = new ArrayList<>();

    StringRecipe(List<StringTransformer> l)
    {
        list = l;
    }

    void mix(StringDrink drink)
    {
        for(StringTransformer t : list)
        {
            t.execute(drink);
        }
        System.out.println(drink.getText());
    }

}
