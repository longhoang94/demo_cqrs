package com.example.cqrs.repository;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public static final List<User> USER_LIST = generateUserList();

    public static List<User> generateUserList() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(new User(i, "User_ " + i, new Role(i, "ROLE_" + i)));
        }
        return users;
    }

    public static void addUser(User user) {
        USER_LIST.add(user);
    }
}
