package service;

import entity.Barang;

public interface BarangService {
    void showBarang();
    void showBarangKd();
    void addBarang(Barang barang);
    void editBarang(Barang barang);
    void addStokBarang(Barang barang);
    void minStokBarang(Barang barang);
    void deleteBarang(String kdBarang);
    Barang findBarangId(String kdBarang);
    void checkExpiredItems();

}
