package com.example.cqrs.handler.query;

import com.example.cqrs.dto.UserDTO;
import com.example.cqrs.mediator.RequestHandler;
import com.example.cqrs.repository.UserReadRepository;
import com.example.cqrs.request.query.UserDetailQuery;
import org.springframework.stereotype.Component;

@Component
public class UserDetailHandler implements RequestHandler<UserDetailQuery, UserDTO> {

    @Override
    public UserDTO handle(UserDetailQuery request) {
        return UserReadRepository.findByUsername(request.getUsername());
    }
}
