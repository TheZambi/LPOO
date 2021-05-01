public class Circulo implements Figura {
    Ponto centro;
    int raio;

    public Circulo(Ponto p, int i) {
        if(i<=0)
            throw new IllegalArgumentException();
        this.centro = p;
        this.raio = i;
    }

    public int getRaio() {
        return raio;
    }

    public Ponto getCentro() {
        return centro;
    }


    @Override
    public double getArea() {
        return this.raio*this.raio*Math.PI;
    }

    @Override
    public double getPerimetro() {
        return Math.PI*2*this.raio;
    }
}
