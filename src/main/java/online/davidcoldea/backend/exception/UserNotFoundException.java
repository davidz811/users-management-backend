package online.davidcoldea.backend.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id) {
        super("Cannot find user with id: " + id);
    }
}
