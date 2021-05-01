import java.util.ArrayList;
import java.util.List;

public class StringBar extends Bar {
    boolean happyHour = false;

    public boolean isHappyHour() {return happyHour;};

    public void startHappyHour()
    {
        happyHour = true;
        this.notifyObservers();
    };
    public void endHappyHour()
    {
        happyHour = false;
        this.notifyObservers();
    };

    public void order(StringDrink drink, StringRecipe recipe)
    {
        recipe.mix(drink);
    }

}
