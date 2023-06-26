package com.homebanking;

public class TarjetaDebito {
    private String numeroTarjeta;
    private int gastoMes;
    private Cuenta cuenta;

    // Constructor
    public TarjetaDebito(String numeroTarjeta, int gastoMes, Cuenta cuenta) {
        this.numeroTarjeta = numeroTarjeta;
        this.gastoMes = gastoMes;
        this.cuenta = cuenta;
    }

    // Setters y getters
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
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
