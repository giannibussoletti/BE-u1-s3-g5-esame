package giannibussoletti.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue
    @Column(name = "id_utente", nullable = false)
    private UUID id;
    @Column(name = "nome", nullable = false)
    private String name;
    @Column(name = "cognome", nullable = false)
    private String surname;
    @Column(name = "data_di_nascita", nullable = false)
    private LocalDate dataNascita;
    @Column(name = "numero_tessera", nullable = false)
    private int numeroTessera;

    protected Utente() {
    }

    protected Utente(UUID id, String name, String surname, LocalDate dataNascita, int numeroTessera) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dataNascita = dataNascita;
        this.numeroTessera = numeroTessera;
    }
}
