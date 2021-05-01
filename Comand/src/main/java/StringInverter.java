public class StringInverter implements StringTransformer{
    public void execute(StringDrink drink)
    {
        String aux = "";
        for(Integer i=drink.getText().length()-1; i>=0;i--)
        {
            aux+=drink.getText().charAt(i);
        }
        drink.setText(aux);
    }

    public void undo(StringDrink drink)
    {
        execute(drink);
    }
}
