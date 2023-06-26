package com.homebanking;

public class TarjetaCredito {
    private String numTarjeta;
    private int credito;
    private int gastoMes;
    private Cuenta cuenta;

    // Constructor


    public TarjetaCredito(String numTarjeta, int credito, int gastoMes, Cuenta cuenta) {
        this.numTarjeta = numTarjeta;
        this.credito = credito;
        this.gastoMes = gastoMes;
        this.cuenta = cuenta;
    }

    // Setter y getters
    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public int getGastoMes() {
        return gastoMes;
    }

    public void setGastoMes(int gastoMes) {
        this.gastoMes = gastoMes;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
