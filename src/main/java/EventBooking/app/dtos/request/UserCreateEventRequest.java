package EventBooking.app.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateEventRequest {
    private String eventName;
    private String description;
    private String email;
    private String date;
    private Integer attendeeCount;
    private String category;
}
