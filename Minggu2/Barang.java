/*

 * Nama File   : Barang.java
 * Deskripsi   : Class AlatTulis untuk menyimpan getter, setter, dan method barang di koperasi
 * Dibuat oleh : Gema Adzan Firdaus
 * Tanggal     : 28-08-2025

 */

package Minggu2;

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

    // getter
    public String getNamaBarang(){
        return namaBarang;
    }

    public int getHarga(){
        return harga;
    }

    public int getStok(){
        return stok;
    }

    //setter
    public void setNamaBarang(String namaBarang){
        this.namaBarang = namaBarang;
    }

    public void setHarga(int harga){
        this.harga = harga;
    }

    public void setStok(int stok){
        this.stok = stok;
    }


     // Method untuk mengurangi stok saat barang dibeli
    public void prosesPembelian(int jumlahDibeli){
        if(jumlahDibeli <= 0) {
            System.out.println("Jumlah pembelian tidak valid.");
        } else if(jumlahDibeli <= this.stok){
            this.stok -= jumlahDibeli;
            System.out.println("--------------------------------------------------");
            System.out.println("Anda berhasil membeli " + jumlahDibeli + " " + this.namaBarang);
            System.out.println("Sisa stok: " + this.stok);
            System.out.println("--------------------------------------------------");
        } else {
            System.out.println("--------------------------------------------------");
            System.out.println("Pembelian Gagal! Stok " + this.namaBarang + " tidak mencukupi.");
            System.out.println("Sisa stok: " + this.stok);
            System.out.println("--------------------------------------------------");
        }
    }
}

