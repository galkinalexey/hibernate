package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl u = new UserDaoJDBCImpl();
        u.dropUsersTable();
        u.createUsersTable();
        u.saveUser("Alex", "Galkin", (byte) 37);
        u.saveUser("Mari", "Norko", (byte) 18);
        u.saveUser("Yana", "Zaharova", (byte) 28);

        List<User> list = u.getAllUsers();

        for(User user : list) {
            System.out.println(user.toString());
        }

        u.cleanUsersTable();
    }
}
