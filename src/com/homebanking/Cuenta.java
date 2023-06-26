package com.homebanking;

public class Cuenta{
    private String cbu;
    private String alias;
    private double saldo;
    private Usuario usuario; // Objeto Usuario como atributo en lugar de solo la clave externa

    private TipoCuenta tipoCuenta;

    // Constructor
    public Cuenta(String cbu, String alias, double saldo, Usuario usuario, TipoCuenta tipo_cuenta) {
        this.cbu = cbu;
        this.alias = alias;
        this.saldo = saldo;
        this.usuario = usuario;
        this.tipoCuenta = tipo_cuenta;
    }


    // Setters y getters
    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    // Metodos
    public void ejecutarTransferencia(Cuenta cuentaOrigen, Cuenta cuentaDestino, double monto) {

    }
}
