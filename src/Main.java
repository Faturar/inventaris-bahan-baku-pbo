import repository.*;
import service.*;
import view.BarangMasukKeluarView;
import view.BarangView;
import view.MenuView;
import view.PemasokView;

//import  util.DatabaseUtil;
//import  java.sql.Connection;
public class Main {
    public static void main(String[] args) {

// Initialize dependencies for Pemasok
        // Initialize dependencies for Pemasok
        PemasokRepository pemasokRepository = new PemasokRepositoryImpl();
        PemasokService pemasokService = new PemasokServiceImpl(pemasokRepository);
        PemasokView pemasokView = new PemasokView(pemasokService);

        // Initialize dependencies for Barang
        BarangRepository barangRepository = new BarangRepositoryImpl();
        BarangService barangService = new BarangServiceImpl(barangRepository);
        BarangView barangView = new BarangView(barangService);

        // Initialize dependencies for BarangMasukKeluar
        BarangMasukKeluarRepository barangMasukKeluarRepository = new BarangMasukKeluarRepositoryImpl();
        BarangMasukKeluarService barangMasukKeluarService = new BarangMasukKeluarServiceImpl(barangMasukKeluarRepository);
        BarangMasukKeluarView barangMasukKeluarView = new BarangMasukKeluarView(barangMasukKeluarService);

        // Pass dependencies to MenuView
        MenuView menuView = new MenuView(barangView, pemasokView, barangMasukKeluarView);

        // Show the menu
        menuView.menu();












//        Connection connection = null;
//
//        try {
//            // Mendapatkan koneksi ke database
//            connection = DatabaseUtil.getConnection();
//            System.out.println("Koneksi berhasil!");
//
//            // Lakukan operasi database di sini
//
//        } catch (Exception e) {
//            System.out.println("Koneksi gagal: " + e.getMessage());
//        } finally {
//            // Menutup koneksi
//            DatabaseUtil.closeConnection(connection);
//        }
//        System.out.printf("Hello and welcome!");


    }
}