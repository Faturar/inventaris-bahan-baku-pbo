package view;


import entity.BarangMasukKeluar;
import service.BarangMasukKeluarService;
import service.BarangService;
import util.InputUtil;

public class BarangMasukKeluarView {

    private BarangMasukKeluarService barangMasukKeluarService;
    private BarangService barangService;

    public BarangMasukKeluarView(BarangService barangService) {
        this.barangService = barangService;
    }
    public BarangMasukKeluarView(BarangMasukKeluarService barangMasukKeluarService) {
        this.barangMasukKeluarService = barangMasukKeluarService;
    }
    public void showBarangMasuk(){

        while (true){

            System.out.println("========================= BARANG MASUK =========================");
            System.out.println("Menu :  ");
            System.out.println("1.Data Barang Masuk");
            System.out.println("2.Tambah");
            System.out.println("3.Edit ");
            System.out.println("4.Hapus");
            System.out.println("x.Menu Utama");

            var input = InputUtil.inputS("Pilih");
            if(input.equals("1")){
                showDataBarangMasuk();
            }else if(input.equals("2")) {
                addBarangMasuk();
            }else if(input.equals("3")){
                editBarangMasuk();
            }else if(input.equals("4")){
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

        barangService.showBarang();
        String kdBarang = InputUtil.inputS("Masukkan kode barang: ");
        int jumlah = InputUtil.inputI("Masukkan jumlah barang: ");


        // Create a Pemasok object and set its attributes
        BarangMasukKeluar barangMasukKeluarData = new BarangMasukKeluar();
        barangMasukKeluarData.setKdBarang(kdBarang);
        barangMasukKeluarData.setJumlah(jumlah);


        // Add pemasok using the service layer
        barangMasukKeluarService.addBarangMasuk(barangMasukKeluarData);

    }
    public void editBarangMasuk(){}
    public void removeBarangMasuk(){
        System.out.println("Menghapus Data Barang Masuk");

        int id = InputUtil.inputI("Masukkan ID   yang akan dihapus | (0 untuk batal) ");

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
            System.out.println("3.Edit ");
            System.out.println("4.Hapus");
            System.out.println("x.Menu Utama");

            var input = InputUtil.inputS("Pilih");
            if(input.equals("1")){
                showDataBarangKeluar();
            }else if(input.equals("2")) {
                addBarangKeluar();
            }else if(input.equals("3")){
                editBarangKeluar();
            }else if(input.equals("4")){
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

    public void addBarangKeluar(){}
    public void editBarangKeluar(){}
    public void removeBarangKeluar(){
        System.out.println("Menghapus Data Barang Keluar");

        int id = InputUtil.inputI("Masukkan ID   yang akan dihapus | (0 untuk batal) ");

        if(id == 0){
            System.out.println("Penghapusan dibatalakan");
            return;
        }

        barangMasukKeluarService.deleteBarangKeluar(id);
    }

}
