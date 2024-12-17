package service;

import entity.Barang;
import entity.BarangMasukKeluar;
import entity.Pemasok;
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
            System.out.println("    ID : " + barangMasukKeluar.getId());
            System.out.println("    Kode Barang : " + barangMasukKeluar.getKdBarang());
            System.out.println("    Jumlah : " + barangMasukKeluar.getJumlah());
            System.out.println("    Tanggal : " + barangMasukKeluar.getTanggal());
            //System.out.println("    Jumlah : " + barangMasukKeluar.getJumlah());


            System.out.println("-------------------------------------------");

        }
    }

    @Override
    public void addBarangMasuk(BarangMasukKeluar barangMasukKeluar) {
        // Validation
        if(barangMasukKeluar.getKdBarang() == null || barangMasukKeluar.getKdBarang().isEmpty()){
            System.err.println("Kode Barang tidak boleh kosong");
            return;
        }

        if(barangMasukKeluar.getJumlah() < 0){
            System.err.println("Jumlah tidak boleh kurang dari 0.");
            return;
        }

        barangMasukKeluarRepository.addMasuk(barangMasukKeluar);
    }

    @Override
    public void editBarangMasuk(BarangMasukKeluar barangMasukKeluar) {

    }

    @Override
    public void deleteBarangMasuk(int id) {
        BarangMasukKeluar barangMasukKeluar = barangMasukKeluarRepository.findByIdMasuk(id);

        if(barangMasukKeluar == null){
            System.err.println("Barang Masuk Keluar dengan Id " + id + " tidak ditemukan. ");
            return;
        }

        barangMasukKeluarRepository.deleteMasuk(id);
        System.out.println("Pemasok dengan ID "+ id + " berhasil dihapus.");
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
            System.out.println("    ID : " + barangMasukKeluar.getId());
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
        BarangMasukKeluar barangMasukKeluar = barangMasukKeluarRepository.findByIdMasuk(id);

        if(barangMasukKeluar == null){
            System.err.println("Barang Masuk Keluar dengan Id " + id + " tidak ditemukan. ");
            return;
        }

        barangMasukKeluarRepository.deleteKeluar(id);
        System.out.println("Pemasok dengan ID "+ id + " berhasil dihapus.");
    }

    @Override
    public BarangMasukKeluar findBarangIdKeluar(int id) {
        return null;
    }
}
