package com.homebanking;

import java.sql.SQLException;

public interface TipoCuentaDAO {
    void crearTipoCuenta(Usuario usuario) throws SQLException;

    void borraTipoCuenta(int tipo_cuenta);

    void actualizaTipoCuenta(Usuario usuario);

    static TipoCuenta muestraTipoCuenta(int id) {
        return null;
    }

    java.util.List<TipoCuenta> listaTodosTipoCuenta();
}