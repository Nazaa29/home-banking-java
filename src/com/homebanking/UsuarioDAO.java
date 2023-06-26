package com.homebanking;

import java.sql.SQLException;

public interface UsuarioDAO {
    void crearUsuario(Usuario usuario) throws SQLException, UsuarioDuplicadoException; //throws com.homebanking.ObjectoDuplicadoException;

    void borraUsuario(int idUsuario);

    void actualizaUsuario(Usuario usuario);

    static Usuario muestraUsuario(int id) {
        return null;
    }

    java.util.List<Usuario> listaTodosLosUsuarios();
}
