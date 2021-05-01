public class Line implements BasicShape{
    double lenght;

    Line(double lenght){
        this.lenght = lenght;
    }

    public double getArea() throws NoAreaException{
        throw new NoAreaException();
    }

    public double getLenght() {
        return lenght;
    }
}
