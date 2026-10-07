package org.example;

import java.util.Observable;
import java.util.Observer;

public class EquipeComercial implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public EquipeComercial(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void acompanhar(ContratoObservavel contrato) {
        contrato.addObserver(this);
    }

    public void update(Observable contrato, Object arg) {
        this.ultimaNotificacao = this.nome + " foi avisado: status alterado para " + arg + " no " + contrato.toString();
    }
}