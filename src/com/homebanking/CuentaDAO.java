package com.homebanking;

import java.sql.SQLException;

public interface CuentaDAO {
    void crearCuenta(Cuenta cuenta) throws SQLException;

    void borraCuenta(String cbu);

    void actualizaCuenta(Cuenta cuenta);

    Cuenta muestraCuenta(String cbu);

    java.util.List<Cuenta> listaTodosLasCuentas();
}
