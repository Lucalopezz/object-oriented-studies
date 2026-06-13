package br.ifsp.infection.service;

import br.ifsp.infection.model.Bulletin;
import br.ifsp.infection.persistence.BulletinDto;
import br.ifsp.infection.persistence.GenericDAO;

import java.util.NoSuchElementException;

public class RemoveBulletinService {
    private final GenericDAO<Integer, BulletinDto> repo;

    public RemoveBulletinService(GenericDAO<Integer, BulletinDto> repo) {
        this.repo = repo;
    }

    public void remove(int id) {
        if (!repo.existsById(id)) throw new NoSuchElementException("Bulletin not found: " + id);
        repo.delete(id);
    }
}
