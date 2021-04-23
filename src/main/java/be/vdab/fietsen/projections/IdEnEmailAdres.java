package be.vdab.fietsen.projections;

public class IdEnEmailAdres {
    private final long id;
    private final String emailAdres;

    public IdEnEmailAdres(long id, String emailAdres) {
        this.id = id;
        this.emailAdres = emailAdres;
    }

    public long getId() {
        return id;
    }

    public String getEmailAdres() {
        return emailAdres;
    }
}
