package Minggu4.PenerapaKonsep;

public class AlatTulis extends Barang {
    private String merk;
    private String warna;

    public AlatTulis(String namaBarang, int harga, int stok, String merk, String warna) {
        super(namaBarang, harga, stok);
        this.merk = merk;
        this.warna = warna;
    }

    @Override
    public void tampilkanInfoLengkap() {
        super.tampilkanInfoLengkap(); 
        System.out.printf("                | (Merek: %s, Warna: %s)%n", this.merk, this.warna);
    }
}