package EventBooking.app.services;

import EventBooking.app.data.models.User;
import EventBooking.app.dtos.request.LoginRequest;
import EventBooking.app.dtos.request.RegisterRequest;
import EventBooking.app.dtos.request.UserCreateEventRequest;
import EventBooking.app.dtos.response.CreateEventResponse;
import EventBooking.app.dtos.response.LoginResponse;
import EventBooking.app.dtos.response.RegisterResponse;
import EventBooking.app.exception.BookingException;

public interface UserService {
    RegisterResponse register(RegisterRequest registerrequest);

    CreateEventResponse createEvent(UserCreateEventRequest eventRequest) throws BookingException;
}
