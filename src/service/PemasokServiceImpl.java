package service;

import entity.Pemasok;
import repository.PemasokRepository;

public class PemasokServiceImpl implements PemasokService{

    private PemasokRepository pemasokRepository;

    public void PemasokRepositoryImpl(PemasokRepository pemasokRepository){
        this.pemasokRepository = pemasokRepository;
    }
    @Override
    public void showPemasok() {

    }

    @Override
    public void add(Pemasok pemasok) {

    }

    @Override
    public void edit(Pemasok pemasok) {

    }

    @Override
    public void delete(int id) {

    }
}
