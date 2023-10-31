package com.example.cqrs.handler.cmd;

import com.example.cqrs.util.UserUtil;
import com.example.cqrs.entity.Role;
import com.example.cqrs.entity.User;
import com.example.cqrs.mediator.RequestHandler;
import com.example.cqrs.repository.UserWriteRepository;
import com.example.cqrs.request.cmd.UserCreateCmd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserCreateHandler implements RequestHandler<UserCreateCmd, Void> {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserCreateHandler.class);

    @Override
    public Void handle(UserCreateCmd request) {
        int id = UserUtil.getUsers().size() + 1;
        UserWriteRepository.addUser((new User(id, "User_" + id, new Role(id, "ROLE_" + id))));
        LOGGER.info("create user successful. user_id = {}", id);
        return null;
    }
}
