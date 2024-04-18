package EventBooking.app.data.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_name_id")
    @JsonIgnore
    private Event event;

    @Enumerated(EnumType.STRING)
    private Reservation reserved;
    private int ticketNumber;


    @JsonProperty("ticketId")
    public String getId() {
        return id != null ? "TID" + id : null;
    }

    @JsonProperty("eventName")
    public String getEventName() {
        return event != null ? event.getName() : null;
    }

    @JsonIgnore
    public Event getEvent(){
        return event;
    }
    @Override
    public String toString() {
        return "ReserveTicket{" +
                "id= TID" + id + '\'' +
                ", name='" + name + '\'' +
                ", eventName=" + event +
                ", ticket=" + ticketNumber +
                '}';
    }
}
