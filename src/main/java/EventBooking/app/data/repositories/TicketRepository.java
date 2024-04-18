package EventBooking.app.data.repositories;

import EventBooking.app.data.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
