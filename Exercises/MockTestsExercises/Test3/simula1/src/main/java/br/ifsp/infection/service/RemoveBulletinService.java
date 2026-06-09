package br.ifsp.infection.service;

import br.ifsp.infection.model.Bulletin;
import br.ifsp.infection.persistence.GenericDAO;

import java.util.NoSuchElementException;

public class RemoveBulletinService {
    private final GenericDAO<Integer, Bulletin> repo;

    public RemoveBulletinService(GenericDAO<Integer, Bulletin> repo) {
        this.repo = repo;
    }

    public void remove(int id) {
        if (!repo.existsById(id))
            throw new NoSuchElementException("Bulletin with id " + id + " does not exist.");
        repo.delete(id);
    }

}
