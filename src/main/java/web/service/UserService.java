package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    void deleteUser(long id);

    void addUser(User user);

    void update(User user);

    User getUserById(long id);

    User getUserByName(String name);
}
