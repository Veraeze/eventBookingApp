package EventBooking.app.services;

import EventBooking.app.dtos.request.LoginRequest;
import EventBooking.app.dtos.request.RegisterRequest;
import EventBooking.app.dtos.response.LoginResponse;
import EventBooking.app.dtos.response.RegisterResponse;

public interface BookingService {
    RegisterResponse register(RegisterRequest registerrequest);
    LoginResponse login(LoginRequest request);
}
