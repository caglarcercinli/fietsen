package be.vdab.fietsen.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Table(name="cursussen")
//@DiscriminatorColumn(name="soort")
public abstract class Cursus {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "binary(16)")
    private UUID id;
    private String naam;

    public Cursus(String naam) {
        this.naam = naam;
        id= UUID.randomUUID();
    }

    protected Cursus() {
    }

    public UUID getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }
}
