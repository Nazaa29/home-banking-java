package com.homebanking;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class ExcepcionesTableManager {
    protected void executeStatement(Connection c, String sql) {
        try {
            Statement statement = c.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            handleSQLException(e, c);
        } finally {
            closeConnection(c);
        }
    }

    protected void executeStatementDrop(Connection c, String sql) {
        try {
            Statement statement = c.createStatement();
            statement.execute(sql);
            c.commit();
        } catch (SQLException e) {
            handleSQLException(e, c);
        } finally {
            closeConnection(c);
        }
    }

    protected void handleSQLException(SQLException e, Connection c) {
        try {
            c.rollback();
            e.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    protected void closeConnection(Connection c) {
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
