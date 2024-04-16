package EventBooking.app.services;

import EventBooking.app.data.models.User;
import EventBooking.app.data.repositories.UserRepository;
import EventBooking.app.dtos.request.ForgotPasswordRequest;
import EventBooking.app.dtos.request.LoginRequest;
import EventBooking.app.dtos.request.RegisterRequest;
import EventBooking.app.dtos.response.LoginResponse;
import EventBooking.app.dtos.response.RegisterResponse;
import EventBooking.app.exception.BookingException;
import EventBooking.app.exception.EmailNotAvailable;
import EventBooking.app.exception.UserNameNotAvailable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class BookingApp implements BookingService{

    private final UserRepository userRepository;


    @Override
    public RegisterResponse register(RegisterRequest registerrequest) {
        validateUserNameFieldIsNotEmpty(registerrequest);
        checkEmailFieldIsNotEmpty(registerrequest);
        validateUserName(registerrequest);
        validateEmail(registerrequest);
        validatePassword(registerrequest);
        checkIfUsernameExist(registerrequest);
        checkIfEmailExist(registerrequest);

        User user = new User();

        user.setUsername(registerrequest.getUsername().trim());
        user.setPassword(registerrequest.getPassword().trim());
        user.setEmail(registerrequest.getEmail().trim());
        userRepository.save(user);

        RegisterResponse userRegisterResponse = new RegisterResponse();
        userRegisterResponse.setId(user.getId());

        return userRegisterResponse;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findUserByUsername(request.getUsername().trim());

        if (request.getUsername().isEmpty()){
            throw new BookingException("{\"error\": \"username field cannot be empty\"}");
        }

        if (request.getPassword().isEmpty()){
            throw new BookingException("{\"error\": \"password field cannot be empty\"}");
        }

        if (!userExist(request.getUsername().trim())){
            throw  new BookingException("{\"error\"  : \"username or password invalid!!!\"}");
        }

        if (!(user.getPassword().equals(request.getPassword().trim()))){
            throw new BookingException("{\"error\" : \"username or password invalid\"}");
        }

        userRepository.save(user);

        LoginResponse response = new LoginResponse();
        response.setId(user.getId());

        return response;     }

    private void validateEmail(RegisterRequest request) {
        if (!(request.getEmail().trim().matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$"))) {
            throw new BookingException("{\"error\": \"invalid email format\"}");
        }
    }

    private boolean userExist(String username){
        User user = userRepository.findUserByUsername(username);
        return user != null;
    }
    private void checkIfUsernameExist(RegisterRequest request) throws UserNameNotAvailable {
        if (userExist(request.getUsername())){
            throw new UserNameNotAvailable("{\"error\": \"username exist\"}");
        }
    }
    private void checkIfEmailExist(RegisterRequest request) throws EmailNotAvailable {
        if (userExist(request.getEmail())){
            throw new EmailNotAvailable("{\"error\": \"email exist\"}");
        }
    }

    private void validateUserName(RegisterRequest request) throws BookingException {
        if (!(request.getUsername().trim().matches("^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{5,10}$"))) {
            throw new BookingException("{\"error\": \"Username must contain letters & numbers,with length of 5 - 10.\"}");
        }
    }

    private void validateUserNameFieldIsNotEmpty(RegisterRequest request) throws BookingException {
        if (request.getUsername().trim().isEmpty()){
            throw new BookingException("{\"error\": \"username field cannot be empty\"}");
        }
    }

    private void validatePassword(RegisterRequest request) throws BookingException {
        if (request.getPassword().trim().isEmpty()){
            throw new BookingException("{\"Error\": \"password field is empty, kindly provide your password\"}");
        }

        if (!request.getPassword().matches("^(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()+.=-])(?!.*\\s).{6,11}$")) {
            throw new BookingException("{\"Error\": \"password must contain small letters,numbers,symbols,with length of 6 - 10.\"}");
        }
    }

    private void validateForgotPassword(ForgotPasswordRequest request) throws BookingException {
        if (request.getPassword().trim().isEmpty()){
            throw new BookingException("{\"error\": \"password field is empty, kindly provide your password\"}");
        }

        if (!request.getPassword().matches("^(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()+.=-])(?!.*\\s).{6,11}$")) {
            throw new BookingException("{\"error\": \"password must contain small letters,numbers,symbols,with length of 6 - 10.\"}");
        }
    }

    private void checkEmailFieldIsNotEmpty(RegisterRequest request) throws BookingException {
        if (request.getEmail().trim().isEmpty()){
            throw new BookingException("{\"error\": \"email field is empty\"}");
        }
    }
}
