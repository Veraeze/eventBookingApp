package EventBooking.app.data.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Event {
    private String name;
    private LocalDateTime date;
    private String description;
    private Category category;

//     available attendees count (positive integer limited to 1000);
}
