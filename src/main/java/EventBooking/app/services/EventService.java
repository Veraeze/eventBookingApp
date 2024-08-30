package EventBooking.app.services;

import EventBooking.app.data.models.User;
import EventBooking.app.dtos.request.CreateEventRequest;
import EventBooking.app.dtos.request.SearchEventRequest;
import EventBooking.app.dtos.response.CreateEventResponse;
import EventBooking.app.dtos.response.SearchEventResponse;
import EventBooking.app.exception.BookingException;

public interface EventService {

    CreateEventResponse createEvent(CreateEventRequest request, User user) throws BookingException;

    SearchEventResponse searchEvent(SearchEventRequest request) throws BookingException;
}
