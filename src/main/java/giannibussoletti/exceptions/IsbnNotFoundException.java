package giannibussoletti.exceptions;

public class IsbnNotFoundException extends RuntimeException {
    public IsbnNotFoundException(String isbn) {
        super("Nessuna pubblicazione con ISBN: " + isbn + " è stata trovata");
    }
}
