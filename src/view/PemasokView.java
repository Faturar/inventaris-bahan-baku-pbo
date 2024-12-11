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
        System.out.println("Menambah Pemasok");

        var pemasok =InputUtil.inputS("Pemasok (x jika batal)");
        if(pemasok.equals("x")){
            System.out.println("Batal menambah pemasok.");
        }else{
            // Input nama pemasok
            var nama = InputUtil.inputS("Nama Pemasok (x untuk batal)");
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
            //pemasokService.addPemasok(pemasok);
        }
    }

    private void editPemasok() {
    }

    public void removePemasok() {
    }



}
