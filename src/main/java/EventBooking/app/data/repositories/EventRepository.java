package EventBooking.app.data.repositories;

import EventBooking.app.data.models.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EventRepository extends MongoRepository<Event, Long> {

    Optional<Event> findEventByName(String name);
}
