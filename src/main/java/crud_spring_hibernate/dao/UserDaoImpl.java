package crud_spring_hibernate.dao;

import crud_spring_hibernate.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUserList() {
        return entityManager.createQuery("from User").getResultList();

    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUser(int id) {
        Query query = entityManager.createQuery("from User where id = :id");
        return (User) query.setParameter("id", id).getSingleResult();
    }

    @Override
    public void removeUser(int id) {
        entityManager.remove(getUser(id));
    }

}
