package view;

import service.PemasokService;
import util.InputUtil;

public class PemasokView {

    private  PemasokService pemasokService;

    public PemasokView(PemasokService pemasokService) {
        this.pemasokService = pemasokService;
    }
    public void showPemasok(){
        pemasokService.showPemasok();
        while (true){
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

        }else{
            //pemasokService.addPemasok(pemasok);
        }
    }

    private void editPemasok() {
    }

    public void removePemasok() {
    }



}
