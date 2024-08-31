package EventBooking.app.dtos.response;

import EventBooking.app.data.models.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    private Long ticketId;
    private String eventName;
    private int RSVP;
    private LocalDate date;
    private Reservation status;
}
