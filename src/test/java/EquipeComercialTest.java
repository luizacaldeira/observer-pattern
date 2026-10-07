import org.example.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipeComercialTest {

    @Test
    void deveNotificarUmaEquipe() {
        Contrato contrato = new Contrato(1001, "Fibra 300MB");
        ContratoObservavel observavel = new ContratoObservavel(contrato);
        EquipeComercial equipe = new EquipeComercial("Equipe Vendas");

        equipe.acompanhar(observavel);
        observavel.alterarStatus("Ativo");

        assertEquals("Equipe Vendas foi avisado: status alterado para Ativo no Contrato{numero=1001, plano='Fibra 300MB'}", equipe.getUltimaNotificacao());
    }

    @Test
    void deveNotificarVariasEquipes() {
        Contrato contrato = new Contrato(1002, "Fibra 500MB");
        ContratoObservavel observavel = new ContratoObservavel(contrato);
        EquipeComercial equipe1 = new EquipeComercial("Equipe Vendas");
        EquipeComercial equipe2 = new EquipeComercial("Equipe Financeiro");

        equipe1.acompanhar(observavel);
        equipe2.acompanhar(observavel);
        observavel.alterarStatus("Suspenso");

        assertTrue(equipe1.getUltimaNotificacao().contains("Suspenso"));
        assertTrue(equipe2.getUltimaNotificacao().contains("Suspenso"));
    }

    @Test
    void naoDeveNotificarEquipeNaoInscrita() {
        Contrato contrato = new Contrato(1003, "Fibra 100MB");
        ContratoObservavel observavel = new ContratoObservavel(contrato);
        EquipeComercial equipe = new EquipeComercial("Equipe Vendas");

        observavel.alterarStatus("Cancelado");

        assertNull(equipe.getUltimaNotificacao());
    }

    @Test
    void deveNotificarApenasEquipeDoContratoCorreto() {
        Contrato contratoA = new Contrato(2001, "Fibra 300MB");
        Contrato contratoB = new Contrato(2002, "Fibra 300MB");
        ContratoObservavel observavelA = new ContratoObservavel(contratoA);
        ContratoObservavel observavelB = new ContratoObservavel(contratoB);

        EquipeComercial equipe1 = new EquipeComercial("Equipe A");
        EquipeComercial equipe2 = new EquipeComercial("Equipe B");

        equipe1.acompanhar(observavelA);
        equipe2.acompanhar(observavelB);

        observavelA.alterarStatus("Ativo");

        assertTrue(equipe1.getUltimaNotificacao().contains("Ativo"));
        assertNull(equipe2.getUltimaNotificacao());
    }
}