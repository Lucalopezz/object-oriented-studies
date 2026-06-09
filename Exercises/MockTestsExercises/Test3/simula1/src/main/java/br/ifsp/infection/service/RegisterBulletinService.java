package br.ifsp.infection.service;

import br.ifsp.infection.model.Bulletin;
import br.ifsp.infection.model.EntityAlreadyExistsException;
import br.ifsp.infection.persistence.GenericDAO;

import java.util.Objects;

public class RegisterBulletinService {
    private final GenericDAO<Integer, Bulletin> repo;

    public RegisterBulletinService(GenericDAO<Integer, Bulletin> repo) {
        this.repo = repo;
    }

    public void register(Bulletin bulletin){
        Objects.requireNonNull(bulletin, "Bulletin must not be null.");
        if(repo.existsById(bulletin.getId()))
            throw new EntityAlreadyExistsException("Bulletin already exists "+bulletin.getId());
        repo.insert(bulletin);
    }
}