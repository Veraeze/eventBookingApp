package EventBooking.app.data.repositories;

import EventBooking.app.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {

    User findUserByEmail(String email);
}
