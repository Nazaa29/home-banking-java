package com.homebanking;

public class TipoCuenta {
    private int tipoCuenta;
    private String descripcion;

    // Constructor
    public TipoCuenta(int tipoCuenta, String descripcion) {
        this.tipoCuenta = tipoCuenta;
        this.descripcion = descripcion;
    }

    // Setter y getters
    public int getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(int tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
