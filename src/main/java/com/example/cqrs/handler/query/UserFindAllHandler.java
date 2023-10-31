package com.example.cqrs.handler.query;

import com.example.cqrs.dto.UserDTO;
import com.example.cqrs.mediator.RequestHandler;
import com.example.cqrs.repository.UserReadRepository;
import com.example.cqrs.request.query.UserFindAllQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserFindAllHandler implements RequestHandler<UserFindAllQuery, List<UserDTO>> {
    @Override
    public List<UserDTO> handle(UserFindAllQuery request) {
        return UserReadRepository.findAll();
    }
}
