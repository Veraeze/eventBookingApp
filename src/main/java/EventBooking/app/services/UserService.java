package EventBooking.app.services;

import EventBooking.app.data.models.User;
import EventBooking.app.dtos.request.LoginRequest;
import EventBooking.app.dtos.request.RegisterRequest;
import EventBooking.app.dtos.response.LoginResponse;
import EventBooking.app.dtos.response.RegisterResponse;

public interface UserService {
    RegisterResponse register(RegisterRequest registerrequest);
}
