package by.project.courierexchange.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public enum ConnectionPool {
    INSTANCE;

    private final Logger logger = LogManager.getLogger();

    private BlockingQueue<Connection> freeConnections;
    private Queue<Connection> givenAwayConnections;

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    private static final String URL ="jdbc:mysql://localhost:3306/exchange?serverTimezone=Europe/Moscow&useSSL=false";

    private final static int DEFAULT_POOl_SIZE = 10;

    ConnectionPool(){
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            logger.error(e);
        }

        freeConnections = new LinkedBlockingDeque<Connection>(DEFAULT_POOl_SIZE);
        givenAwayConnections = new ArrayDeque<Connection>();

       /* for (int i=0;i<DEFAULT_POOl_SIZE;i++){
            freeConnections.add(new )
        }*/

    }

    public Connection getConnection(){
        Connection connection = null;
        try {
            freeConnections.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return connection;// FIXME: 28.10.2019 
    }
    public void closeConnection(Connection connection) {
        freeConnections.offer(connection);
    }

}
