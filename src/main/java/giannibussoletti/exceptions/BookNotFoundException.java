package giannibussoletti.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String id) {
        super("La pubblicazione con id " + id + " non è stata trovata");
    }



}
