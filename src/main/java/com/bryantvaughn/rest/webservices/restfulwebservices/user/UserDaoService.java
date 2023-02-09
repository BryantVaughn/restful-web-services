package com.bryantvaughn.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static final List<User> users = new ArrayList<>();
    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Bryant", LocalDate.of(1990, 7, 18)));
        users.add(new User(++usersCount, "Lynn", LocalDate.of(1991, 4, 9)));
        users.add(new User(++usersCount, "Ginger", LocalDate.of(2021, 3, 12)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteOne(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        users.removeIf(predicate);
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
}
