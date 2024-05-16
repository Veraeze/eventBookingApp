package EventBooking.app.data.repositories;

import EventBooking.app.data.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {

    Optional<Event> findEventByName(String name);
}
