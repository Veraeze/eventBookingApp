package EventBooking.app.services;

import EventBooking.app.data.models.Category;
import EventBooking.app.data.repositories.UserRepository;
import EventBooking.app.exception.BookingException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Validate {

    private final UserRepository userRepository;

    public static void validateName(String name) throws BookingException {
        if (name == null || name.trim().isEmpty()) {
            throw new BookingException("{\"error\": \"username field cannot be empty\"}");
        }
        if (name.length() > 100) {
            throw new BookingException("name must not exceed 100 number of characters");
        }
    }

    public static void validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new BookingException("{\"error\": \"email field is empty\"}");
        }
        if (!email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            throw new BookingException("{\"error\": \"invalid email format\"}");
        }
    }

    public static void validatePassword(String password) throws BookingException {
        if (password == null || password.trim().isEmpty()) {
            throw new BookingException("{\"Error\": \"password field is empty, kindly provide your password\"}");
        }

        if (!password.matches("^(?=.*[a-z][A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()+.=-])(?!.*\\s).{8,}$")) {
            throw new BookingException("{\"Error\": \"password must contain a minimum of 8 characters including letters,numbers and characters\"}");
        }
    }

    public static void validateAttendeeCount(int attendeeCount) throws BookingException{
        String attendee = String.valueOf(attendeeCount);

        if (attendee.trim().isEmpty()){
            throw new BookingException("Error: field empty! kindly provide the number of attendees");
        }
        if (attendeeCount < 0){
            throw new BookingException("number of attendee cannot be less than 0");
        }
    }

    public static void validateDescription(String description) throws BookingException{
        if (description == null || description.trim().isEmpty()){
           throw new BookingException("Error: empty field! kindly provide event description");
        }
        if (description.length() > 500){
            throw new BookingException("length of characters cannot exceed 500");
        }
    }

    public static Category validateCategory(String category){
        for (Category categories: Category.values()){
            if (categories.name().equalsIgnoreCase(category)) return categories;
        }
        return null;
    }
}
