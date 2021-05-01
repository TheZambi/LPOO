public class Ellipse implements Shape{
    double x_rad;
    double y_rad;

    Ellipse(double x_rad,double y_rad){
        this.x_rad =x_rad;
        this.y_rad = y_rad;
    }

    public double getX_rad() {
        return x_rad;
    }

    public double getY_rad() {
        return y_rad;
    }

    public double getArea() {
        return Math.PI * this.getX_rad() * this.getY_rad();
    }

    public String draw() {
        return "Ellipse";
    }
}
