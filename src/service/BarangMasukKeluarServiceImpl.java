package service;

import entity.Barang;
import entity.BarangMasukKeluar;
import repository.BarangMasukKeluarRepository;
import repository.BarangRepository;

import java.util.List;

public class BarangMasukKeluarServiceImpl implements BarangMasukKeluarService {

    private BarangMasukKeluarRepository barangMasukKeluarRepository;

    public BarangMasukKeluarServiceImpl(BarangMasukKeluarRepository barangMasukKeluarRepository){
        this.barangMasukKeluarRepository =barangMasukKeluarRepository;
    }
    @Override
    public void showBarangMasuk() {
        List<BarangMasukKeluar> model= barangMasukKeluarRepository.getAllMasuk();
        System.out.println("========= DAFTAR BARANG MASUK =========");
        for (var i=0; i <model.size();i++){
            BarangMasukKeluar barangMasukKeluar = model.get(i);
            System.out.println("    id : " + barangMasukKeluar.getKdBarang());
            System.out.println("    Kode Barang : " + barangMasukKeluar.getKdBarang());
            System.out.println("    Jumlah : " + barangMasukKeluar.getJumlah());
            System.out.println("    Tanggal : " + barangMasukKeluar.getTanggal());
            //System.out.println("    Jumlah : " + barangMasukKeluar.getJumlah());


            System.out.println("-------------------------------------------");

        }
    }

    @Override
    public void addBarangMasuk(BarangMasukKeluar barangMasukKeluar) {

    }

    @Override
    public void editBarangMasuk(BarangMasukKeluar barangMasukKeluar) {

    }

    @Override
    public void deleteBarangMasuk(int id) {

    }

    @Override
    public BarangMasukKeluar findBarangIdMasuk(int id) {
        return null;
    }

    @Override
    public void showBarangKeluar() {
        List<BarangMasukKeluar> model= barangMasukKeluarRepository.getAllKeluar();
        System.out.println("========= DAFTAR BARANG KELUAR =========");
        for (var i=0; i <model.size();i++){
            BarangMasukKeluar barangMasukKeluar = model.get(i);
            System.out.println("    id : " + barangMasukKeluar.getKdBarang());
            System.out.println("    Kode Barang : " + barangMasukKeluar.getKdBarang());
            System.out.println("    Jumlah : " + barangMasukKeluar.getJumlah());
            System.out.println("    Tanggal : " + barangMasukKeluar.getTanggal());
            //System.out.println("    Jumlah : " + barangMasukKeluar.getJumlah());


            System.out.println("-------------------------------------------");

        }
    }

    @Override
    public void addBarangKeluar(BarangMasukKeluar barangMasukKeluar) {

    }

    @Override
    public void editBarangKeluar(BarangMasukKeluar barangMasukKeluar) {

    }

    @Override
    public void deleteBarangKeluar(int id) {

    }

    @Override
    public BarangMasukKeluar findBarangIdKeluar(int id) {
        return null;
    }
}
