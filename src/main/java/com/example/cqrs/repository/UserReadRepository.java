package com.example.cqrs.repository;

import com.example.cqrs.util.UserUtil;
import com.example.cqrs.dto.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UserReadRepository {

    public static UserDTO findByUsername(String username) {
        return UserUtil.getUsers()
                .stream()
                .filter(x -> username.equals(x.getName())).findFirst()
                .map(value -> new UserDTO(value.getName(), value.getRole().getCode()))
                .orElse(null);
    }
    public static List<UserDTO> findAll() {
        return UserUtil.getUsers().stream().map(value -> new UserDTO(value.getName(), value.getRole().getCode())).collect(Collectors.toList());
    }

}
