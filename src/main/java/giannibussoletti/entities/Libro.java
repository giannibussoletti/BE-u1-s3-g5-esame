package giannibussoletti.entities;

import giannibussoletti.exceptions.Genere;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("libro")
public class Libro extends Pubblicazione {
    @Column(nullable = false)
    private String autore;
    @Column(nullable = false)
    private Genere genere;

    protected Libro() {
    }

    public Libro(String isbn, String titolo, int annoPubblicazione, int numeroPagine, String autore, Genere genere) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;

    }
}
