package com.example.cqrs.repository;

import com.example.cqrs.util.UserUtil;
import com.example.cqrs.entity.User;

import java.util.Objects;

public class UserWriteRepository {

    public static void addUser(User user) {
        UserUtil.getUsers().add(user);
    }

    public static void deleteUserById(Integer id) {
        UserUtil.getUsers().removeIf(x -> Objects.equals(x.getId(), id));
    }
}
