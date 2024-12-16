package view;

import entity.Barang;

import service.BarangService;

import util.InputUtil;

import java.sql.Timestamp;

public class BarangView {

    private BarangService barangService;

    public BarangView(BarangService barangService) {
        this.barangService = barangService;
    }
    public void showBarang(){

        while (true){
            barangService.showBarang();
            System.out.println("Menu :  ");
            System.out.println("1.Tambah");
            System.out.println("2.Edit Stok");
            System.out.println("3.Edit Barang");
            System.out.println("4.Hapus");
            System.out.println("x.Menu Utama");

            var input = InputUtil.inputS("Pilih");
            if(input.equals("1")){
                addBarang();
            }else if(input.equals("2")) {
                editStok();
            }else if(input.equals("3")){
                editBarang();
            }else if(input.equals("4")){
                removeBarang();
            }else if(input.equals("x")){
                break;
            }else{
                System.out.println("Pilihan tidak dimengerti");
            }

        }
    }

    public void addBarang() {
        String kdBarang = InputUtil.inputS("Masukkan kode barang: ");
        String nama = InputUtil.inputS("Masukkan nama barang: ");
        String kategori = InputUtil.inputS("Masukkan kategori barang: ");
        int stok = InputUtil.inputI("Masukkan stok barang: ");
        int stokMinimum = InputUtil.inputI("Masukkan stok minimum barang: ");
        //Timestamp tanggalKadaluarsa = Timestamp.valueOf(InputUtil.inputS("Masukkan tanggal kadaluarsa (yyyy-MM-dd HH:mm:ss): "));
        int idPemasok = InputUtil.inputI("Masukkan ID pemasok: ");

        // Create a Pemasok object and set its attributes
        Barang barangData = new Barang();
        barangData.setKdBarang(kdBarang);
        barangData.setNama(nama);
        barangData.setKategori(kategori);
        barangData.setStok(stok);
        barangData.setStokMinimum(stokMinimum);
        //barangData.setTanggalKadaluarsa(tanggalKadaluarsa);
        barangData.setIdPemasok(idPemasok);


        // Add pemasok using the service layer
        barangService.addBarang(barangData);


    }

    private  void editStok(){
        while (true) {

            System.out.println("Menu :  ");
            System.out.println("1.Tambah Stok");
            System.out.println("2.Kurangi Stok");
            System.out.println("x.Kembali");

            var input = InputUtil.inputS("Pilih");
            if (input.equals("1")) {
                addStokBarang();
            } else if (input.equals("2")) {
                minStokBarang();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }


        }
    }

    private void addStokBarang(){
        barangService.showBarang();
        System.out.println("=========== Tambah Stok ===========");
        String kdBarang = InputUtil.inputS("Masukkan Kode barang: ");
        int stok = InputUtil.inputI("Masukkan jumlah barang: ");

        Barang barangData = new Barang();
        barangData.setKdBarang(kdBarang);
        barangData.setStok(stok);
        // Add pemasok using the service layer
        barangService.addStokBarang(barangData);
    }
    private void minStokBarang(){
        barangService.showBarang();
        System.out.println("=========== Pengurangan Stok ===========");
        String kdBarang = InputUtil.inputS("Masukkan Kode barang: ");
        int stok = InputUtil.inputI("Masukkan jumlah barang: ");

        Barang barangData = new Barang();
        barangData.setKdBarang(kdBarang);
        barangData.setStok(stok);
        // Add pemasok using the service layer
        barangService.minStokBarang(barangData);
    }

    private void editBarang() {
//        System.out.println("Mengubah Data Pemasok");
//
//        // Input ID of the Pemasok to edit
//        var idStr = InputUtil.inputS("ID Pemasok yang ingin diedit | (x untuk batal)");
//        if (idStr.equalsIgnoreCase("x")) {
//            System.out.println("Batal mengedit pemasok.");
//            return;
//        }
//
//        int id;
//        // convert str to int
//        try {
//            id = Integer.parseInt(idStr);
//        } catch (NumberFormatException e) {
//            System.err.println("ID tidak valid. Harus berupa angka.");
//            return;
//        }
//
//        // Find the pemasok by ID
//        Pemasok existingPemasok = pemasokService.findPemasokId(id);
//        if (existingPemasok == null) {
//            System.err.println("Pemasok dengan ID " + id + " tidak ditemukan.");
//            return;
//        }
//
//        // Display current data
//        System.out.println("Data pemasok saat ini:");
//        System.out.println("Nama       : " + existingPemasok.getNama());
//        System.out.println("Alamat     : " + existingPemasok.getAlamat());
//        System.out.println("No Telepon : " + existingPemasok.getNoTelepon());
//
//        // Input new values (allow skipping fields)
//        var newNama = InputUtil.inputS("Nama baru (kosongkan untuk tidak mengubah)");
//        var newAlamat = InputUtil.inputS("Alamat baru (kosongkan untuk tidak mengubah)");
//        var newNoTelepon = InputUtil.inputS("No Telepon baru (kosongkan untuk tidak mengubah)");
//
//        if (!newNama.isEmpty()) existingPemasok.setNama(newNama);
//        if (!newAlamat.isEmpty()) existingPemasok.setAlamat(newAlamat);
//        if (!newNoTelepon.isEmpty()) existingPemasok.setNoTelepon(newNoTelepon);
//
//        // Call the service to update
//        pemasokService.editPemasok(existingPemasok);
//        System.out.println("Data Pemasok berhasil diperbarui.");
    }

    public void removeBarang() {
//        System.out.println("Menghapus Data Pemasok");
//
//        int id = InputUtil.inputI("Masukkan ID pemasok yang akan dihapus | (0 untuk batal) ");
//
//        if(id == 0){
//            System.out.println("Penghapusan dibatalakan");
//            return;
//        }
//
//        pemasokService.deletePemasok(id);
    }



}
