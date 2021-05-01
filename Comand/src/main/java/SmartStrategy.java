import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy{

    List<StringDrink> drinkList = new ArrayList<>();
    List<StringRecipe> recipeList = new ArrayList<>();

    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar)
    {
        if(bar.isHappyHour()) {
            recipe.mix(drink);
        }
        else
        {
            drinkList.add(drink);
            recipeList.add(recipe);
        }
    }

    public void happyHourStarted(StringBar bar)
    {
        for(int i=0;i<drinkList.size();i++)
            wants(drinkList.get(i),recipeList.get(i),bar);
        recipeList.clear();
        drinkList.clear();
    }
    public void happyHourEnded(StringBar bar)
    {
    }
}
