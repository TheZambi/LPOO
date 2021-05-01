public class Rectangulo implements Figura{
    int x1,x2;
    int y1,y2;
    public Rectangulo(int x1, int y1, int x2, int y2) {
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
    }

    @Override
    public double getArea() {
        return abs(x2-x1)*abs(y2-y1);
    }

    @Override
    public double getPerimetro() {
        return abs(x2-x1)*2+abs(y2-y1)*2;
    }

    private double abs(int i) {
        if(i<0)
            return i*-1;
        else
            return i;
    }
}
