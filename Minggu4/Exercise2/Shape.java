package Minggu4.Exercise2;

public class Shape {
    private String color = "red";
    private boolean filled = true;

    public Shape() {
        color = "green";
        filled = true;
    }

    public Shape(String c, boolean f) {
        color = c;
        filled = f;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String toString() {
        return "Shape[color=" + color + ",filled=" + filled + "]";
    }

}