package crud_spring_hibernate.service;

import crud_spring_hibernate.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<User> getUserList();

    void saveUser(User user);

    User getUser(int id);

    void removeUser(int id);

}
