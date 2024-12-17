package view;

import entity.Barang;
import service.BarangService;
import util.InputUtil;

import java.sql.Date;
import java.time.LocalDate;

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

        int year = InputUtil.inputI("Masukkan tahun");
        int month = InputUtil.inputI("Masukkan bulan");
        int day = InputUtil.inputI("Masukkan tanggal");
        java.sql.Date sqlDate = new java.sql.Date(year - 1900, month -1,day );
        
        int idPemasok = InputUtil.inputI("Masukkan ID pemasok: ");

        // Create a Pemasok object and set its attributes
        Barang barangData = new Barang();
        barangData.setKdBarang(kdBarang);
        barangData.setNama(nama);
        barangData.setKategori(kategori);
        barangData.setStok(stok);
        barangData.setStokMinimum(stokMinimum);
        barangData.setTanggalKadaluarsa(sqlDate);
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
        System.out.println("Mengubah Data Barang");

        // Input kode barang yang ingin diedit
        var kodeBarang = InputUtil.inputS("Kode Barang yang ingin diedit | (x untuk batal)");
        if (kodeBarang.equalsIgnoreCase("x")) {
            System.out.println("Batal mengedit barang.");
            return;
        }

        // Cari barang berdasarkan kode barang
        Barang existingBarang = barangService.findBarangId(kodeBarang);
        if (existingBarang == null) {
            System.err.println("Barang dengan kode " + kodeBarang + " tidak ditemukan.");
            return;
        }

        // Tampilkan data barang saat ini
        System.out.println("Data barang saat ini:");
        System.out.println("Kode Barang   : " + existingBarang.getKdBarang());
        System.out.println("Nama          : " + existingBarang.getNama());
        System.out.println("Kategori      : " + existingBarang.getKategori());
        System.out.println("Tanggal Kadaluars      : " + existingBarang.getTanggalKadaluarsa());
        System.out.println("ID Pemasok    : " + existingBarang.getIdPemasok());

        // Input nilai baru (biarkan kosong untuk tidak mengubah)
        //var newKdBarang = InputUtil.inputS("Kode Barang baru (kosongkan untuk tidak mengubah)");
        var newNama = InputUtil.inputS("Nama baru (kosongkan untuk tidak mengubah)");
        var newKategori = InputUtil.inputS("Kategori baru (kosongkan untuk tidak mengubah)");

        int newYear = InputUtil.inputI("Masukkan tahun");
        int newMonth = InputUtil.inputI("Masukkan bulan");
        int newDay = InputUtil.inputI("Masukkan tanggal");

        var newIdPemasokStr = InputUtil.inputS("ID Pemasok baru (kosongkan untuk tidak mengubah)");


        java.sql.Date sqlDate = new java.sql.Date(newYear - 1900, newMonth -1,newDay );
        //barangData.setTanggalKadaluarsa(sqlDate);

        // Validasi dan terapkan perubahan
        //if (!newKdBarang.isEmpty()) existingBarang.setNama(newKdBarang);
        if (!newNama.isEmpty()) existingBarang.setNama(newNama);
        if (!newKategori.isEmpty()) existingBarang.setKategori(newKategori);
        existingBarang.setKategori(String.valueOf(sqlDate));

        if (!newIdPemasokStr.isEmpty()) {
            try {
                int newIdPemasok = Integer.parseInt(newIdPemasokStr);
                existingBarang.setIdPemasok(newIdPemasok);
            } catch (NumberFormatException e) {
                System.err.println("ID Pemasok tidak valid. Harus berupa angka.");
                return;
            }
        }

        // Panggil service untuk memperbarui data
        barangService.editBarang(existingBarang);
        System.out.println("Data Barang berhasil diperbarui.");
    }

    public void removeBarang() {
        System.out.println("Menghapus Data Barang");

        String kdBarang = InputUtil.inputS("Masukkan Kode Barang  yang akan dihapus | (0 untuk batal) ");

        if(kdBarang == "0"){
            System.out.println("Penghapusan dibatalakan");
            return;
        }

        barangService.deleteBarang(kdBarang);
    }



}
