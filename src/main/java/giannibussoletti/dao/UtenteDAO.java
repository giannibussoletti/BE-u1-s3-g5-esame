package giannibussoletti.dao;

import giannibussoletti.entities.Utente;
import giannibussoletti.exceptions.UserNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class UtenteDAO {


    private final EntityManager entityManager;

    public UtenteDAO(EntityManager em) {
        this.entityManager = em;
    }

    public void save(Utente newUtente) {
        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        this.entityManager.persist(newUtente);

        transaction.commit();

        System.out.println("Utente salvato correttamente");
    }

    public Utente findById(String id) {
        Utente fromDB = this.entityManager.find(Utente.class, UUID.fromString(id)); // Se non trova niente mi torna NULL
        if (fromDB == null) throw new UserNotFoundException(id);
        return fromDB;
    }
}
