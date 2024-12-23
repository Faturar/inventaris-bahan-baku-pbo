package view;


import entity.BarangMasukKeluar;
import service.BarangMasukKeluarService;
import service.BarangService;
import util.InputUtil;

public class BarangMasukKeluarView {

    private BarangMasukKeluarService barangMasukKeluarService;
    private BarangService barangService;

    public BarangMasukKeluarView(BarangMasukKeluarService barangMasukKeluarService, BarangService barangService) {
        this.barangMasukKeluarService = barangMasukKeluarService;
        this.barangService = barangService;
    }
    public void showBarangMasuk(){

        while (true){

            System.out.println("========================= BARANG MASUK =========================");
            System.out.println("Menu :  ");
            System.out.println("1.Data Barang Masuk");
            System.out.println("2.Tambah");
            System.out.println("3.Hapus");
            System.out.println("x.Menu Utama");
            System.out.println("=================================================================");

            var input = InputUtil.inputS("Pilih");
            if(input.equals("1")){
                showDataBarangMasuk();
            }else if(input.equals("2")) {
                addBarangMasuk();
            }else if(input.equals("3")){
                removeBarangMasuk();
            }else if(input.equals("x")){
                break;
            }else{
                System.out.println("Pilihan tidak dimengerti");
            }

        }
    }
    public void showDataBarangMasuk(){
        barangMasukKeluarService.showBarangMasuk();
    }

    public void addBarangMasuk(){
        barangService.showBarangKd();
        String kdBarang = InputUtil.inputS("Masukkan kode barang ");
        int jumlah = InputUtil.inputI("Masukkan jumlah barang ");

        int year = InputUtil.inputI("Masukkan tahun");
        int month = InputUtil.inputI("Masukkan bulan");
        int day = InputUtil.inputI("Masukkan tanggal");
        java.sql.Date sqlDate = new java.sql.Date(year - 1900, month -1,day );

        // Create a Pemasok object and set its attributes
        BarangMasukKeluar barangMasukKeluarData = new BarangMasukKeluar();
        barangMasukKeluarData.setKdBarang(kdBarang);
        barangMasukKeluarData.setJumlah(jumlah);
        barangMasukKeluarData.setTanggal(sqlDate);

        System.out.println(barangMasukKeluarData);

        // Add pemasok using the service layer
        barangMasukKeluarService.addBarangMasuk(barangMasukKeluarData);

    }


    public void removeBarangMasuk(){
        System.out.println("Menghapus Data Barang Masuk");
        barangMasukKeluarService.showBarangMasuk();
        int id = InputUtil.inputI("Masukkan ID yang akan dihapus | (0 untuk batal) ");

        if(id == 0){
            System.out.println("Penghapusan dibatalakan");
            return;
        }

        barangMasukKeluarService.deleteBarangMasuk(id);
    }





    public void showBarangKeluar(){

        while (true){

            System.out.println("========================= BARANG KELUAR =========================");
            System.out.println("Menu :  ");
            System.out.println("1.Data Barang Keluar");
            System.out.println("2.Tambah");
            System.out.println("3.Hapus");
            System.out.println("x.Menu Utama");
            System.out.println("=================================================================");

            var input = InputUtil.inputS("Pilih");
            if(input.equals("1")){
                showDataBarangKeluar();
            }else if(input.equals("2")) {
                addBarangKeluar();
            }else if(input.equals("3")){
                removeBarangKeluar();
            }else if(input.equals("x")){
                break;
            }else{
                System.out.println("Pilihan tidak dimengerti");
            }

        }
    }

    private void showDataBarangKeluar() {
        barangMasukKeluarService.showBarangKeluar();
    }

    public void addBarangKeluar(){
        barangService.showBarangKd();
        String kdBarang = InputUtil.inputS("Masukkan kode barang: ");
        int jumlah = InputUtil.inputI("Masukkan jumlah barang: ");

        int year = InputUtil.inputI("Masukkan tahun");
        int month = InputUtil.inputI("Masukkan bulan");
        int day = InputUtil.inputI("Masukkan tanggal");
        java.sql.Date sqlDate = new java.sql.Date(year - 1900, month -1,day );

        // Create a Pemasok object and set its attributes
        BarangMasukKeluar barangMasukKeluarData = new BarangMasukKeluar();
        barangMasukKeluarData.setKdBarang(kdBarang);
        barangMasukKeluarData.setJumlah(jumlah);
        barangMasukKeluarData.setTanggal(sqlDate);

        System.out.println(barangMasukKeluarData);

        // Add pemasok using the service layer
        barangMasukKeluarService.addBarangKeluar(barangMasukKeluarData);
    }


    public void removeBarangKeluar(){
        System.out.println("Menghapus Data Barang Keluar");
        barangMasukKeluarService.showBarangKeluar();
        int id = InputUtil.inputI("Masukkan ID   yang akan dihapus | (0 untuk batal) ");

        if(id == 0){
            System.out.println("Penghapusan dibatalakan");
            return;
        }

        barangMasukKeluarService.deleteBarangKeluar(id);
    }

}
