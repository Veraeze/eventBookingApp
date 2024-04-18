package EventBooking.app.util;

import EventBooking.app.data.models.Category;
import EventBooking.app.data.models.Event;
import EventBooking.app.data.models.User;

import java.time.LocalDateTime;

public class Mapper {
    public static User userMap(String name, String email, String password){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        return user;

    }

    public static Event eventMap(String name, LocalDateTime dateTime, String description, Category category, int attendees, User user){
        Event event = new Event();

        event.setName(name);
        event.setDate(dateTime);
        event.setDescription(description);
        event.setAttendeeCount(attendees);
        event.setUser(user);
        event.setCategory(category);

        return event;

    }
}
