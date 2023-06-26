package com.homebanking;

public class UsuarioDuplicadoException extends Exception{
    public UsuarioDuplicadoException() {
        super("El usuario ya existe");
    }
}
