package EventBooking.app.dtos.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class RegisterResponse {
    private Long id;

    @Override
    public String toString() {
        return "LiberianRegisterResponse{" +
                "id=" + id +
                '}';
    }

}
