package Minggu6.Soal5Interface;

public class Main {
    public static void main(String[] args) {
        Food apple = new Food("Fuji Apple", 1.50, 95);
        Toy legoCar = new Toy("Lego Race Car", 24.99, 8);
        Book javaBook = new Book("Effective Java", 45.50, "Joshua Bloch");

        System.out.println("--- Detail Makanan ---");
        apple.display();
        System.out.println();

        System.out.println("--- Detail Mainan ---");
        legoCar.display();
        System.out.println();

        System.out.println("--- Detail Buku ---");
        javaBook.display();
        System.out.println();
    }
}
