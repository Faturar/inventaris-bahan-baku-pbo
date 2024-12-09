package view;

import util.InputUtil;

public class PemasokView {


    public void showPemasok(){
        while (true){

            System.out.println("Menu :  ");
            System.out.println("1.Tambah");
            System.out.println("2.Edit");
            System.out.println("3.Hapus");
            System.out.println("x.Menu Utama");

            var input = InputUtil.inputS("Pilih");
            if(input.equals("1")){
                addTodoList();
            }else if(input.equals("2")){
                editTodoList();
            }else if(input.equals("3")){
                removeTodoList();
            }else if(input.equals("x")){
                break;
            }else{
                System.out.println("Pilihan tidak dimengerti");
            }

        }
    }

    public void addTodoList() {
    }

    private void editTodoList() {
    }

    public void removeTodoList() {
    }



}
