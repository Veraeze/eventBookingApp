package EventBooking.app.services;

import EventBooking.app.data.models.User;
import EventBooking.app.data.repositories.EventRepository;
import EventBooking.app.dtos.request.CreateEventRequest;
import EventBooking.app.dtos.response.CreateEventResponse;
import EventBooking.app.exception.BookingException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest

public class EventTest {
    @Autowired
    private EventRepository eventRepository;
    private CreateEventRequest eventRequest;
    @Autowired
    private EventService eventService;

    @BeforeEach
    public void setUp() {
        eventRequest = new CreateEventRequest();
        eventRequest.setName("SWiT conference");
        eventRequest.setCategory("conference");
        eventRequest.setDateTime(LocalDateTime.parse("16/11/2024"));
    }

    @AfterEach
    public void deleteAllEvents() {
        eventRepository.deleteAll();
    }

    @Test
    public void createEvent() throws BookingException {
        CreateEventRequest eventRequest = new CreateEventRequest();
        eventRequest.setName("Tech conference");
        eventRequest.setCategory("conference");
        eventRequest.setDateTime(LocalDateTime.parse("26/11/2024"));
        eventRequest.setAttendees(50);

        User user = new User();

        CreateEventResponse response = eventService.createEvent(eventRequest, user);
        assertThat(response).isNotNull();
    }
}


