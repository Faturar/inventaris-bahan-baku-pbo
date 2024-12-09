package service;

import entity.Pemasok;

public interface PemasokService {

    void showPemasok();

    void add(Pemasok pemasok);
    void edit(Pemasok pemasok);
    void delete(int id);
}
