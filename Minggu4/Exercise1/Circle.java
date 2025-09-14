package Minggu4.Exercise1;

/**
 * The Circle class models a circle with a radius and color.
 */
public class Circle {
    private double radius;
    private String color;

    // Constructors (overloaded)
    /** Constructs a Circle instance with default value for radius and color */
    public Circle() { // 1st (default) constructor
        radius = 1.0;
        color = "red";
    }

    /** Constructs a Circle instance with the given radius and default color */
    public Circle(double r) { // 2nd constructor
        radius = r;
        color = "red";
    }

    //RADIUS
    /** Returns the radius */
    public double getRadius() {
        return radius;
    }

    public void setRadius() {
        this.radius = radius;
    }


    //COLOR
    public String getColor() {
        return color;
    }

    public void setColor() {
        this.color = color;
    }

    /** Returns the area of this Circle instance */
    public double getArea() {
        return radius * radius * Math.PI;
    }

    /**
     * Return a self-descriptive string of this instance in the form of
     * Circle[radius=?,color=?]
     */
    public String toString() {
        return "Circle[radius=" + radius + " color=" + color + "]";
    }
}
