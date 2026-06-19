package giannibussoletti.entities;

import giannibussoletti.enums.Periodico;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("rivista")
public class Rivista extends Pubblicazione {
    @Column(name = "periodicità")
    @Enumerated(EnumType.STRING)
    private Periodico periodico;


    protected Rivista() {
    }

    public Rivista(String isbn, String titolo, int annoPubblicazione, int numeroPagine, Periodico periodico) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.periodico = periodico;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "periodico: " + periodico + "\n";
    }
}
