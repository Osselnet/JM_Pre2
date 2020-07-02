package web.service;

import web.dao.UserDao;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.add(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }
}
