public class Circle implements Shape{
    private double radius;

    Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.getRadius(), 2);
    }

    public String draw() {
        return "Circle";
    }
}
