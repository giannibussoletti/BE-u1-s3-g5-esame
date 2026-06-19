package giannibussoletti.dao;

import giannibussoletti.entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class PrestitoDAO {
    private final EntityManager entityManager;

    public PrestitoDAO(EntityManager em) {
        this.entityManager = em;
    }

    public void save(Prestito newPrestito) {
        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        this.entityManager.persist(newPrestito);

        transaction.commit();

        System.out.println("Prestito salvato correttamente");
    }

    public void setReturnDate(LocalDate newDataRestituzioneEffettiva, String idPrestito) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("UPDATE Prestito p SET p.dataRestituzioneEffettiva = :newDataRestituzioneEffettiva WHERE p.id= :idPrestito");
        query.setParameter("newDataRestituzioneEffettiva", newDataRestituzioneEffettiva);
        query.setParameter("idPrestito", UUID.fromString(idPrestito));
        query.executeUpdate();
        transaction.commit();
        System.out.println("Data aggiornata correttamente");
    }

    public List<Prestito> findExpiredDate() {
        TypedQuery<Prestito> query = entityManager.createQuery("SELECT p FROM Prestito p WHERE (p.dataRestituzione < :todayDate) AND (p.dataRestituzioneEffettiva IS NULL)", Prestito.class);
        query.setParameter("todayDate", LocalDate.now());
        return query.getResultList();
    }

    public List<Prestito> findBYCardNumber(int numeroTessera) {
        TypedQuery<Prestito> query = entityManager.createQuery("SELECT p FROM Prestito p JOIN p.utente u WHERE (u.numeroTessera = :numeroTessera) AND (p.dataRestituzioneEffettiva IS NULL)", Prestito.class);
        query.setParameter("numeroTessera", numeroTessera);
        return query.getResultList();
    }
}
