package repository;

import entity.Barang;


import java.util.List;

public interface BarangRepository {
    List<Barang> getAll();
    void add(Barang barang);
    void edit(Barang barang);
    void delete(String kdBarang);
    Barang findById(String kdBarang);
}
