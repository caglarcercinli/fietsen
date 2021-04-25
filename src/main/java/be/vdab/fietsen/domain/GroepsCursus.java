package be.vdab.fietsen.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="groepscursussen")
//@DiscriminatorValue("G")
public class GroepsCursus extends Cursus {
    private LocalDate van;
    private LocalDate tot;

    public GroepsCursus( String naam, LocalDate van, LocalDate tot) {
       super(naam);
        this.van = van;
        this.tot = tot;
    }

    protected GroepsCursus() {
    }

    public LocalDate getVan() {
        return van;
    }

    public LocalDate getTot() {
        return tot;
    }
}
