package EventBooking.app.util;

import EventBooking.app.data.models.User;

public class Mapper {
    public static User userMap(String name, String email, String password){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        return user;

    }
}
