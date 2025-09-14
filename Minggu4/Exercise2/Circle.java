package Minggu4.Exercise2;

public class Circle extends Shape {
    private double radius = 1.0;

    public Circle() {
        radius = 1.0;
    }

    public Circle(double r) {
        radius = r;
    }

    public Circle(double r, String c, boolean f) {
        super(c, f);
        radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle[Shape[" + super.toString() + "], radius=" + radius + "]";
    }
}
