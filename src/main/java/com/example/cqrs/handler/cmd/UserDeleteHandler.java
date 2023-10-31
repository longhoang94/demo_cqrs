package com.example.cqrs.handler.cmd;

import com.example.cqrs.mediator.RequestHandler;
import com.example.cqrs.repository.UserWriteRepository;
import com.example.cqrs.request.cmd.UserDeleteCmd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserDeleteHandler implements RequestHandler<UserDeleteCmd, Void> {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDeleteHandler.class);

    @Override
    public Void handle(UserDeleteCmd request) {
        UserWriteRepository.deleteUserById(request.getId());
        LOGGER.info("delete user successful. user_id = {}", request.getId());

        return null;
    }
}
