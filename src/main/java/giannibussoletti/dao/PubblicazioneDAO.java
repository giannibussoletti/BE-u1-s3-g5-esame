package giannibussoletti.dao;

import giannibussoletti.entities.Pubblicazione;
import giannibussoletti.exceptions.BookNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.UUID;

public class PubblicazioneDAO {

    private final EntityManager entityManager;

    public PubblicazioneDAO(EntityManager em) {
        this.entityManager = em;
    }

    public void save(Pubblicazione newPubblicazione) {
        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        this.entityManager.persist(newPubblicazione);

        transaction.commit();

        System.out.println("Pubblicazione salvato correttamente");
    }

    public Pubblicazione findById(String id) {
        Pubblicazione fromDB = this.entityManager.find(Pubblicazione.class, UUID.fromString(id)); // Se non trova niente mi torna NULL
        if (fromDB == null) throw new BookNotFoundException(id);
        return fromDB;
    }

    public void findByISBNandDelete(String isbn) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("DELETE FROM Pubblicazione p WHERE p.isbn = :isbn");
        query.setParameter("isbn", isbn);
        query.executeUpdate();
        transaction.commit();
        System.out.println("Cancellazione della Pubblicazione avvenuta correttamente");

    }

}
