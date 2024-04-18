package EventBooking.app.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime date;
    private String description;
    private int attendeeCount;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private User user;

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", dateTime=" + date +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }
}
