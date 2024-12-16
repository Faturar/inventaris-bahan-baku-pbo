package service;

import entity.Barang;
import entity.Pemasok;
import repository.BarangRepository;

import java.util.List;

public class BarangServiceImpl implements BarangService{

    private BarangRepository barangRepository;

    public BarangServiceImpl(BarangRepository barangRepository){
        this.barangRepository =barangRepository;
    }
    @Override
    public void showBarang() {
        List<Barang> model= barangRepository.getAll();
        System.out.println("========= DAFTAR BARANG =========");
        for (var i=0; i <model.size();i++){
            Barang barang = model.get(i);
            System.out.println("    Kode Barang : " + barang.getKdBarang());
            System.out.println("    Nama : " + barang.getNama());
            System.out.println("    Kategori : " + barang.getKategori());
            System.out.println("    Stok : " + barang.getStok());
            System.out.println("    Stok Minimum : " + barang.getStokMinimum());
            System.out.println("    Tanggal Kadaluarsa : " + barang.getTanggalKadaluarsa());
            System.out.println("    ID Pemasok : " + barang.getIdPemasok());

            System.out.println("-------------------------------------------");

        }
    }

    @Override
    public void addBarang(Barang barang) {
        // Validation
       if(barang.getKdBarang() == null || barang.getKdBarang().isEmpty()){
           System.err.println("Kode Barang tidak boleh kosong");
           return;
       }
       if(barang.getNama() == null || barang.getNama().isEmpty()){
            System.err.println("Nama tidak boleh kosong");
            return;
        }
       if(barang.getKategori() == null || barang.getKategori().isEmpty()){
            System.err.println("Kategori tidak boleh kosong");
            return;
        }
       if(barang.getStok() < 0){
            System.err.println("Stok tidak boleh kurang dari 0.");
            return;
        }
       if(barang.getStokMinimum() < 0){
            System.err.println("Stok minimum tidak boleh kurang dari 0.");
            return;
        }

        barangRepository.add(barang);

    }

    @Override
    public void editBarang(Barang barang) {
        // Validation
        if(barang.getKdBarang() == null || barang.getKdBarang().isEmpty()){
            System.err.println("Kode Barang tidak boleh kosong");
            return;
        }
        if(barang.getNama() == null || barang.getNama().isEmpty()){
            System.err.println("Nama tidak boleh kosong");
            return;
        }
        if(barang.getKategori() == null || barang.getKategori().isEmpty()){
            System.err.println("Kategori tidak boleh kosong");
            return;
        }


        barangRepository.edit(barang);
        System.out.println("Sukses Mengubah Data : " + barang);

    }

    @Override
    public void addStokBarang(Barang barang) {
        // Validation
        if(barang.getKdBarang() == null || barang.getKdBarang().isEmpty()){
            System.err.println("Kode Barang tidak boleh kosong");
            return;
        }
        if(barang.getStok() < 0){
            System.err.println("Stok tidak boleh kurang dari 0.");
            return;
        }

        barangRepository.addStok(barang);
        System.out.println("Sukses Mengubah Data : " + barang);
    }

    @Override
    public void minStokBarang(Barang barang) {
        // Validation
        if(barang.getKdBarang() == null || barang.getKdBarang().isEmpty()){
            System.err.println("Kode Barang tidak boleh kosong");
            return;
        }
        if(barang.getStok() < 0){
            System.err.println("Stok tidak boleh kurang dari 0.");
            return;
        }

        barangRepository.minStok(barang);
        System.out.println("Sukses Mengubah Data : " + barang);
    }


    @Override
    public void deleteBarang(String kdBarang) {

    }

    @Override
    public Barang findBarangId(String kdBarang) {
        return null;
    }
}
