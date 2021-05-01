public class StringReplacer implements StringTransformer {
    char toRep, repWith;

    StringReplacer(char t, char r)
    {
        toRep = t;
        repWith = r;
    }

    public void execute(StringDrink drink)
    {
//        String r = "";
//        for(int i=0; i< drink.getText().length();i++)
//        {
//            if(toRep == drink.getText().charAt(i))
//                r += repWith;
//            else
//                r += drink.getText().charAt(i);
//        }
        drink.setText(drink.getText().replace(toRep,repWith));
    }

    public void undo(StringDrink drink)
    {
        drink.setText(drink.getText().replace(repWith,toRep));
    }
}
