package giannibussoletti.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String id) {
        super("Il record con id " + id + " non è stato trovato!");
    }
}
