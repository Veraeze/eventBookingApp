package EventBooking.app.services;

import EventBooking.app.dtos.request.CreateEventRequest;
import EventBooking.app.dtos.response.CreateEventResponse;
import EventBooking.app.exception.BookingException;

public interface EventService {
    CreateEventResponse createEvent(CreateEventRequest request, Long id) throws BookingException;
}
