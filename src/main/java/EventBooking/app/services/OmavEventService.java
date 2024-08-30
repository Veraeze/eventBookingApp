package EventBooking.app.services;

import EventBooking.app.data.models.User;
import EventBooking.app.data.repositories.EventRepository;
import EventBooking.app.dtos.request.CreateEventRequest;
import EventBooking.app.dtos.request.SearchEventRequest;
import EventBooking.app.dtos.response.CreateEventResponse;
import EventBooking.app.dtos.response.SearchEventResponse;
import EventBooking.app.exception.BookingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OmavEventService implements EventService{
    private EventRepository eventRepository;
    private ModelMapper modelMapper;
    private TicketService ticketService;

    @Override
    public CreateEventResponse createEvent(CreateEventRequest request, User user) throws BookingException {
        return null;
    }

    @Override
    public SearchEventResponse searchEvent(SearchEventRequest request) throws BookingException {
        return null;
    }
}
