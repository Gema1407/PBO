/*
 * Nama File   : Koperasi.java
 * Deskripsi   : Class Koperasi adalah main dari proyek program koperasi dan tempat untuk menjalankan program koperasi sekolah
 * Dibuat oleh : Gema Adzan Firdaus
 * Tanggal     : 28-08-2025
 */

package Minggu2;

import java.util.ArrayList;
import java.util.Scanner;

public class Koperasi {

    ArrayList<Barang> daftarBarang = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public Koperasi() {
        dataBarang();
    }

    public void dataBarang() {
        daftarBarang.add(new AtributSekolah("Topi", 20000, 15));
        daftarBarang.add(new AtributSekolah("Dasi", 15000, 10));
        daftarBarang.add(new AtributSekolah("Kaos Kaki", 15000, 14));
        daftarBarang.add(new AtributSekolah("Pin", 25000, 9));

        daftarBarang.add(new AlatTulis("Pulpen", 3000, 30));
        daftarBarang.add(new AlatTulis("Tipe X", 7000, 23));
        daftarBarang.add(new AlatTulis("Pensil", 2000, 15));
        daftarBarang.add(new AlatTulis("Penghapus", 3000, 19));
    }

    // Method untuk menampilkan semua barang dalam bentuk menu bernomor
    public void tampilkanMenu() {
        System.out.println("\n--- Selamat Datang di Koperasi Sekolah ---");
        System.out.println("---             Daftar Barang          ---");
        for (int i = 0; i < daftarBarang.size(); i++) {
            Barang barang = daftarBarang.get(i);
            // Mencetak dengan format: No. Nama Barang | Harga | Stok
            System.out.printf("%d. %-15s | Harga: Rp %-7d | Stok: %d%n", 
                              (i + 1), barang.getNamaBarang(), barang.getHarga(), barang.getStok());
        }
        System.out.println("0. Keluar");
        System.out.println("------------------------------------------");
    }

    public static void main(String[] args){
        Koperasi koperasiSekolah = new Koperasi();
        Scanner mainScanner = new Scanner(System.in);
        boolean lanjutBelanja = true;

        // Loop utama program
        while(lanjutBelanja){
            koperasiSekolah.tampilkanMenu(); // Menampilkan menu barang setiap kali loop dimulai

            System.out.print("Pilih barang yang ingin dibeli (masukkan nomor): ");
            try {
                int pilihan = mainScanner.nextInt();

                // cek input pengguna
                if (pilihan == 0) {
                    break;
                }
                
                if(pilihan > 0 && pilihan <= koperasiSekolah.daftarBarang.size()){
                    Barang barangDipilih = koperasiSekolah.daftarBarang.get(pilihan - 1); // -1 karena list dimulai dari 0
                    
                    System.out.print("Berapa jumlah yang mau dibeli? ");
                    int jumlah = mainScanner.nextInt();
                    
                    barangDipilih.prosesPembelian(jumlah);

                } else {
                    System.out.println("Tidak valid! masukkan nomor yang terdaftar.");
                }

            } catch (Exception e) {
                System.out.println("Input tidak valid! Harap masukkan angka.");
                mainScanner.next();
            }
            
            // Konfirmasi untuk lanjut atau ngga
            System.out.print("\ningin melanjutkan pembelian? (y/n): ");
            String konfirmasi = mainScanner.next();
            
            if(konfirmasi.equalsIgnoreCase("n")){
                lanjutBelanja = false;
            }
        }

        System.out.println("\nTerima kasih!");
        mainScanner.close();
    }

}
