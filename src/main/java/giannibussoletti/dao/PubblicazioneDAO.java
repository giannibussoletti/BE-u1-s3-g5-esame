package giannibussoletti.dao;

import giannibussoletti.entities.Pubblicazione;
import giannibussoletti.exceptions.BookNotFoundException;
import giannibussoletti.exceptions.IsbnNotFoundException;
import jakarta.persistence.*;

import java.util.List;
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

    public List<Pubblicazione> findByYear(int annoPubblicazione) {
        TypedQuery<Pubblicazione> query = entityManager.createQuery("SELECT p FROM Pubblicazione p WHERE p.annoPubblicazione = :annoPubblicazione", Pubblicazione.class);
        query.setParameter("annoPubblicazione", annoPubblicazione);
        if (query.getResultList().isEmpty()) throw new BookNotFoundException();
        else return query.getResultList();
    }

    public List<Pubblicazione> findByAuthor(String autore) {
        TypedQuery<Pubblicazione> query = entityManager.createQuery("SELECT p FROM Pubblicazione p WHERE LOWER(p.autore) LIKE :autore", Pubblicazione.class);
        query.setParameter("autore", "%" + autore + "%");
        if (query.getResultList().isEmpty()) throw new BookNotFoundException();
        else return query.getResultList();
    }

    public List<Pubblicazione> findByTitle(String titolo) {
        TypedQuery<Pubblicazione> query = entityManager.createQuery("SELECT p FROM Pubblicazione p WHERE LOWER(p.titolo) LIKE :titolo", Pubblicazione.class);
        query.setParameter("titolo", "%" + titolo + "%");
        if (query.getResultList().isEmpty()) throw new BookNotFoundException();
        else return query.getResultList();
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
