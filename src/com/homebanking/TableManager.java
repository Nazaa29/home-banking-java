package com.homebanking;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableManager extends ExcepcionesTableManager {
    public void createUserTable() {

        Connection c = DBManager.connect();

        String sql = "CREATE TABLE IF NOT EXISTS usuarios (\n" +
                "  id_usuario INTEGER PRIMARY KEY AUTO_INCREMENT,\n" +
                "  nombre VARCHAR(100),\n" +
                "  apellido VARCHAR(100),\n" +
                "  email VARCHAR(256) UNIQUE,\n" +
                "  dni VARCHAR (100),\n" +
                "  password VARCHAR(32)\n" +
                ")";

        executeStatement(c, sql);
    }

    public void createTipoCuentaTable() {
        Connection c = DBManager.connect();

        String sql = "CREATE TABLE IF NOT EXISTS tipo_cuenta (\n" +
                "  tipo_cuenta INTEGER PRIMARY KEY,\n" +
                "  descripcion VARCHAR(50)\n" +
                ");";

        executeStatement(c, sql);
    }


    public void createCuentaTable() {
        Connection c = DBManager.connect();

        String sql = "CREATE TABLE IF NOT EXISTS cuenta (\n" +
                "    cbu VARCHAR(50) PRIMARY KEY UNIQUE,\n" +
                "    saldo DOUBLE,\n" +
                "    alias VARCHAR(100),\n" +
                "    id_usuario INT,\n" +
                "    tipo_cuenta INT,\n" +
                "    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),\n" +
                "    FOREIGN KEY (tipo_cuenta) REFERENCES tipo_cuenta(tipo_cuenta)\n" +
                ");";

        executeStatement(c, sql);

    }


    public void createTarjetaDebtioTable() {
        Connection c = DBManager.connect();

        String sql = "CREATE TABLE IF NOT EXISTS tarjeta_debito (\n" +
                "  num_tarjeta VARCHAR(50) PRIMARY KEY,\n" +
                "  gasto_mes DOUBLE,\n" +
                "  cbu VARCHAR(50),\n" +
                "  FOREIGN KEY (cbu) REFERENCES cuenta(cbu)\n" +
                ");";

        executeStatement(c, sql);

    }

    public void createTarjetaCreditoTable() {
        Connection c = DBManager.connect();

        String sql = "CREATE TABLE IF NOT EXISTS tarjeta_credito (\n" +
                "  num_tarjeta VARCHAR(50) PRIMARY KEY,\n" +
                "  credito DOUBLE,\n" +
                "  gasto_mes DOUBLE,\n" +
                "  cbu VARCHAR(50),\n" +
                "  FOREIGN KEY (cbu) REFERENCES cuenta(cbu)\n" +
                ");";

        executeStatement(c, sql);

    }

    public void createTransferenciaTable() {
        Connection c = DBManager.connect();

        String sql = "CREATE TABLE IF NOT EXISTS transferencia (\n" +
                "  id_transferencia INT,\n" +
                "  cuenta_origen VARCHAR(50),\n" +
                "  cuenta_destino VARCHAR(50),\n" +
                "  PRIMARY KEY (id_transferencia, cuenta_origen, cuenta_destino),\n" +
                "  FOREIGN KEY (cuenta_origen) REFERENCES cuenta(cbu),\n" +
                "  FOREIGN KEY (cuenta_destino) REFERENCES cuenta(cbu)\n" +
                ");";

        executeStatement(c, sql);
    }


    public void dropUserTable() {

        Connection c = DBManager.connect();

        String sql = "DROP TABLE IF EXISTS usuarios";

        executeStatementDrop(c, sql);
    }

    public void dropCuentaTable() {

        Connection c = DBManager.connect();

        String sql = "DROP TABLE IF EXISTS cuenta";

        executeStatementDrop(c, sql);
    }

    public void dropTipoCuentaTable() {

        Connection c = DBManager.connect();

        String sql = "DROP TABLE IF EXISTS tipo_cuenta";

        executeStatementDrop(c, sql);
    }

    public void dropTarjetaCreditoTable() {

        Connection c = DBManager.connect();

        String sql = "DROP TABLE IF EXISTS tarjeta_credito";

        executeStatementDrop(c, sql);
    }

    public void dropTarjetaDebitoTable() {

        Connection c = DBManager.connect();

        String sql = "DROP TABLE IF EXISTS tarjeta_debito";

        executeStatementDrop(c, sql);
    }

    public void dropTransferenciaTable() {

        Connection c = DBManager.connect();

        String sql = "DROP TABLE IF EXISTS transferencia";

        executeStatementDrop(c, sql);
    }
}