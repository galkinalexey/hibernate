package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        List<User> userList =  userService.getAllUsers();

        for(User user: userList) {
            System.out.printf(user.toString());
        }

    }
}
