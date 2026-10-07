package org.example;

import java.util.Observable;

public class Contrato {

    private Integer numero;
    private String plano;

    public Contrato(Integer numero, String plano) {
        this.numero = numero;
        this.plano = plano;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "numero=" + numero +
                ", plano='" + plano + '\'' +
                '}';
    }
}