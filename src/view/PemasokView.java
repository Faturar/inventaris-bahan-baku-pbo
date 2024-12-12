package view;

import entity.Pemasok;
import service.PemasokService;
import util.InputUtil;

public class PemasokView {

    private  PemasokService pemasokService;

    public PemasokView(PemasokService pemasokService) {
        this.pemasokService = pemasokService;
    }
    public void showPemasok(){

        while (true){
            pemasokService.showPemasok();
            System.out.println("Menu :  ");
            System.out.println("1.Tambah");
            System.out.println("2.Edit");
            System.out.println("3.Hapus");
            System.out.println("x.Menu Utama");

            var input = InputUtil.inputS("Pilih");
            if(input.equals("1")){
                addPemasok();
            }else if(input.equals("2")){
                editPemasok();
            }else if(input.equals("3")){
                removePemasok();
            }else if(input.equals("x")){
                break;
            }else{
                System.out.println("Pilihan tidak dimengerti");
            }

        }
    }

    public void addPemasok() {
        System.out.println("Menambah Data Pemasok");
        // Input nama pemasok
        var nama = InputUtil.inputS("Nama Pemasok |  (x untuk batal)  ");
        if (nama.equalsIgnoreCase("x")) {
            System.out.println("Batal menambah pemasok.");
            return;
        }

        // Input alamat pemasok
        var alamat = InputUtil.inputS("Alamat Pemasok");
        if (alamat.isEmpty()) {
            System.out.println("Alamat tidak boleh kosong.");
            return;
        }

        // Input nomor telepon pemasok
        var noTelepon = InputUtil.inputS("Nomor Telepon Pemasok");
        if (noTelepon.isEmpty()) {
            System.out.println("Nomor telepon tidak boleh kosong.");
            return;
        }

            // Create a Pemasok object and set its attributes
            Pemasok pemasokData = new Pemasok();
            pemasokData.setNama(nama);
            pemasokData.setAlamat(alamat);
            pemasokData.setNoTelepon(noTelepon);

            // Add pemasok using the service layer
            pemasokService.addPemasok(pemasokData);


    }

    private void editPemasok() {
        System.out.println("Mengubah Data Pemasok");

        // Input ID of the Pemasok to edit
        var idStr = InputUtil.inputS("ID Pemasok yang ingin diedit | (x untuk batal)");
        if (idStr.equalsIgnoreCase("x")) {
            System.out.println("Batal mengedit pemasok.");
            return;
        }

        int id;
        // convert str to int
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            System.err.println("ID tidak valid. Harus berupa angka.");
            return;
        }

        // Find the pemasok by ID
        Pemasok existingPemasok = pemasokService.findPemasokId(id);
        if (existingPemasok == null) {
            System.err.println("Pemasok dengan ID " + id + " tidak ditemukan.");
            return;
        }

        // Display current data
        System.out.println("Data pemasok saat ini:");
        System.out.println("Nama       : " + existingPemasok.getNama());
        System.out.println("Alamat     : " + existingPemasok.getAlamat());
        System.out.println("No Telepon : " + existingPemasok.getNoTelepon());

        // Input new values (allow skipping fields)
        var newNama = InputUtil.inputS("Nama baru (kosongkan untuk tidak mengubah)");
        var newAlamat = InputUtil.inputS("Alamat baru (kosongkan untuk tidak mengubah)");
        var newNoTelepon = InputUtil.inputS("No Telepon baru (kosongkan untuk tidak mengubah)");

        if (!newNama.isEmpty()) existingPemasok.setNama(newNama);
        if (!newAlamat.isEmpty()) existingPemasok.setAlamat(newAlamat);
        if (!newNoTelepon.isEmpty()) existingPemasok.setNoTelepon(newNoTelepon);

        // Call the service to update
        pemasokService.editPemasok(existingPemasok);
        System.out.println("Data Pemasok berhasil diperbarui.");
    }

    public void removePemasok() {
        System.out.println("Menghapus Data Pemasok");

        int id = InputUtil.inputI("Masukkan ID pemasok yang akan dihapus | (0 untuk batal) ");

        if(id == 0){
            System.out.println("Penghapusan dibatalakan");
            return;
        }

        pemasokService.deletePemasok(id);
    }



}
