package com.example.cqrs.controller.query;

import com.example.cqrs.dto.UserDTO;
import com.example.cqrs.mediator.Mediator;
import com.example.cqrs.request.query.UserDetailQuery;
import com.example.cqrs.request.query.UserFindAllQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserQueryController {
    private final Mediator mediator;

    public UserQueryController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping("/findByUsername")
    public ResponseEntity<?> getUserByUsername(@RequestParam String username) {
        UserDTO user = mediator.send(new UserDetailQuery(username));
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> getAllUser() {
        List<UserDTO> users = mediator.send(new UserFindAllQuery());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
