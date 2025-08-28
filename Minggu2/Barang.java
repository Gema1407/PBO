package Minggu2;

public class Barang {
    protected double harga;
    protected int stok;
    
    Barang(double harga, int stok){
        this.harga = harga;
        this.stok = stok;
    }

    public void barangDibeli(int stok, int barangDibeli){
        stok -= barangDibeli;
    }
}

