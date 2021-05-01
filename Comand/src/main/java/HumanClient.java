import org.graalvm.compiler.hotspot.phases.OnStackReplacementPhase_OptionDescriptors;

public class HumanClient implements Client {

    OrderingStrategy ordering;

    HumanClient(OrderingStrategy ord)
    {
        ordering = ord;
    }

    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar)
    {
        ordering.wants( drink,  recipe,  bar);
        bar.addObserver(this);
    }

    public void happyHourStarted(Bar bar)
    {
        ordering.happyHourStarted((StringBar)bar);
    }
    public void happyHourEnded(Bar bar)
    {
        ordering.happyHourEnded((StringBar)bar);
    }
}
