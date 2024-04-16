package EventBooking.app.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ForgotPasswordRequest {
    private String username;
    private String password;
}
