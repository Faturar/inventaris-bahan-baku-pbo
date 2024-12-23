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


        var nama = InputUtil.inputS("Nama Pemasok |  (x untuk batal)  ");
        if (nama.equalsIgnoreCase("x")) {
            System.out.println("Batal menambah pemasok.");
            return;
        }


        var alamat = InputUtil.inputS("Alamat Pemasok");
        if (alamat.isEmpty()) {
            System.out.println("Alamat tidak boleh kosong.");
            return;
        }


        var noTelepon = InputUtil.inputS("Nomor Telepon Pemasok");
        if (noTelepon.isEmpty()) {
            System.out.println("Nomor telepon tidak boleh kosong.");
            return;
        }


        Pemasok pemasokData = new Pemasok();
        pemasokData.setNama(nama);
        pemasokData.setAlamat(alamat);
        pemasokData.setNoTelepon(noTelepon);

        pemasokService.addPemasok(pemasokData);

    }

    private void editPemasok() {
        System.out.println("Mengubah Data Pemasok");

        var idStr = InputUtil.inputS("ID Pemasok yang ingin diedit | (x untuk batal)");
        if (idStr.equalsIgnoreCase("x")) {
            System.out.println("Batal mengedit pemasok.");
            return;
        }

        int id;

        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            System.err.println("ID tidak valid. Harus berupa angka.");
            return;
        }


        Pemasok existingPemasok = pemasokService.findPemasokId(id);
        if (existingPemasok == null) {
            System.err.println("Pemasok dengan ID " + id + " tidak ditemukan.");
            return;
        }


        System.out.println("Data pemasok saat ini:");
        System.out.println("Nama       : " + existingPemasok.getNama());
        System.out.println("Alamat     : " + existingPemasok.getAlamat());
        System.out.println("No Telepon : " + existingPemasok.getNoTelepon());


        var newNama = InputUtil.inputS("Nama baru (kosongkan untuk tidak mengubah)");
        var newAlamat = InputUtil.inputS("Alamat baru (kosongkan untuk tidak mengubah)");
        var newNoTelepon = InputUtil.inputS("No Telepon baru (kosongkan untuk tidak mengubah)");

        if (!newNama.isEmpty()) existingPemasok.setNama(newNama);
        if (!newAlamat.isEmpty()) existingPemasok.setAlamat(newAlamat);
        if (!newNoTelepon.isEmpty()) existingPemasok.setNoTelepon(newNoTelepon);

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
