package service;

import entity.Pemasok;

public interface PemasokService {

    void showPemasok();
    void showPemasokId();
    void addPemasok(Pemasok pemasok);
    void editPemasok(Pemasok pemasok);
    void deletePemasok(int id);
    Pemasok findPemasokId(int id);

}
