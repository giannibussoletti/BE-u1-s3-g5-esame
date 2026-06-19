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
    private LocalDate dataPrestito;

    @Column(name = "data_restituzione")
    private LocalDate dataRestituzione;

    @Column(name = "data_restituzione_effettiva")
    private LocalDate dataRestituzioneEffettiva;

    protected Prestito() {
    }

    public Prestito(Utente utente, Pubblicazione pubblicazionePrestata, LocalDate dataPrestito) {
        this.utente = utente;
        this.pubblicazionePrestata = pubblicazionePrestata;
        this.dataPrestito = dataPrestito;
    }
}
