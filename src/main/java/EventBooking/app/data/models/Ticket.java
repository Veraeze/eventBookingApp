package EventBooking.app.data.models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@Getter
@Document
@ToString
public class Ticket {
    private Long id;
    private String name;
    private int RSVP;
    private Reservation status;
    private String ticketId;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JsonIgnore
//    private User user;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "event_name_id")
//    @JsonIgnore
//    private Event event;
//
//    @Enumerated(EnumType.STRING)
//    private Reservation reserved;
//    private int ticketNumber;
//
//
//    @JsonProperty("ticketId")
//    public String getId() {
//        return id != null ? "TID" + id : null;
//    }
//
//    @JsonProperty("eventName")
//    public String getEventName() {
//        return event != null ? event.getName() : null;
//    }
//
//    @JsonIgnore
//    public Event getEvent(){
//        return event;
//    }
//    @Override
//    public String toString() {
//        return "ReserveTicket{" +
//                "id= TID" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", eventName=" + event +
//                ", ticket=" + ticketNumber +
//                '}';
//    }
}
