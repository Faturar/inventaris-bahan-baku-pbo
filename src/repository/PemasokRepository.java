package repository;

import entity.Pemasok;
import java.util.List;

public interface PemasokRepository {

    List<Pemasok> getAll();
    void add(Pemasok pemasok);
    void edit(Pemasok pemasok);
    void delete(int id);
    Pemasok findById(int id);



}
