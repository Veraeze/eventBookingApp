package EventBooking.app.util;

import EventBooking.app.data.models.Category;
import EventBooking.app.data.models.Event;
import EventBooking.app.data.models.Ticket;
import EventBooking.app.data.models.User;
import EventBooking.app.dtos.response.BookingResponse;

import java.time.LocalDateTime;

public class Mapper {
    public static BookingResponse map(Ticket ticket, Event event){
        BookingResponse response = new BookingResponse();

        response.setRSVP(ticket.getRSVP());
        response.setTicketId(ticket.getId());
        response.setStatus(ticket.getStatus());
        response.setEventName(event.getName());
        response.setDate(event.getDate());

        return response;
    }
}
