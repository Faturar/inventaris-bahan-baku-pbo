package view;

import util.InputUtil;
public class MenuView {

    private BarangView barangView;
    private PemasokView pemasokView;
    private BarangMasukKeluarView barangMasukKeluarView;

    // Constructor for dependency injection
    public MenuView(BarangView barangView, PemasokView pemasokView, BarangMasukKeluarView barangMasukKeluarView) {
        this.barangView = barangView;
        this.pemasokView = pemasokView;
        this.barangMasukKeluarView = barangMasukKeluarView;
    }
    public void menu(){

        while (true) {
            System.out.println("===================== INVENTARIS TOKO PIZZA =====================");
            System.out.println("Menu :  ");
            System.out.println("1. Barang Masuk");
            System.out.println("2. Barang Keluar");
            System.out.println("3. Data Barang");
            System.out.println("4. Data Pemasok");
            System.out.println("5. Report (Hari/Minggu/Bulan)");
            System.out.println("x. Keluar");

            var input = InputUtil.inputS("Pilih");
            switch (input) {
                case "1":
                    barangMasukKeluarView.showBarangMasuk();
                    break;
                case "2":
                    barangMasukKeluarView.showBarangKeluar();
                    break;
                case "3":
                    barangView.showBarang();
                    break;
                case "4":
                    pemasokView.showPemasok();
                    break;
                case "x":
                    System.out.println("Keluar dari aplikasi...");
                    return;
                default:
                    System.out.println("Pilihan tidak dimengerti.");
                    break;
            }
        }
    }
}
