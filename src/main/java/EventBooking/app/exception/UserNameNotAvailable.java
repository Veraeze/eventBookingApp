package EventBooking.app.exception;

public class UserNameNotAvailable extends RuntimeException{
    public UserNameNotAvailable(String message) {
        super(message);
    }
}
