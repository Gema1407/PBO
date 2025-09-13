package id.ac.polban.service;

import id.ac.polban.model.AlatTulis;
import id.ac.polban.model.AtributSekolah;
import id.ac.polban.model.Barang;

import java.util.ArrayList;
import java.util.Scanner;

public class Koperasi {

    private static final ArrayList<Barang> daftarBarang = new ArrayList<>();

    static {
        dataBarang();
    }

    private static void dataBarang() {
        daftarBarang.add(new AtributSekolah("Topi", 20000, 15));
        daftarBarang.add(new AtributSekolah("Dasi", 15000, 10));
        daftarBarang.add(new AtributSekolah("Kaos Kaki", 15000, 14));
        daftarBarang.add(new AtributSekolah("Pin", 25000, 9));
        daftarBarang.add(new AlatTulis("Pulpen", 3000, 30));
        daftarBarang.add(new AlatTulis("Tipe X", 7000, 23));
        daftarBarang.add(new AlatTulis("Pensil", 2000, 15));
        daftarBarang.add(new AlatTulis("Penghapus", 3000, 19));
    }


    public static void tampilkanMenu() {
        System.out.println("\n--- Selamat Datang di Koperasi Sekolah ---");
        System.out.println("---             Daftar Barang          ---");
        for (int i = 0; i < daftarBarang.size(); i++) {
            Barang barang = daftarBarang.get(i);
            System.out.printf("%d. %-15s | Harga: Rp %-7d | Stok: %d%n",
                    (i + 1), barang.getNamaBarang(), barang.getHarga(), barang.getStok());
        }
        System.out.println("0. Keluar");
        System.out.println("------------------------------------------");
    }


    public static void jalankan() {
        Scanner scanner = new Scanner(System.in);
        boolean lanjutBelanja = true;

        while (lanjutBelanja) {
            tampilkanMenu();

            System.out.print("Pilih barang yang ingin dibeli (masukkan nomor): ");
            try {
                int pilihan = scanner.nextInt();

                if (pilihan == 0) {
                    break;
                }

                if (pilihan > 0 && pilihan <= daftarBarang.size()) {
                    Barang barangDipilih = daftarBarang.get(pilihan - 1);

                    System.out.print("Berapa jumlah yang mau dibeli? ");
                    int jumlah = scanner.nextInt();

                    barangDipilih.prosesPembelian(jumlah);

                } else {
                    System.out.println("Tidak valid! masukkan nomor yang terdaftar.");
                }

            } catch (Exception e) {
                System.out.println("Input tidak valid! Harap masukkan angka.");
                scanner.next();
            }

            System.out.print("\nIngin melanjutkan pembelian? (y/n): ");
            String konfirmasi = scanner.next();

            if (konfirmasi.equalsIgnoreCase("n")) {
                lanjutBelanja = false;
            }
        }

        System.out.println("\nTerima kasih!");
        scanner.close();
    }

    // Main method sebagai entry point aplikasi
    public static void main(String[] args) {
        jalankan();
    }
}