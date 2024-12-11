package service;

import entity.Pemasok;
import repository.PemasokRepository;

import java.util.List;

public class PemasokServiceImpl implements PemasokService{

    private PemasokRepository pemasokRepository;

    public PemasokServiceImpl(PemasokRepository pemasokRepository) {
        this.pemasokRepository = pemasokRepository;

    }

    @Override
    public void showPemasok() {
        List<Pemasok> model= pemasokRepository.getAll();
        System.out.println("========= DAFTAR PEMASOK =========");
        for (var i=0; i <model.size();i++){
            Pemasok pemasok = model.get(i);
            System.out.println((i+1) + ".  ID: " + pemasok.getId());
            System.out.println("    Nama : " + pemasok.getNama());
            System.out.println("    Alamat : " + pemasok.getAlamat());
            System.out.println("    No Telepon : " + pemasok.getNoTelepon());
            System.out.println("-------------------------------------------");
                        
        }
    }

    @Override
    public void addPemasok(Pemasok pemasok) {
        // Validasi data
        if (pemasok.getNama() == null || pemasok.getNama().isEmpty()) {
            System.err.println("Nama pemasok tidak boleh kosong.");
            return;
        }
        if (pemasok.getAlamat() == null || pemasok.getAlamat().isEmpty()) {
            System.err.println("Alamat pemasok tidak boleh kosong.");
            return;
        }
        if (pemasok.getNoTelepon() == null || pemasok.getNoTelepon().isEmpty()) {
            System.err.println("Nomor telepon pemasok tidak boleh kosong.");
            return;
        }

        pemasokRepository.add(pemasok);
        System.out.println("Sukses Menambah Data : " + pemasok);


        // Default timestamps jika belum diisi
//        if (pemasok.getCreatedAt() == null) {
//            pemasok.setCreatedAt(new Timestamp(System.currentTimeMillis()));
//        }
//        if (pemasok.getUpdatedAt() == null) {
//            pemasok.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
//        }
    }

    @Override
    public void editPemasok(Pemasok pemasok) {

    }

    @Override
    public void deletePemasok(int id) {

    }
}
