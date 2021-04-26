package be.vdab.fietsen.repositories;

import be.vdab.fietsen.domain.Campus;

import java.util.Optional;

public interface CampusRepository {
    void create(Campus campus);
    Optional<Campus> findById(long id);
}
