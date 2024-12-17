package repository;

import entity.Barang;
import entity.BarangMasukKeluar;

import java.util.List;

public interface BarangMasukKeluarRepository {

    //Barang Masuk
    List<BarangMasukKeluar> getAllMasuk();
    void addMasuk(BarangMasukKeluar barangMasukKeluar);
    void editMasuk(BarangMasukKeluar barangMasukKeluar);
    void deleteMasuk(int id);
    Barang findByIdMasuk(int id);

    //Barang Keluar
    List<BarangMasukKeluar> getAllKeluar();
    void addKeluar(BarangMasukKeluar barangMasukKeluar);
    void editKeluar(BarangMasukKeluar barangMasukKeluar);
    void deleteKeluar(int id);
    Barang findByIdKeluar(int id);
}
