package EventBooking.app.dtos.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CreateEventRequest {

    private String name;
    private LocalDateTime dateTime;
    private int attendees;
    private String description;
    private String category;
}
