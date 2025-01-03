package repository;

import entity.BarangMasukKeluar;
import java.util.List;

public interface BarangMasukKeluarRepository {

    //Barang Masuk
    List<BarangMasukKeluar> getAllMasuk();
    void addMasuk(BarangMasukKeluar barangMasukKeluar);

    void deleteMasuk(int id);
    BarangMasukKeluar findByIdMasuk(int id);

    //Barang Keluar
    List<BarangMasukKeluar> getAllKeluar();
    void addKeluar(BarangMasukKeluar barangMasukKeluar);

    void deleteKeluar(int id);
    BarangMasukKeluar findByIdKeluar(int id);
}
