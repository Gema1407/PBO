/*

 * Nama File   : Atribut.java
 * Deskripsi   : Class Atribut untuk menyimpan data barang yang berupa atribut sekolah yang ada di program koperasi sekolah
 * Dibuat oleh : Gema Adzan Firdaus
 * Tanggal     : 28-08-2025
 * Versi       : 1.0

*/

package Minggu2;
import java.util.ArrayList;

public class AtributSekolah extends Barang {
    private ArrayList<String> atributSekolah;

    public AtributSekolah(ArrayList<String> atributSekolah, double harga, int stok){
        super(harga, stok);
        this.atributSekolah = atributSekolah;
    }

        public ArrayList<String> getAtributSekolah(){
        return atributSekolah;
    }

    public double getHarga(){
        return harga;
    }

    public int getStok(){
        return stok;
    }

    //setter
    public void setAtributSekolah(ArrayList<String> atributSekolah){
        this.atributSekolah = atributSekolah;
    }

    public void setHarga(double harga){
        this.harga = harga;
    }

    public void setStok(int stok){
        this.stok = stok;
    }

}
    
