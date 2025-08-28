/*

 * Nama File   : AlatTulis.java
 * Deskripsi   : Class AlatTulis untuk menyimpan data barang alat tulis pada program koperasi sekolah
 * Dibuat oleh : Gema Adzan Firdaus
 * Tanggal     : 28-08-2025
 * Versi       : 1.0

 */

package Minggu2;
import java.util.ArrayList;

// class AlatTulis
public class AlatTulis extends Barang {
    private ArrayList<String> alatTulis;
    //constructor class AlatTulis
    public AlatTulis(ArrayList<String> alatTulis, double harga, int stok){
        super(harga, stok);
        this.alatTulis = alatTulis;
    }

    //getter
    public ArrayList<String> getAlatTulis(){
        return alatTulis;
    }

    public double getHarga(){
        return harga;
    }

    public int getStok(){
        return stok;
    }

    //setter
    public void setAlatTulis(ArrayList<String> alatTulis){
        this.alatTulis = alatTulis;
    }

    public void setHarga(double harga){
        this.harga = harga;
    }

    public void setStok(int stok){
        this.stok = stok;
    }

}
