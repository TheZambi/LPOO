public class Rectangle implements Shape{
    double width;
    double height;

    Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getArea() {
        return this.height * this.width;
    }


    public String draw() {
        return "Rectangle";
    }
}
