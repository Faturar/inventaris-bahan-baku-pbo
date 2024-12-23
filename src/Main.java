import repository.*;
import service.*;
import view.BarangMasukKeluarView;
import view.BarangView;
import view.MenuView;
import view.PemasokView;
public class Main {
    public static void main(String[] args) {


        // Initialize dependencies for Pemasok
        PemasokRepository pemasokRepository = new PemasokRepositoryImpl();
        PemasokService pemasokService = new PemasokServiceImpl(pemasokRepository);
        PemasokView pemasokView = new PemasokView(pemasokService);

        // Initialize dependencies for Barang
        BarangRepository barangRepository = new BarangRepositoryImpl();
        BarangService barangService = new BarangServiceImpl(barangRepository);
        BarangView barangView = new BarangView(barangService, pemasokService);

        // Initialize dependencies for BarangMasukKeluar
        BarangMasukKeluarRepository barangMasukKeluarRepository = new BarangMasukKeluarRepositoryImpl();
        BarangMasukKeluarService barangMasukKeluarService = new BarangMasukKeluarServiceImpl(barangMasukKeluarRepository);
        BarangMasukKeluarView barangMasukKeluarView = new BarangMasukKeluarView(barangMasukKeluarService, barangService);

        // Pass dependencies to MenuView
        MenuView menuView = new MenuView(barangView, pemasokView, barangMasukKeluarView);

        // Show the menu
        menuView.menu();


    }
}