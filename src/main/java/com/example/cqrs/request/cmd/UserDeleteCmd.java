package com.example.cqrs.request.cmd;

import com.example.cqrs.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDeleteCmd implements Request<Void> {
    private Integer id;
}
