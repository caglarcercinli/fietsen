package be.vdab.fietsen.repositories;

import be.vdab.fietsen.domain.Docent;

import java.util.Optional;

public interface DocentRepository {
    Optional<Docent> findById(long id);
}
