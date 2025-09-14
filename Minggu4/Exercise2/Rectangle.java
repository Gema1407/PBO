package Minggu4.Exercise2;

public class Rectangle extends Shape {
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {
        width = 1.0;
        length = 1.0;
    }

    public Rectangle(double w, double l) {
        width = w;
        length = l;
    }

    public Rectangle(double w, double l, String c, boolean f) {
        super(c, f);
        width = w;
        length = l;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "Rectangle[Shape" + super.toString() + ", width=" + width + " length=" + length + "]";
    }

}
