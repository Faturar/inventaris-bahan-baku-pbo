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

    public void showPemasokId(){
        List<Pemasok> model= pemasokRepository.getAll();
        System.out.println("========= DAFTAR PEMASOK =========");
        for (var i=0; i <model.size();i++){
            Pemasok pemasok = model.get(i);
            System.out.print((i+1) + ".  ID: " + pemasok.getId());
            System.out.println("    Nama : " + pemasok.getNama());

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
        System.out.println("Sukses Menambah Data ");

    }

    @Override
    public void editPemasok(Pemasok pemasok) {
        // Validate data
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

        // Save changes to the repository
        pemasokRepository.edit(pemasok);
        System.out.println("Sukses Mengubah Data ");
    }

    @Override
    public void deletePemasok(int id) {
        Pemasok pemasok = pemasokRepository.findById(id);

        if(pemasok == null){
            System.err.println("Pemasok dengan Id " + id + " tidak ditemukan. ");
            return;
        }

        pemasokRepository.delete(id);
        System.out.println("Pemasok dengan ID "+ id + " berhasil dihapus.");
    }

    @Override
    public Pemasok findPemasokId(int id){
        return pemasokRepository.findById(id);
    }

}
