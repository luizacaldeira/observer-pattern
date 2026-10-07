package org.example;

import java.util.Observable;

public class ContratoObservavel extends Observable {

    private Contrato contrato;

    public ContratoObservavel(Contrato contrato) {
        this.contrato = contrato;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void alterarStatus(String novoStatus) {
        setChanged();
        notifyObservers(novoStatus);
    }

    @Override
    public String toString() {
        return contrato.toString();
    }
}