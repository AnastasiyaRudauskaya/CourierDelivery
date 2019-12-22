package by.project.courierexchange.dao;

import by.project.courierexchange.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;

public class UserDao extends AbstractDao<User> {
    private static final Logger logger = LogManager.getLogger();

    private static final String SQL_SELECT_ALL_USERS =
            "SELECT id, login, password FROM exchange";
    private static final String SQL_SELECT_ABONENT_BY_LOGIN =
            "SELECT id, password FROM exchange WHERE login=?";




    public UserDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<User> findAll() {

        return null;
    }

    @Override
    public User findEntityById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(User entity) {
        return false;
    }

    @Override
    public boolean create(User entity) {
        return false;
    }

    @Override
    public User update(User entity) {
        return null;
    }
}
