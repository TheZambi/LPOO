public class ImpatientStrategy implements OrderingStrategy {
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar)
    {
        recipe.mix(drink);
    }

    public void happyHourStarted(StringBar bar)
    {
    }
    public void happyHourEnded(StringBar bar)
    {
    }
}
