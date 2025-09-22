package service;

import main.java.model.ContaCorrente;
import main.java.service.ContaService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Esta classe testa a classe ContaService
public class ContaServiceTest{

    private ContaService contaService;
    private List<ContaCorrente> contasDoBanco;
    private ContaCorrente contaTeste;

    @BeforeEach
    void setUp(){

        contaTeste = new ContaCorrente(1, 500.0, true);
        contasDoBanco = new ArrayList<>();
        contasDoBanco.add(contaTeste);

        contaService = new ContaService(contasDoBanco);
    }

    @Test
    @DisplayName("Deve retornar TRUE para um saque válido")
    void testeCaminhoValido_SaqueComSucesso(){

        boolean resultado = contaService.sacar(1, 150.0);

        assertTrue(resultado, "A operação de saque deveria retornar true.");
        assertEquals(350.0, contaTeste.getSaldo(), "O saldo da conta deveria ser 350.0 após o saque.");
    }

    @Test
    @DisplayName("Deve retornar FALSE se a conta não existir")
    void testeCaminhoFalso_ContaInexistente(){

        boolean resultado = contaService.sacar(999, 100.0);

        assertFalse(resultado, "A operação deveria retornar false para conta inexistente.");
    }

    @Test
    @DisplayName("Deve retornar FALSE para um valor de saque negativo")
    void testeCaminhoFalso_ValorNegativo(){

        boolean resultado = contaService.sacar(1, -50.0);

        assertFalse(resultado, "A operação deveria retornar false para valor negativo.");
        assertEquals(500.0, contaTeste.getSaldo(), "O saldo não pode mudar se a operação falhar.");
    }

    @Test
    @DisplayName("Deve retornar FALSE se o saldo for insuficiente")
    void testeCaminhoFalso_SaldoInsuficiente(){

        boolean resultado = contaService.sacar(1, 600.0);

        assertFalse(resultado, "A operação deveria retornar false por saldo insuficiente.");
        assertEquals(500.0, contaTeste.getSaldo(), "O saldo não pode mudar se a operação falhar.");
    }
}