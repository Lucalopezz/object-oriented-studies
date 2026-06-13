package br.ifsp.infection.service;

import br.ifsp.infection.model.Bulletin;
import br.ifsp.infection.persistence.BulletinDto;
import br.ifsp.infection.persistence.GenericDAO;

import java.util.Objects;

public class RegisterBulletinService {
    private final GenericDAO<Integer, BulletinDto> repo;

    public RegisterBulletinService(GenericDAO<Integer, BulletinDto> repo) {
        this.repo = repo;
    }

    public void register(Bulletin bulletin) {
        Objects.requireNonNull(bulletin, "Bulletin must not be null.");
        if (repo.existsById(bulletin.getId()))
            throw new EntityAlreadyExistsException("Bulletin already exists: " + bulletin.getId());
        repo.insert(new BulletinDto(
                bulletin.getId(),
                bulletin.getCity(),
                bulletin.getState().toString(),
                bulletin.getInfected(),
                bulletin.getDeaths(),
                bulletin.getIcuRatio(),
                bulletin.getDate().toString())
        );
    }
}
