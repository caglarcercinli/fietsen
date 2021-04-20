package be.vdab.fietsen.repositories;

import be.vdab.fietsen.domain.Docent;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class JpaDocentRepository implements DocentRepository{
    private final EntityManager manager;

    JpaDocentRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<Docent> findById(long id) {
        return Optional.ofNullable(manager.find(Docent.class, id));
    }

    @Override
    public void create(Docent docent) {
        manager.persist(docent);
    }

    @Override
    public void delete(long id) {
        findById(id)
                .ifPresent(docent -> manager.remove(docent));
    }
}
