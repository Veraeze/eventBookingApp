package EventBooking.app.data.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@Document
@ToString
public class Event {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate date;
    private String description;
    private int attendeeCount;
//    @Enumerated(EnumType.STRING)
    private Category category;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JsonIgnore
//    private User user;
//
//    @Override
//    public String toString() {
//        return "Event{" +
//                "name='" + name + '\'' +
//                ", dateTime=" + date +
//                ", description='" + description + '\'' +
//                ", category=" + category +
//                '}';
//    }
}
