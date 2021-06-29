package kz.bcc.balatime.timetable.controller.admin;

import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import kz.bcc.balatime.timetable.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/token", produces = APPLICATION_JSON_VALUE)
public class TokenController {
    @ApiOperation(value = "GET PRINCIPAL")
    @GetMapping("/current")
    public ResponseEntity<String> getCurrent1(Principal principal) {
        System.out.println("Current User");
        return ResponseEntity.ok(new Gson().toJson(principal));
    }

//    @ApiOperation(value = "GET PRINCIPAL")
//    @GetMapping("/current")
//    public User getCurrent1(Principal principal) {
//        User user = new User();
//        user.setLogin("Hello User");
//        return user;
//    }


}
