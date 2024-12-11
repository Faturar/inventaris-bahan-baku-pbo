package service;

import entity.Pemasok;

public interface PemasokService {

    void showPemasok();

    void addPemasok(Pemasok pemasok);
    void editPemasok(Pemasok pemasok);
    void deletePemasok(int id);
}
