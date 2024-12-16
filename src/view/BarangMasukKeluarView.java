package view;

import service.BarangMasukKeluarService;
import service.BarangService;
import util.InputUtil;

public class BarangMasukKeluarView {

    private BarangMasukKeluarService barangMasukKeluarService;

    public BarangMasukKeluarView(BarangMasukKeluarService barangMasukKeluarService) {
        this.barangMasukKeluarService = barangMasukKeluarService;
    }
    public void showBarangMasuk(){

        while (true){
            barangMasukKeluarService.showBarangMasuk();
            System.out.println("Menu :  ");
            System.out.println("1.Tambah");
            System.out.println("2.Edit ");
            System.out.println("3.Hapus");
            System.out.println("x.Menu Utama");

            var input = InputUtil.inputS("Pilih");
            if(input.equals("1")){
                addBarangMasuk();
            }else if(input.equals("2")) {
                editStokMasuk();
            }else if(input.equals("3")){
                removeBarangMasuk();
            }else if(input.equals("x")){
                break;
            }else{
                System.out.println("Pilihan tidak dimengerti");
            }

        }
    }

    public void addBarangMasuk(){}
    public void editStokMasuk(){}
    public void removeBarangMasuk(){}





    public void showBarangKeluar(){

        while (true){
            barangMasukKeluarService.showBarangKeluar();
            System.out.println("Menu :  ");
            System.out.println("1.Tambah");
            System.out.println("2.Edit ");
            System.out.println("3.Hapus");
            System.out.println("x.Menu Utama");

            var input = InputUtil.inputS("Pilih");
            if(input.equals("1")){
                addBarangKeluar();
            }else if(input.equals("2")) {
                editStokKeluar();
            }else if(input.equals("3")){
                removeBarangKeluar();
            }else if(input.equals("x")){
                break;
            }else{
                System.out.println("Pilihan tidak dimengerti");
            }

        }
    }

    public void addBarangKeluar(){}
    public void editStokKeluar(){}
    public void removeBarangKeluar(){}

}
