public class FiguraComposta implements Figura, Countable{
    Figura[] figuras;

    public FiguraComposta(Figura[] figuras) {
        this.figuras = figuras;
    }

    @Override
    public double getArea() {
        double total=0;
        for(Figura fig : figuras)
            total += fig.getArea();
        return total;
    }

    @Override
    public double getPerimetro() {
        double total=0;
        for(Figura fig : figuras)
            total += fig.getPerimetro();
        return total;
    }

    @Override
    public int count() {
        int count=0;
        for(Figura fig : figuras)
            count += 1;
        return count;
    }
}
