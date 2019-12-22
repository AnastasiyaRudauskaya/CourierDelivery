package by.project.courierexchange.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import by.project.courierexchange.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractDao <T extends User> {
    public static final Logger logger = LogManager.getLogger();

    protected Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    public abstract List<T> findAll();
    public abstract T findEntityById(int id);
    public abstract boolean delete(int id);
    public abstract boolean delete(T entity);
    public abstract boolean create(T entity);
    public abstract T update(T entity);
    public void close(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            logger.error("Can't close connection "+e);
        }
    }

    void setConnection(Connection connection){
        this.connection = connection;
    }
}
