package exceptions;

public class CustomUserNotFoundException extends RuntimeException {

    public CustomUserNotFoundException(Long id) {
        super("Could not find user " + id);
    }
}
