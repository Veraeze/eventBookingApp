package EventBooking.app.controller;

import EventBooking.app.dtos.request.UserCreateEventRequest;
import EventBooking.app.dtos.response.ApiResponse;
import EventBooking.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/event")
    ResponseEntity<?> createEvent(@RequestBody UserCreateEventRequest eventRequest) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse<>(userService.createEvent(eventRequest), true));
            }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(exception.getMessage(), false));
        }
    }

}
