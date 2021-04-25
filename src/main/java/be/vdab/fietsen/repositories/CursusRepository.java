package be.vdab.fietsen.repositories;

import be.vdab.fietsen.domain.Cursus;

import java.util.Optional;
import java.util.UUID;

public interface CursusRepository {
    Optional<Cursus> findById(UUID id);
    void create(Cursus cursus);
}
