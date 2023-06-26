package com.homebanking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Collections;

public class ExceptionHandler {
    public static void crearException(Connection c, String sql) throws UsuarioDuplicadoException {
        try {
            Statement s = c.createStatement();
            int filasAfectadas = s.executeUpdate(sql);
            System.out.println("Filas afectadas: " + filasAfectadas);
            c.commit();
        } catch (SQLException e) {
            try {
                if (e.getErrorCode() == 23505) {
                    throw new UsuarioDuplicadoException();
                }
                e.printStackTrace();
                c.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void genericDAOException(Connection c, String sql) {
        try {
            Statement s = c.createStatement();
            int filasAfectadas = s.executeUpdate(sql);
            System.out.println("Filas afectadas: " + filasAfectadas);
            c.commit();
        } catch (SQLException e) {
            try {
                e.printStackTrace();
                c.rollback();
            } catch (SQLException e1) {
                e.printStackTrace();
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static ResultSet mostrarException(Connection c, String sql) {
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            try {
                c.rollback();
                e.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }

    public static void cerrarConexion(Connection c){
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

}
