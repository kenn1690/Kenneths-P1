package Servlets;

import Connection.DBConnector;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;

public class DependencyLoaderListener implements ServletContextListener {
    Connection conn;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        conn = DBConnector.getConnection();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DBConnector.close();
    }
}