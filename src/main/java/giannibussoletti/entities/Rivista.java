package giannibussoletti.entities;

import giannibussoletti.exceptions.Periodico;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("rivista")
public class Rivista extends Pubblicazione {
    @Column(name = "periodicità", nullable = false)
    @Enumerated(EnumType.STRING)
    private Periodico periodico;


    protected Rivista() {
    }

    public Rivista(String isbn, String titolo, int annoPubblicazione, int numeroPagine, Periodico periodico) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.periodico = periodico;
    }

}
