package giannibussoletti;

import giannibussoletti.dao.PrestitoDAO;
import giannibussoletti.dao.PubblicazioneDAO;
import giannibussoletti.dao.UtenteDAO;
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
//        Pubblicazione ilSospetto = new Libro("8845936732", "Il Sospetto", 2022, 120, "Friedrich Durrenmatt", Genere.ROMANZO_AVVENTURA);
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

//        Utente gianlucaFRomDB = uteDAO.findById("758fc34e-6e8d-421d-97c8-263915d8acc6");
//        Utente federicaFRomDB = uteDAO.findById("8a4f9661-e1f3-4fc6-8819-194e22845e6f");
//        Utente gianniFRomDB = uteDAO.findById("a01767be-83dc-4b28-9903-a1a120614bdd");
//        Utente marioFRomDB = uteDAO.findById("e86714b9-c6db-4474-9774-1c84cff57d9f");
//
//        Pubblicazione ruotaAnnoFromDB = pubDAO.findById("07c9a2d0-cf05-4d61-86cc-51f2f34cac7a");
//        Pubblicazione ilSospettoFromDB = pubDAO.findById("33b1eb51-6ecf-4375-bfa9-e88e253c32e9");
//        Pubblicazione ascoltandoIlMondoFromDB = pubDAO.findById("65d476b0-b095-4907-8793-621507019a1f");
//        Pubblicazione sempreLaValleFromDB = pubDAO.findById("70b0af3e-5781-4e6d-b273-eedefc2c8bcc");
//        Pubblicazione passioneAmigaFromDB = pubDAO.findById("889a30b8-936a-4127-99e9-bf9cfff8cb37");
//        Pubblicazione laCittaFromDB = pubDAO.findById("99edd942-cab9-40f1-a72a-e80922e0fb0e");
//        Pubblicazione casePiuBelleFromDB = pubDAO.findById("dd455920-f8aa-4246-8c75-cad65e6e3ce9");
//
//
//        Prestito prestitoUno = new Prestito(gianlucaFRomDB, ruotaAnnoFromDB);
//        Prestito prestitoDue = new Prestito(federicaFRomDB, ilSospettoFromDB);
//        Prestito prestitoTre = new Prestito(gianniFRomDB, ascoltandoIlMondoFromDB);
//        Prestito prestitoQua = new Prestito(marioFRomDB, sempreLaValleFromDB);
//        Prestito prestitoCin = new Prestito(gianlucaFRomDB, passioneAmigaFromDB);
//        Prestito prestitoSei = new Prestito(federicaFRomDB, laCittaFromDB);
//        Prestito prestitoSet = new Prestito(gianniFRomDB, casePiuBelleFromDB);
//        Prestito prestitoOtt = new Prestito(marioFRomDB, ruotaAnnoFromDB);
//        Prestito prestitoNov = new Prestito(gianlucaFRomDB, ilSospettoFromDB);
//
//        prestiDAO.save(prestitoUno);
//        prestiDAO.save(prestitoDue);
//        prestiDAO.save(prestitoTre);
//        prestiDAO.save(prestitoQua);
//        prestiDAO.save(prestitoCin);
//        prestiDAO.save(prestitoSei);
//        prestiDAO.save(prestitoSet);
//        prestiDAO.save(prestitoOtt);
//        prestiDAO.save(prestitoNov);
//
//
//        Funzionante
//        Rimozione di un elemento del catalogo dato un codice ISBN
//        pubDAO.findByISBNandDelete("8845936732");

//        Funzionante
//        Ricerca per ISBN
//        try {
//            pubDAO.findByISBN("88074939692323");
//        } catch (IsbnNotFoundException e) {
//            System.out.println(e.getMessage());
//        }


//        Funzionante
//        Ricerca per anno pubblicazione
//        try {
//            pubDAO.findByYear(2025).forEach(System.out::println);
//        } catch (BookNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
//        Ricerca per autore
//        Funzionante
//        try {
//            pubDAO.findByAuthor("tt").forEach(System.out::println);
//        } catch (BookNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }

//        Ricerca per titolo o parte di esso
//        Funzionante
//        try {
//            pubDAO.findByTitle("ll").forEach(System.out::println);
//        } catch (BookNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }

//        Aggiornamento data di restituzione
//        Funzionante
//        prestiDAO.setReturnDate(LocalDate.of(2026, 7, 30), "ce7215c3-6282-45d0-87ad-c9a233dffa93");

        prestiDAO.findExpiredDate().forEach(System.out::println);
    }
}
