package EventBooking.app.data.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Document
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "_user")
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String email;
    private String password;
//    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Ticket> tickets;
//    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Event> events = new ArrayList<>();



//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + Id +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", events=" + events +
//                '}';
//    }
}
