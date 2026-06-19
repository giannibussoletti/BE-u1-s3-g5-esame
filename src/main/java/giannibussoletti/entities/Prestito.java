package giannibussoletti.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prestiti")
public class Prestito {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_utente", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "id_prestito", nullable = false)
    private Pubblicazione pubblicazionePrestata;

    @Column(name = "data_prestito", nullable = false)
    private LocalDate dataPrestito = LocalDate.now();

    @Column(name = "data_restituzione")
    private LocalDate dataRestituzione = LocalDate.now().plusDays(30);

    @Column(name = "data_restituzione_effettiva")
    private LocalDate dataRestituzioneEffettiva;

    protected Prestito() {
    }

    public Prestito(Utente utente, Pubblicazione pubblicazionePrestata) {
        this.utente = utente;
        this.pubblicazionePrestata = pubblicazionePrestata;
    }

    @Override
    public String toString() {
        return "Prestito:" + "\n" +
                "id: " + id + "\n\n" +
                "utente: " + utente + "\n" +
                "pubblicazione prestata: " + "\n" + pubblicazionePrestata + "\n" +
                "data del prestito: " + dataPrestito + "\n" +
                "data della restituzione: " + dataRestituzione + "\n" +
                "data della restituzione effettiva: " + dataRestituzioneEffettiva + "\n" +
                "...................................";
    }
}
