package EventBooking.app.dtos.response;

import EventBooking.app.data.models.Event;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SearchEventResponse {
    private Event event;
}
