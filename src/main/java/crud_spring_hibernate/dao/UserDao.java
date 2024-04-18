package crud_spring_hibernate.dao;

import crud_spring_hibernate.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUserList();

    void saveUser(User user);

    User getUser(int id);

    void removeUser(int id);
}
