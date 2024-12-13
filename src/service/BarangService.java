package service;

import entity.Barang;

public interface BarangService {
    void showBarang();

    void addBarang(Barang barang);
    void editBarang(Barang barang);
    void deleteBarang(String kdBarang);
    Barang findBarangId(String kdBarang);

}
