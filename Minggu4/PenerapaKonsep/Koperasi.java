package Minggu4.PenerapaKonsep;

import java.util.ArrayList;
import java.util.Scanner;

public class Koperasi {

    ArrayList<Barang> daftarBarang = new ArrayList<>();

    public Koperasi() {
        dataBarang();
    }

    public void dataBarang() {
        daftarBarang.add(new AtributSekolah("Topi", 20000, 15, "All Size", "Drill"));
        daftarBarang.add(new AtributSekolah("Dasi", 15000, 10, "SMP", "Katun"));
        daftarBarang.add(new AtributSekolah("Kaos Kaki", 15000, 14, "40-42", "Spandex"));
        daftarBarang.add(new AtributSekolah("Pin", 25000, 9, "OSIS", "Logam"));

        daftarBarang.add(new AlatTulis("Pulpen", 3000, 30, "Pilot", "Biru"));
        daftarBarang.add(new AlatTulis("Tipe X", 7000, 23, "Kenko", "Putih"));
        daftarBarang.add(new AlatTulis("Pensil", 2000, 15, "Faber-Castell", "2B"));
        daftarBarang.add(new AlatTulis("Penghapus", 3000, 19, "Joyko", "Putih"));
    }

    public void tampilkanMenu() {
        System.out.println("\n--- Selamat Datang di Koperasi Sekolah ---");
        System.out.println("---             Daftar Barang          ---");
        for (int i = 0; i < daftarBarang.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarBarang.get(i).tampilkanInfoLengkap();
        }
        System.out.println("0. Keluar");
        System.out.println("------------------------------------------");
    }

    public static void main(String[] args) {
        Koperasi koperasiSekolah = new Koperasi();
        Scanner mainScanner = new Scanner(System.in);
        boolean lanjutBelanja = true;

        while (lanjutBelanja) {
            koperasiSekolah.tampilkanMenu();

            System.out.print("Pilih barang yang ingin dibeli (masukkan nomor): ");
            try {
                int pilihan = mainScanner.nextInt();

                if (pilihan == 0) {
                    break;
                }

                if (pilihan > 0 && pilihan <= koperasiSekolah.daftarBarang.size()) {
                    Barang barangDipilih = koperasiSekolah.daftarBarang.get(pilihan - 1);

                    System.out.print("Berapa jumlah yang mau dibeli? ");
                    int jumlah = mainScanner.nextInt();

                    // <-- PERBAIKAN: Logika penanganan output sekarang ada di sini
                    boolean sukses = barangDipilih.prosesPembelian(jumlah);

                    System.out.println("--------------------------------------------------");
                    if (sukses) {
                        System.out.println("Anda berhasil membeli " + jumlah + " " + barangDipilih.getNamaBarang());
                        System.out.println("Sisa stok: " + barangDipilih.getStok());
                    } else {
                        if (jumlah <= 0) {
                            System.out.println("Jumlah pembelian tidak valid.");
                        } else {
                            System.out.println(
                                    "Pembelian Gagal! Stok " + barangDipilih.getNamaBarang() + " tidak mencukupi.");
                            System.out.println("Sisa stok: " + barangDipilih.getStok());
                        }
                    }
                    System.out.println("--------------------------------------------------");

                } else {
                    System.out.println("Tidak valid! Masukkan nomor yang terdaftar.");
                }

            } catch (Exception e) {
                System.out.println("Input tidak valid! Harap masukkan angka.");
                mainScanner.next();
            }

            System.out.print("\nIngin melanjutkan pembelian? (y/n): ");
            String konfirmasi = mainScanner.next();

            if (konfirmasi.equalsIgnoreCase("n")) {
                lanjutBelanja = false;
            }
        }

        System.out.println("\nTerima kasih!");
        mainScanner.close();
    }
}