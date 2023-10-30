package com.example.cqrs.handler;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.mediator.RequestHandler;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.UserCreateCmd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserCreateHandler implements RequestHandler<UserCreateCmd, Void> {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserCreateHandler.class);
    @Override
    public Void handle(UserCreateCmd request) {
        int id = UserRepository.USER_LIST.size() + 1;
        UserRepository.addUser((new User(id, "User_" + id, new Role(id, "ROLE_" + id))));
        LOGGER.info("create user successful. user_id = {}", id);
        return null;
    }
}
