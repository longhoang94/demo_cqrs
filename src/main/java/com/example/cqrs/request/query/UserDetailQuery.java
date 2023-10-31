package com.example.cqrs.request.query;

import com.example.cqrs.dto.UserDTO;
import com.example.cqrs.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailQuery implements Request<UserDTO> {
    private String username;
}
