package EventBooking.app.services;

import EventBooking.app.data.models.User;
import EventBooking.app.data.repositories.UserRepository;
import EventBooking.app.dtos.request.RegisterRequest;
import EventBooking.app.dtos.request.UserCreateEventRequest;
import EventBooking.app.dtos.response.CreateEventResponse;
import EventBooking.app.dtos.response.RegisterResponse;
import EventBooking.app.exception.BookingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static EventBooking.app.services.Validate.*;


@Service
@AllArgsConstructor
public class  UserServiceApp implements UserService {

//    private UserRepository userRepository;


    @Override
    public RegisterResponse register(RegisterRequest request) {
//        validateName(request.getName());
//        validateEmail(request.getEmail());
//        validatePassword(request.getPassword());
//
//        if (emailExist(request.getEmail())){
//            throw new BookingException("A user with this email already exists, kindly try again with a different email");
//        }
//
//        User user = userMap(request.getName(), request.getEmail(), request.getPassword());
//        userRepository.save(user);

        RegisterResponse response = new RegisterResponse();
//        response.setId(user.getId());

        return response;
    }

    @Override
    public CreateEventResponse createEvent(UserCreateEventRequest eventRequest) throws BookingException {
        return null;
    }

    private boolean emailExist(String email) {
        User user = new User();
        return user != null;
    }

//    public void saveUser(User user){
//        userRepository.save(user);
//    }

//    public User findUserBy(Long userId) throws BookingException {
//        return userRepository.findById(userId).orElseThrow(()->new BookingException("user not found"));
//    }

}
