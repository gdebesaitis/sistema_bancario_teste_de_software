package controller;

import model.ContaCorrente;
import service.ContaService;
import view.MenuView;
import view.BancoView;

/**
 * Controller responsável por gerenciar as operações relacionadas às contas correntes.
 * Faz a ponte entre a interface de usuário (View) e a lógica de negócio (Service).
 */
public class ContaController {
    
    private ContaService contaService;
    private MenuView menuView;
    private BancoView bancoView;
    
    public ContaController(ContaService contaService, MenuView menuView, BancoView bancoView) {
        this.contaService = contaService;
        this.menuView = menuView;
        this.bancoView = bancoView;
    }
    
    /**
     * Executa a consulta de uma conta por ID.
     */
    public void consultarConta() {
        int idConta = menuView.lerIdConta();
        ContaCorrente conta = contaService.pesquisaConta(idConta);
        
        if (conta != null) {
            bancoView.exibirConta(conta);
        } else {
            bancoView.exibirNaoEncontrado("Conta");
        }
    }
    
    /**
     * Executa a criação de uma nova conta.
     */
    public void criarConta() {
        System.out.println("\n=== CRIAÇÃO DE NOVA CONTA ===");
        
        int id = gerarProximoId();
        double saldoInicial = menuView.lerValor();
        
        ContaCorrente novaConta = new ContaCorrente(id, saldoInicial, true);
        contaService.adicionaConta(novaConta);
        
        bancoView.exibirOperacaoSucesso("Criação de conta", 
            "Conta criada com ID " + id + " e saldo inicial de R$ " + String.format("%.2f", saldoInicial));
    }
    
    /**
     * Executa a remoção de uma conta.
     */
    public void removerConta() {
        int idConta = menuView.lerIdConta();
        boolean sucesso = contaService.removeConta(idConta);
        
        if (sucesso) {
            bancoView.exibirOperacaoSucesso("Remoção de conta", "Conta ID " + idConta + " foi removida");
        } else {
            bancoView.exibirNaoEncontrado("Conta");
        }
    }
    
    /**
     * Executa um depósito em uma conta.
     */
    public void depositar() {
        System.out.println("\n=== DEPÓSITO ===");
        
        int idConta = menuView.lerIdConta();
        double valor = menuView.lerValor();
        
        boolean sucesso = contaService.depositar(idConta, valor);
        
        if (sucesso) {
            ContaCorrente conta = contaService.pesquisaConta(idConta);
            bancoView.exibirOperacaoSucesso("Depósito", 
                "Valor de R$ " + String.format("%.2f", valor) + " depositado na conta " + idConta);
            bancoView.exibirSaldo(idConta, conta.getSaldo());
        } else {
            bancoView.exibirOperacaoErro("Depósito", "Conta não encontrada ou valor inválido");
        }
    }
    
    /**
     * Executa um saque de uma conta.
     */
    public void sacar() {
        System.out.println("\n=== SAQUE ===");
        
        int idConta = menuView.lerIdConta();
        double valor = menuView.lerValor();
        
        boolean sucesso = contaService.sacar(idConta, valor);
        
        if (sucesso) {
            ContaCorrente conta = contaService.pesquisaConta(idConta);
            bancoView.exibirOperacaoSucesso("Saque", 
                "Valor de R$ " + String.format("%.2f", valor) + " sacado da conta " + idConta);
            bancoView.exibirSaldo(idConta, conta.getSaldo());
        } else {
            bancoView.exibirOperacaoErro("Saque", "Conta não encontrada, valor inválido ou saldo insuficiente");
        }
    }
    
    /**
     * Executa uma transferência entre contas.
     */
    public void transferir() {
        System.out.println("\n=== TRANSFERÊNCIA ===");
        
        System.out.println("Conta de origem:");
        int idContaOrigem = menuView.lerIdConta();
        
        System.out.println("Conta de destino:");
        int idContaDestino = menuView.lerIdConta();
        
        double valor = menuView.lerValor();
        
        boolean sucesso = contaService.transfereValor(idContaOrigem, valor, idContaDestino);
        
        if (sucesso) {
            bancoView.exibirTransferencia(idContaOrigem, idContaDestino, valor);
        } else {
            bancoView.exibirOperacaoErro("Transferência", "Uma das contas não foi encontrada");
        }
    }
    
    /**
     * Consulta o saldo de uma conta.
     */
    public void consultarSaldo() {
        int idConta = menuView.lerIdConta();
        ContaCorrente conta = contaService.pesquisaConta(idConta);
        
        if (conta != null) {
            bancoView.exibirSaldo(idConta, conta.getSaldo());
        } else {
            bancoView.exibirNaoEncontrado("Conta");
        }
    }
    
    /**
     * Verifica se uma conta está ativa.
     */
    public void verificarStatusConta() {
        int idConta = menuView.lerIdConta();
        ContaCorrente conta = contaService.pesquisaConta(idConta);
        
        if (conta != null) {
            String status = contaService.contaAtiva(idConta) ? "ATIVA" : "INATIVA";
            menuView.exibirMensagem("Status da conta ID " + idConta + ": " + status);
        } else {
            bancoView.exibirNaoEncontrado("Conta");
        }
    }
    
    /**
     * Lista todas as contas do sistema.
     */
    public void listarContas() {
        bancoView.exibirListaContas(contaService.getContasDoBanco());
    }
    
    /**
     * Gera o próximo ID disponível para uma nova conta.
     * @return próximo ID disponível
     */
    private int gerarProximoId() {
        int maiorId = 0;
        for (ContaCorrente conta : contaService.getContasDoBanco()) {
            if (conta.getId() > maiorId) {
                maiorId = conta.getId();
            }
        }
        return maiorId + 1;
    }
}