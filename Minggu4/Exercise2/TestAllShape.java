package Minggu4.Exercise2;

public class TestAllShape {
    public static void main(String[] args) {
        System.out.println("--- Class Shape ---");
        Shape s1 = new Shape("blue", false);
        System.out.println("Shape s1 (dari constructor): " + s1);
        s1.setColor("purple");
        s1.setFilled(true);
        System.out.println("Shape s1 (setelah setter): "
                + "Color=" + s1.getColor()
                + ", Filled=" + s1.isFilled());
        System.out.println("----------------------------------\n");

        // --- Testing Circle ---
        System.out.println("--- Class Circle ---");
        Circle c1 = new Circle(5.0, "red", true);
        System.out.println("Circle c1 (dari constructor): " + c1);
        System.out.println("Area c1: " + c1.getArea());
        System.out.println("Perimeter c1: " + c1.getPerimeter());
        c1.setRadius(7.5);
        System.out.println("Circle c1 (setelah setRadius): " + c1);
        System.out.println("Area c1 baru: " + c1.getArea());
        System.out.println("----------------------------------\n");

        // --- Testing Rectangle ---
        System.out.println("--- Class Rectangle ---");
        Rectangle r1 = new Rectangle(4.0, 6.0, "yellow", true);
        System.out.println("Rectangle r1 (dari constructor): " + r1);
        System.out.println("Area r1: " + r1.getArea());
        System.out.println("Perimeter r1: " + r1.getPerimeter());
        r1.setLength(8.0);
        r1.setWidth(5.0);
        System.out.println("Rectangle r1 (setelah setter): " + r1);
        System.out.println("Area r1 baru: " + r1.getArea());
        System.out.println("----------------------------------\n");

        // --- Testing Square ---
        System.out.println("--- Class Square ---");
        Square sq1 = new Square(5.0, "green", true);
        System.out.println("Square sq1 (dari constructor): " + sq1);
        System.out.println("Area sq1: " + sq1.getArea());
        System.out.println("Perimeter sq1: " + sq1.getPerimeter());

        // Ngubah sisi pake setSide
        sq1.setSide(10.0);
        System.out.println("Square sq1 (setelah setSide): " + sq1);
        System.out.println("Side: " + sq1.getSide() + ", Length: " + sq1.getLength() + ", Width: " + sq1.getWidth());

        // Ngubah sisi pake setLength
        sq1.setLength(12.0);
        System.out.println("Square sq1 (setelah setLength): " + sq1);
        System.out.println("Side: " + sq1.getSide() + ", Length: " + sq1.getLength() + ", Width: " + sq1.getWidth());
        System.out.println("Area sq1 baru: " + sq1.getArea());
        System.out.println("----------------------------------\n");
    }
}
