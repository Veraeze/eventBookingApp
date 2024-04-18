package EventBooking.app.services;

import EventBooking.app.data.models.Category;
import EventBooking.app.data.models.Event;
import EventBooking.app.data.models.User;
import EventBooking.app.data.repositories.EventRepository;
import EventBooking.app.dtos.request.CreateEventRequest;
import EventBooking.app.dtos.response.CreateEventResponse;
import EventBooking.app.exception.BookingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static EventBooking.app.services.Validate.*;
import static EventBooking.app.util.Mapper.eventMap;

@Service
@AllArgsConstructor
public class EventServiceApp implements EventService{
    private final EventRepository eventRepository;
    private UserServiceApp userService;

    @Override
    public CreateEventResponse createEvent(CreateEventRequest request, Long id) throws BookingException {
        validateName(request.getName());
        validateDescription(request.getDescription());
        validateAttendeeCount(request.getAttendees());

        Event event = eventRepository.findEventByName(request.getName());
        if (event != null) {
            throw new BookingException("An event with this name already exist");
        }

        User user = userService.findUserBy(id);
        Category category = validateCategory(request.getCategory());

        event = eventMap(request.getName(), request.getDateTime(), request.getDescription(), category, request.getAttendees(), user);
        userService.saveUser(user);
        eventRepository.save(event);

        CreateEventResponse response = new CreateEventResponse();
        response.setId(event.getId());
        return response;


    }
}
