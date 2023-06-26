package com.homebanking;


import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        TableManager tm = new TableManager();
        tm.createUserTable();
        tm.createTipoCuentaTable();
        tm.createCuentaTable();
        tm.createTarjetaDebtioTable();
        tm.createTarjetaCreditoTable();
        tm.createTransferenciaTable();

        UsuarioDAO dao = new UsuarioDAOH2();
        int id_usuario = 1;
        String email = "email1";
        String password = "pass1";
        String apellido = "test1";
        String nombre = "test1";
        String dni = "testdni";
        Usuario aInsertar = new Usuario();
        aInsertar.setApellido(apellido);
        aInsertar.setDni(dni);
        aInsertar.setEmail(email);
        aInsertar.setNombre(nombre);
        aInsertar.setPassword(password);
        aInsertar.setId_usuario(id_usuario);
        try {
            dao.crearUsuario(aInsertar);
        } catch ( Exception e) {
            e.printStackTrace();
        }

        //Modifico
        int id_usuariox = 1;
        String emailx = "emailx";
        String passwordx = "passx";
        String apellidox = "testx";
        String nombrex = "testx";
        String dnix = "testdnix";
        Usuario aModificar = new Usuario();
        aModificar.setApellido(apellidox);
        aModificar.setDni(dnix);
        aModificar.setEmail(emailx);
        aModificar.setNombre(nombrex);
        aModificar.setPassword(passwordx);
        aModificar.setId_usuario(id_usuariox);
        try {
            dao.actualizaUsuario(aModificar);
        } catch ( Exception e) {
            e.printStackTrace();
        }

        // Muestro un usuario

        try{
            System.out.println(dao.muestraUsuario(1));
        }catch (Exception e){
            e.printStackTrace();
        }

        //Muestro todos los usuarios
        try {
            List<Usuario> listaTodosLosUsuarios = dao.listaTodosLosUsuarios();
            System.out.println("Tengo estos usuarios:");
            for (Usuario usuario : listaTodosLosUsuarios){
                System.out.println(usuario);
            }
            System.out.println("-------------");
        }catch (Exception e){
            e.printStackTrace();
        }

        // Elimino un usuario
        try {
            dao.borraUsuario(1);
            System.out.println("Elimino el usuario de id: "+ 1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}