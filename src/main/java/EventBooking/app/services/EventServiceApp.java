package EventBooking.app.services;

import EventBooking.app.data.models.Category;
import EventBooking.app.data.models.Event;
import EventBooking.app.data.models.User;
import EventBooking.app.data.repositories.EventRepository;
import EventBooking.app.dtos.request.CreateEventRequest;
import EventBooking.app.dtos.request.SearchEventRequest;
import EventBooking.app.dtos.response.CreateEventResponse;
import EventBooking.app.dtos.response.SearchEventResponse;
import EventBooking.app.exception.BookingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static EventBooking.app.services.Validate.*;
import static EventBooking.app.util.Mapper.eventMap;

@Service
@AllArgsConstructor
public class EventServiceApp implements EventService{
    private final EventRepository eventRepository;
    private UserServiceApp userService;

    @Override
    public CreateEventResponse createEvent(CreateEventRequest request) {
        validateName(request.getName());
        validateDescription(request.getDescription());
        validateAttendeeCount(request.getAttendees());

        Optional<Event> optionalEvent = eventRepository.findEventByName(request.getName());
        if (optionalEvent.isEmpty()) {
            throw new BookingException("An event with this name already exist");
        }

        User user = userService.findUserBy(request.getUserId());
        Category category = validateCategory(request.getCategory());

        Event newEvent = eventMap(request.getName(), request.getDateTime(), request.getDescription(), category, request.getAttendees(), user);
        userService.saveUser(user);
        eventRepository.save(newEvent);

        CreateEventResponse response = new CreateEventResponse();
        response.setId(newEvent.getId());
        return response;
    }

    @Override
    public SearchEventResponse searchEvent(SearchEventRequest request) {
        validateName(request.getName());
        Event event = findEvent(request.getName());

        SearchEventResponse response = new SearchEventResponse();
        response.setEvent(event);
        return response;
    }

    private Event findEvent(String name) {
        Optional<Event> optionalEvent = eventRepository.findEventByName(name);

        if (optionalEvent.isEmpty()){
            throw new BookingException("Event not found");
        }

        return optionalEvent.get();

    }
}
