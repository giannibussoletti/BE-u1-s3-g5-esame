package giannibussoletti.dao;

import giannibussoletti.entities.Pubblicazione;
import giannibussoletti.exceptions.BookNotFoundException;
import giannibussoletti.exceptions.IsbnNotFoundException;
import jakarta.persistence.*;

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

    public Pubblicazione findByISBN(String isbn) {
        TypedQuery<Pubblicazione> query = entityManager.createQuery("SELECT p FROM Pubblicazione p WHERE p.isbn = :isbn", Pubblicazione.class);
        query.setParameter("isbn", isbn);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            throw new IsbnNotFoundException(isbn);
        }
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
