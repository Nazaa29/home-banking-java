package com.homebanking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CuentaDAOH2 implements CuentaDAO{

    @Override
    public void crearCuenta(Cuenta cuenta) throws SQLException {
        String cbu = cuenta.getCbu();
        String alias= cuenta.getAlias();
        double saldo = cuenta.getSaldo();
        Usuario usuario = cuenta.getUsuario();
        int id_usuario = usuario.getId_usuario();
        TipoCuenta tipoCuenta= cuenta.getTipoCuenta();
        int id_tipo_cuenta = tipoCuenta.getTipoCuenta();
        Connection c = DBManager.connect();
        String sql = "INSERT INTO usuarios (cbu, saldo, alias, apellido, id_usuario, tipo_cuenta) " +
                "VALUES ('" + cbu + "', '" + saldo + "', '" + alias + "', '" + id_usuario + "', " + id_usuario + ", '" + id_tipo_cuenta + "')";

        ExceptionHandler.genericDAOException(c,sql);
    }

    @Override
    public void borraCuenta(String cbu) {
        Connection c = DBManager.connect();
        String sql = "DELETE FROM cuenta WHERE cbu = " + cbu;
        ExceptionHandler.genericDAOException(c,sql);
    }

    @Override
    public void actualizaCuenta(Cuenta cuenta) {
        String cbu = cuenta.getCbu();
        String alias= cuenta.getAlias();
        double saldo = cuenta.getSaldo();
        Usuario usuario = cuenta.getUsuario();
        int id_usuario = usuario.getId_usuario();
        TipoCuenta tipoCuenta= cuenta.getTipoCuenta();
        int id_tipo_cuenta = tipoCuenta.getTipoCuenta();

        Connection c = DBManager.connect();
        String sql = "UPDATE usuarios SET saldo = '" + saldo + "', alias = '" + alias + "', id_usuario = '" + id_usuario + "', tipo_cuenta = '" + id_tipo_cuenta + "' WHERE cbu = " + cbu;

        ExceptionHandler.genericDAOException(c,sql);
    }

    @Override
    public Cuenta muestraCuenta(String cbuid) {
        Connection c = DBManager.connect();
        String sql = "SELECT * FROM usuarios WHERE cbu = " + cbuid;
        ResultSet rs = ExceptionHandler.mostrarException(c,sql);
        try {
            if (rs.next()) {
                String cbu = rs.getString("cbu");
                String alias = rs.getString("alias");
                Double saldo = rs.getDouble("saldo");
                int id_usuario = rs.getInt("id_usuario");
                Usuario u = UsuarioDAOH2.muestraUsuario(id_usuario);
                int tipo_cuenta = rs.getInt("tipo_cuenta");
                // falta funcionalidad tipo cuenta
                TipoCuenta t = TipoCuentaDAO.muestraTipoCuenta(tipo_cuenta);
                Cuenta cuenta = new Cuenta(cbu,alias,saldo,u,t);
                return cuenta;
            } else {
                System.out.println("No se encontró la cuenta");
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ExceptionHandler.cerrarConexion(c);
        }
    }

    @Override
    public List<Cuenta> listaTodosLasCuentas() {
        Connection c = DBManager.connect();
        List<Cuenta> listaCuentas = new ArrayList<>();
        String sql = "SELECT * FROM cuenta";
        ResultSet rs = ExceptionHandler.mostrarException(c,sql);
        try{
            while (rs.next()) {
                String cbu = rs.getString("cbu");
                String alias = rs.getString("alias");
                Double saldo = rs.getDouble("saldo");
                int id_usuario = rs.getInt("id_usuario");
                Usuario u = UsuarioDAOH2.muestraUsuario(id_usuario);
                int tipo_cuenta = rs.getInt("tipo_cuenta");
                // falta funcionalidad tipo cuenta
                TipoCuenta t = TipoCuentaDAO.muestraTipoCuenta(tipo_cuenta);
                Cuenta cuenta = new Cuenta(cbu,alias,saldo,u,t);
                listaCuentas.add(cuenta);
            }
            if (!listaCuentas.isEmpty()){
                return listaCuentas;
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
