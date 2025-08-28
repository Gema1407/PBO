import java.util.Scanner;
import java.math.BigInteger;

public class soal1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah angka yang ingin dicek: ");
        int T = sc.nextInt(); 

        String[] inputs = new String[T];
        System.out.println("Sekarang masukkan " + T + " angka (satu per baris):");
        for (int i = 0; i < T; i++) {
            inputs[i] = sc.next(); 
        }

        for (String input : inputs) {
            try {
                BigInteger num = new BigInteger(input);
                boolean canFit = false;

                StringBuilder fit = new StringBuilder();

                if (num.compareTo(BigInteger.valueOf(Byte.MIN_VALUE)) >= 0 &&
                    num.compareTo(BigInteger.valueOf(Byte.MAX_VALUE)) <= 0) {
                    fit.append("* byte\n");
                    canFit = true;
                }
                if (num.compareTo(BigInteger.valueOf(Short.MIN_VALUE)) >= 0 &&
                    num.compareTo(BigInteger.valueOf(Short.MAX_VALUE)) <= 0) {
                    fit.append("* short\n");
                    canFit = true;
                }
                if (num.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) >= 0 &&
                    num.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) <= 0) {
                    fit.append("* int\n");
                    canFit = true;
                }
                if (num.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) >= 0 &&
                    num.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) <= 0) {
                    fit.append("* long\n");
                    canFit = true;
                }

                if (canFit) {
                    System.out.println(input + " can be fitted in:");
                    System.out.println(fit.toString());
                 } else {
                        System.out.println(input + "cant be fitted anywhere. ");
                    }
                }

             catch (Exception e) {
                System.out.println(input + " can't be fitted anywhere.");
            }
        }

        sc.close();
    }
}
