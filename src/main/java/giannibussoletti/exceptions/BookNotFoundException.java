package giannibussoletti.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
        super("Nessuna pubblicazione trovata");
    }

    public BookNotFoundException(String id) {
        super("La pubblicazione con id " + id + " non è stata trovata");
    }



}
