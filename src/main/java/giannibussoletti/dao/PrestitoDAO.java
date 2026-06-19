package giannibussoletti.dao;

import giannibussoletti.entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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

}
