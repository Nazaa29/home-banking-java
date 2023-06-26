package com.homebanking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsuarioDAOH2 implements UsuarioDAO{

    @Override
    public void crearUsuario(Usuario usuario) throws UsuarioDuplicadoException {
        int id_usuario = usuario.getId_usuario();
        String nombre= usuario.getNombre();
        String apellido = usuario.getApellido();
        String email= usuario.getEmail();
        String dni = usuario.getDni();
        String password = usuario.getPassword();

        Connection c = DBManager.connect();
        String sql = "INSERT INTO usuarios (email, password, nombre, apellido, id_usuario, dni) " +
                "VALUES ('" + email + "', '" + password + "', '" + nombre + "', '" + apellido + "', " + id_usuario + ", '" + dni + "')";

        ExceptionHandler.crearException(c,sql);
    }


    @Override
    public void borraUsuario(int idUsuario) {
        Connection c = DBManager.connect();
        String sql = "DELETE FROM usuarios WHERE id_usuario = " + idUsuario;
        ExceptionHandler.genericDAOException(c,sql);
    }

    @Override
    public void actualizaUsuario(Usuario usuario) {
        int id_usuario = usuario.getId_usuario();
        String nombre= usuario.getNombre();
        String apellido = usuario.getApellido();
        String email= usuario.getEmail();
        String dni = usuario.getDni();
        String password = usuario.getPassword();

        Connection c = DBManager.connect();
        String sql = "UPDATE usuarios SET email = '" + usuario.getEmail() + "', password = '" + usuario.getPassword() + "', nombre = '" + usuario.getNombre() + "', apellido = '" + usuario.getApellido() + "', dni = '" + usuario.getDni() + "' WHERE id_usuario = " + usuario.getId_usuario();

        ExceptionHandler.genericDAOException(c,sql);
    }


    public static Usuario muestraUsuario(int idUsuario) {
        Connection c = DBManager.connect();
        String sql = "SELECT * FROM usuarios WHERE id_usuario = " + idUsuario;
        ResultSet rs = ExceptionHandler.mostrarException(c,sql);
        try {
            if (rs.next()) {
                int id = rs.getInt("id_usuario");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                Usuario u = new Usuario(id, nombre, apellido, email, dni, password);
                return u;
            } else {
                System.out.println("No se encontró el usuario");
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ExceptionHandler.cerrarConexion(c);
        }

    }

    @Override
    public List<Usuario> listaTodosLosUsuarios() {
        Connection c = DBManager.connect();
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        ResultSet rs = ExceptionHandler.mostrarException(c,sql);
        try{
            while (rs.next()) {
                int id = rs.getInt("id_usuario");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                Usuario u = new Usuario(id, nombre, apellido, email, dni, password);

                listaUsuarios.add(u);
            }
            if (!listaUsuarios.isEmpty()){
                return listaUsuarios;
            }else {
                return Collections.emptyList();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ExceptionHandler.cerrarConexion(c);
        }
    }
}
