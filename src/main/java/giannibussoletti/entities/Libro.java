package giannibussoletti.entities;

import giannibussoletti.enums.Genere;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("libro")
public class Libro extends Pubblicazione {
    private String autore;
    @Enumerated(EnumType.STRING)
    private Genere genere;

    protected Libro() {
    }

    public Libro(String isbn, String titolo, int annoPubblicazione, int numeroPagine, String autore, Genere genere) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;

    }
}
