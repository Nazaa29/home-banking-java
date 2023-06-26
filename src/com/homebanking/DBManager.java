package com.homebanking;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_BASE_URL = "jdbc:h2:~/banking_db";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "";

    public static Connection connect() {

        System.out.println("Home Banking Application");

        Connection c = null;
        try {
            Class.forName(DB_DRIVER); // La carga a memoria
        } catch (ClassNotFoundException e) {  // Excepcion por si se tipeo mal el driver
            e.printStackTrace();  // Veo que paso
            System.exit(0);
        }
        try {
            c = DriverManager.getConnection(DB_BASE_URL, DB_USERNAME, DB_PASSWORD); // Hago la conexion a la base de datos
            System.out.println("Database connectes: " + !c.isClosed());
            c.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }

        return c;
    }
}
