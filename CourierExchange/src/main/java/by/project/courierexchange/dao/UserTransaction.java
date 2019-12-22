package by.project.courierexchange.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;


public class UserTransaction {
    public static final Logger logger = LogManager.getLogger();

    private Connection connection;
    public void begin(AbstractDao dao,AbstractDao...daos){
        if (connection==null){
            connection = null;// FIXME: 28.10.2019 
        }

        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            logger.error(e);
        }
        dao.setConnection(connection);
        for(AbstractDao daoElement: daos){
            daoElement.setConnection(connection);
        }
    }

    public void end(){
        try {
            //commit
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            logger.error(e);
        }
        //закрыть или о
        connection = null;
    }

    public void commit(){
        try {
            connection.commit();
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    public void rollback(){
        try {
            connection.rollback();
        } catch (SQLException e) {
            logger.error(e);
        }
    }

}
