import java.util.Scanner;

public class soal5 {
    public static void main(String[] args) {
        System.out.println("masukkan 2 kata:");
        Scanner kata = new Scanner(System.in);
        String A = kata.next();
        String B = kata.next();
        
        // total huruf kedua kata tersebut
        System.out.println(A.length() + B.length());
        
        // cek apakah huruf pertama B muncul duluan dari pada huruf pertama A
        if (A.compareTo(B) > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
        // membuat huruf pertama kapital
        String kata1 = A.substring(0,1).toUpperCase() + A.substring(1);
        String kata2 = B.substring(0,1).toUpperCase() + B.substring(1);
        
        System.out.println(kata1 + " " + kata2);
    }
}

