package br.ifsp.infection.service;

import br.ifsp.infection.model.Bulletin;
import br.ifsp.infection.persistence.GenericDAO;

import java.util.NoSuchElementException;
import java.util.Objects;

public class UpdateBulletinService {
    private final GenericDAO<Integer, Bulletin> repo;

    public UpdateBulletinService(GenericDAO<Integer, Bulletin> repo) {
        this.repo = repo;
    }

    public void update(Bulletin bulletin){
        Objects.requireNonNull(bulletin, "Bulletin must not be null.");
        if(!repo.existsById(bulletin.getId()))
            throw new NoSuchElementException("Bulletin not found: "+ bulletin);
        repo.insert(bulletin);
    }
}
