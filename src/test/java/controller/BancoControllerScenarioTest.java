package test.java.controller;

import main.java.controller.BancoController;
import main.java.model.Cliente;
import main.java.model.ContaCorrente;
import main.java.service.ClienteService;
import main.java.service.ContaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BancoControllerScenarioTest {

    private BancoController bancoController;
    private ClienteService clienteService;
    private ContaService contaService;

    @BeforeEach
    void setUp() {
        bancoController = new BancoController();
        clienteService = bancoController.getClienteService();
        contaService = bancoController.getContaService();
    }

    @Test
    @DisplayName("CT-SCENARIO-01: Jornada de Novo Cliente")
    void testeJornadaNovoCliente() {
        // Passo 1: Adicionar um novo cliente
        Cliente novoCliente = new Cliente(3, "Novo Cliente", 25, "novo@email.com", 3, true);
        clienteService.adicionaCliente(novoCliente);
        Cliente clienteAdicionado = clienteService.pesquisaCliente(3);
        assertNotNull(clienteAdicionado, "O cliente deveria ter sido adicionado.");
        assertEquals("Novo Cliente", clienteAdicionado.getNome());

        ContaCorrente novaConta = new ContaCorrente(3, 0.0, true);
        contaService.adicionaConta(novaConta);
        ContaCorrente contaAdicionada = contaService.pesquisaConta(3);
        assertNotNull(contaAdicionada, "A conta deveria ter sido adicionada.");
        assertEquals(0.0, contaAdicionada.getSaldo());

        contaService.depositar(3, 500.0);
        assertEquals(500.0, contaAdicionada.getSaldo(), "O saldo deveria ser 500.0 após o depósito.");

        contaService.sacar(3, 150.0);
        assertEquals(350.0, contaAdicionada.getSaldo(), "O saldo deveria ser 350.0 após o saque.");
    }
}