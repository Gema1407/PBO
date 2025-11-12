package Minggu4.PenerapaKonsep;

public class Barang {
    protected String namaBarang;
    protected int harga;
    protected int stok;

    // constructor
    Barang(String namaBarang, int harga, int stok){
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.stok = stok;
    }
    
    // Method untuk menampilkan info 
    public void tampilkanInfoLengkap() {
        System.out.printf("%-15s | Harga: Rp %-7d | Stok: %d%n", 
                          this.getNamaBarang(), this.getHarga(), this.getStok());
    }

    public boolean prosesPembelian(int jumlahDibeli){
        if (jumlahDibeli > 0 && jumlahDibeli <= this.stok) {
            this.stok -= jumlahDibeli;
            return true; // Pembelian berhasil
        }
        return false; // Pembelian gagal karena stok kurang atau input tidak valid
    }

    public String getNamaBarang(){
        return namaBarang;
    }
    public int getHarga(){
        return harga;
    }
    public int getStok(){
        return stok;
    }
    public void setNamaBarang(String namaBarang){
        this.namaBarang = namaBarang;
    }
    public void setHarga(int harga){
        this.harga = harga;
    }
    public void setStok(int stok){
        this.stok = stok;
    }
}