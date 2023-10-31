package com.example.cqrs.request.query;

import com.example.cqrs.dto.UserDTO;
import com.example.cqrs.mediator.Request;

import java.util.List;

public class UserFindAllQuery implements Request<List<UserDTO>> {
}
