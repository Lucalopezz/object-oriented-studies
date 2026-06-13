package br.ifsp.infection.service;

import br.ifsp.infection.model.Bulletin;
import br.ifsp.infection.persistence.BulletinDto;
import br.ifsp.infection.persistence.GenericDAO;

import java.util.NoSuchElementException;
import java.util.Objects;

public class UpdateBulletinService {
    private final GenericDAO<Integer, BulletinDto> repo;

    public UpdateBulletinService(GenericDAO<Integer, BulletinDto> repo) {
        this.repo = repo;
    }

    public void update(Bulletin bulletin) {
        Objects.requireNonNull(bulletin, "Bulletin must not be null.");
        if (!repo.existsById(bulletin.getId()))
            throw new NoSuchElementException("Bulletin not found: " + bulletin.getId());
        repo.update(new BulletinDto(
                bulletin.getId(),
                bulletin.getCity(),
                bulletin.getState().toString(),
                bulletin.getInfected(),
                bulletin.getDeaths(),
                bulletin.getIcuRatio(),
                bulletin.getDate().toString()));
    }
}
