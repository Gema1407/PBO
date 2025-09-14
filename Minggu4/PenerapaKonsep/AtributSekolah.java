package Minggu4.PenerapaKonsep;

public class AtributSekolah extends Barang {
    private String ukuran;
    private String bahan;

    public AtributSekolah(String namaBarang, int harga, int stok, String ukuran, String bahan) {
        super(namaBarang, harga, stok);
        this.ukuran = ukuran;
        this.bahan = bahan;
    }

    @Override
    public void tampilkanInfoLengkap() {
        super.tampilkanInfoLengkap();
        System.out.printf("                | (Ukuran: %s, Bahan: %s)%n", this.ukuran, this.bahan);
    }
}