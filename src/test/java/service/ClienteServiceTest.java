package test.java.service;

import main.java.model.Cliente;
import main.java.service.ClienteService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteServiceTest{

    private ClienteService clienteService;
    private Cliente clienteTeste;

    @BeforeEach
    void setUp() {
        clienteTeste = new Cliente(1, "Maria Silva", 31, "maria@email.com", 101, true);
        List<Cliente> clientesDoBanco = new ArrayList<>();
        clientesDoBanco.add(clienteTeste);
        clienteService = new ClienteService(clientesDoBanco);
    }

    @Test
    @DisplayName("Deve transitar do estado ATIVO para INATIVO")
    void testeTransicaoDeAtivoParaInativo(){

        assertTrue(clienteTeste.isAtivo(), "Pré-condição: O cliente deve iniciar como ativo.");

        clienteService.desativarCliente(1);

        assertFalse(clienteTeste.isAtivo(), "O cliente deveria estar inativo após a operação.");
    }

    @Test
    @DisplayName("Deve transitar do estado INATIVO para ATIVO")
    void testeTransicaoDeInativoParaAtivo(){

        clienteTeste.setAtivo(false);
        assertFalse(clienteTeste.isAtivo(), "Pré-condição: O cliente deve ser configurado como inativo.");

        clienteService.ativarCliente(1);

        assertTrue(clienteTeste.isAtivo(), "O cliente deveria estar ativo após a operação.");
    }

    @Test
    @DisplayName("Deve permanecer ATIVO ao tentar ativar um cliente que já está ativo")
    void testePermanenciaNoEstadoAtivo() {
        assertTrue(clienteTeste.isAtivo(), "Pré-condição: O cliente deve iniciar como ativo.");

        clienteService.ativarCliente(1);

        assertTrue(clienteTeste.isAtivo(), "O cliente deve permanecer ativo.");
    }
}