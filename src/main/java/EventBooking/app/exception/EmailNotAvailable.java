package EventBooking.app.exception;

public class EmailNotAvailable extends RuntimeException {
    public EmailNotAvailable(String message){
        super(message);
    }
}
