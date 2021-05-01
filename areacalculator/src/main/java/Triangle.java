public class Triangle implements Shape {

    double base, height;


    Triangle(double base,double height){
        this.base = base;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getBase() {
        return base;
    }

    public double getArea() {
        return this.base*this.height/2;
    }

    public String draw() {
        return "Triangle";
    }
}
