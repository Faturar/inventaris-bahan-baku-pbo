package service;

import entity.BarangMasukKeluar;

public interface BarangMasukKeluarService {

    void showBarangMasuk();
    void addBarangMasuk(BarangMasukKeluar barangMasukKeluar);

    void deleteBarangMasuk(int id);
    BarangMasukKeluar findBarangIdMasuk(int id);


    void showBarangKeluar();
    void addBarangKeluar(BarangMasukKeluar barangMasukKeluar);

    void deleteBarangKeluar(int id);
    BarangMasukKeluar findBarangIdKeluar(int id);



}
