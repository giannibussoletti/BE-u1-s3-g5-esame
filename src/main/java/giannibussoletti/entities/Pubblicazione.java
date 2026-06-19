package giannibussoletti.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "pubblicazioni")
@DiscriminatorColumn(name = "tipo_pubblicazione")
public abstract class Pubblicazione {

    @Id
    @GeneratedValue
    @Column(name = "id_pubblicazione", nullable = false)
    private UUID id;
    @Column(nullable = false)
    private String isbn;
    @Column(nullable = false)
    private String titolo;
    @Column(name = "anno_di_pubblicazione", nullable = false)
    private int annoPubblicazione;
    @Column(name = "numero di pagine", nullable = false)
    private int numeroPagine;

    protected Pubblicazione() {
    }

    public Pubblicazione(String isbn, String titolo, int annoPubblicazione, int numeroPagine) {
        this.isbn = isbn.replace(" ", "");
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;

    }

    @Override
    public String toString() {
        return "id: " + id + "\n" +
                "ISBN: " + isbn + '\n' +
                "titolo: " + titolo + '\n' +
                "anno di pubblicazione: " + annoPubblicazione + "\n" +
                "numero totale di pagine: " + numeroPagine;
    }
}
