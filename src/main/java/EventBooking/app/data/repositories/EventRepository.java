package EventBooking.app.data.repositories;

import EventBooking.app.data.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

    Event findEventByName(String name);
}
