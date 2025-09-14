package Minggu4.PenerapaKonsep;

public class AlatTulis extends Barang {
    private String merk;
    private String warna;

    // Constructor dengan atribut tambahan
    public AlatTulis(String namaBarang, int harga, int stok, String merk, String warna) {
        super(namaBarang, harga, stok);
        this.merk = merk;
        this.warna = warna;
    }

    // Override method dari class Barang
    @Override
    public void tampilkanInfoLengkap() {
        super.tampilkanInfoLengkap(); // Panggil method dari parent class untuk info dasar
        System.out.printf("                | (Merek: %s, Warna: %s)%n", this.merk, this.warna);
    }
}