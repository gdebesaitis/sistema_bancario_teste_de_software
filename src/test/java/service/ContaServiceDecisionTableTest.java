package test.java.service;

import main.java.model.ContaCorrente;
import main.java.service.ContaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ContaServiceDecisionTableTest {

    private ContaService contaService;
    private ContaCorrente contaOrigem;
    private ContaCorrente contaDestino;
    private List<ContaCorrente> contasDoBanco;

    @BeforeEach
    void setUp() {
        contaOrigem = new ContaCorrente(1, 500.0, true);
        contaDestino = new ContaCorrente(2, 200.0, true);
        contasDoBanco = new ArrayList<>();
        contasDoBanco.add(contaOrigem);
        contasDoBanco.add(contaDestino);
        contaService = new ContaService(contasDoBanco);
    }

    @Test
    @DisplayName("Regra 1: Deve realizar a transferência com sucesso")
    void testeTransferenciaComSucesso() {
        boolean resultado = contaService.transfereValor(1, 100.0, 2);
        assertTrue(resultado);
        assertEquals(400.0, contaOrigem.getSaldo());
        assertEquals(300.0, contaDestino.getSaldo());
    }

    @Test
    @DisplayName("Regra 2: Não deve transferir com saldo insuficiente")
    void testeTransferenciaSaldoInsuficiente() {
        boolean resultado = contaService.transfereValor(1, 600.0, 2);
        assertFalse(resultado);
        assertEquals(500.0, contaOrigem.getSaldo());
        assertEquals(200.0, contaDestino.getSaldo());
    }

    @Test
    @DisplayName("Regra 3: Não deve transferir para conta de destino inexistente")
    void testeTransferenciaContaDestinoInexistente() {
        boolean resultado = contaService.transfereValor(1, 100.0, 999);
        assertFalse(resultado);
    }

    @Test
    @DisplayName("Regra 4: Não deve transferir de conta de origem inexistente")
    void testeTransferenciaContaOrigemInexistente() {
        boolean resultado = contaService.transfereValor(999, 100.0, 2);
        assertFalse(resultado);
    }
}