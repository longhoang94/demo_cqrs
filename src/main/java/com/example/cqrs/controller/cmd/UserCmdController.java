package com.example.cqrs.controller.cmd;

import com.example.cqrs.mediator.Mediator;
import com.example.cqrs.request.cmd.UserCreateCmd;
import com.example.cqrs.request.cmd.UserDeleteCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserCmdController {
    private final Mediator mediator;

    public UserCmdController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(UserCreateCmd cmd) {
        mediator.send(cmd);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam Integer id) {
        mediator.send(new UserDeleteCmd(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
