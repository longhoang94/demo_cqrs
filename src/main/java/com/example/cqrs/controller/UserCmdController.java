package com.example.cqrs.controller;

import com.example.demo.mediator.Mediator;
import com.example.demo.request.UserCreateCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCmdController {
    @Autowired
    private Mediator mediator;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(UserCreateCmd cmd) {
        mediator.send(cmd);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
