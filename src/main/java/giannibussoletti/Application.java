package giannibussoletti;

import giannibussoletti.dao.PrestitoDAO;
import giannibussoletti.dao.PubblicazioneDAO;
import giannibussoletti.dao.UtenteDAO;
import giannibussoletti.entities.Prestito;
import giannibussoletti.entities.Pubblicazione;
import giannibussoletti.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bes3g5exampu");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        PrestitoDAO prestiDAO = new PrestitoDAO(em);
        UtenteDAO uteDAO = new UtenteDAO(em);
        PubblicazioneDAO pubDAO = new PubblicazioneDAO(em);

//        Utente gianni = new Utente("Gianni", "Rossi", LocalDate.of(1994, 2, 13), 382304820);
//        Utente federica = new Utente("Federica", "Bruno", LocalDate.of(2000, 10, 2), 158932722);
//        Utente mario = new Utente("Mario", "Proietti", LocalDate.of(1998, 5, 3), 548992147);
//        Utente gianluca = new Utente("Gianluca", "Esposito", LocalDate.of(2008, 12, 25), 749476180);
//        uteDAO.save(gianni);
//        uteDAO.save(federica);
//        uteDAO.save(mario);
//        uteDAO.save(gianluca);
//
//        Pubblicazione ruotaAnno = new Libro("8854058173", "La ruota dell’anno. Rituali magici e festività delle streghe", 2025, 160, "Federica Vanini", Genere.FANTASY);
//        Pubblicazione laCitta = new Libro(" 8834744772", "La città e la città ", 2024, 336, "China Miéville", Genere.ROMANZO_FORMAZIONE);
//        Pubblicazione ilSospetto = new Libro(" 8845936732", "Il Sospetto", 2022, 120, "Friedrich Durrenmatt", Genere.ROMANZO_AVVENTURA);
//        Pubblicazione sempreLaValle = new Libro("8804762829", "Sempre la valle ", 2025, 696, "Ursula K. Le Guin", Genere.AZIONE);
//        Pubblicazione casePiuBelle = new Rivista("8894532550", "AD. Le 100 case piu belle d’Italia", 2021, 300, Periodico.SEMESTRALE);
//        Pubblicazione ascoltandoIlMondo = new Rivista("8807493969", "Volume. Ascoltando il mondo. Il Magazine di Chora Media e Feltrinelli. Avere vent'anni (Vol. 2) ", 2026, 144, Periodico.SETTIMANALE);
//        Pubblicazione passioneAmiga = new Rivista("8196398858", "Passione Amiga #31: Maggio 2026: La rivista italiana dedicata al mondo Amiga ", 2022, 47, Periodico.MENSILE);
//        pubDAO.save(ruotaAnno);
//        pubDAO.save(laCitta);
//        pubDAO.save(ilSospetto);
//        pubDAO.save(sempreLaValle);
//        pubDAO.save(casePiuBelle);
//        pubDAO.save(ascoltandoIlMondo);
//        pubDAO.save(passioneAmiga);



    }
}
