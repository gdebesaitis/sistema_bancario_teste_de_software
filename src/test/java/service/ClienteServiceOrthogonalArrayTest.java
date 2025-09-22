package test.java.service;

import main.java.model.Cliente;
import main.java.model.exception.IdadeNaoPermitidaException;
import main.java.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteServiceOrthogonalArrayTest {

    private ClienteService clienteService;
    private List<Cliente> clientesDoBanco;

    @BeforeEach
    void setUp() {
        clientesDoBanco = new ArrayList<>();
        clienteService = new ClienteService(clientesDoBanco);
    }

    @Test
    @DisplayName("CT09: Deve cadastrar com sucesso (Idade Válida, Email Válido, Conta Existente)")
    void testeCadastroClienteCenario1() {
        assertDoesNotThrow(() -> {
            clienteService.validaIdade(30);
            Cliente novoCliente = new Cliente(1, "Teste", 30, "teste@valido.com", 1, true);
            clienteService.adicionaCliente(novoCliente);
            assertEquals(1, clienteService.getClientesDoBanco().size());
        });
    }

    @Test
    @DisplayName("CT11: Deve falhar o cadastro (Idade Inválida, Email Válido, Conta Inexistente)")
    void testeCadastroClienteCenario3() {
        assertThrows(IdadeNaoPermitidaException.class, () -> {
            clienteService.validaIdade(17);
        });
    }

    @Test
    @DisplayName("CT12: Deve falhar o cadastro (Idade Inválida, Email Inválido, Conta Existente)")
    void testeCadastroClienteCenario4() {
        assertThrows(IdadeNaoPermitidaException.class, () -> {
            clienteService.validaIdade(70);
        });
    }
}