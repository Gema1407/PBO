package Minggu4.Exercise2;

public class TestShape extends Shape {

    public static void main(String[] args) {
        Shape s1 = new Shape();
        System.out.println("Shape:"
                + " color=" + s1.getColor()
                + " filled=" + s1.isFilled());
    }

}
