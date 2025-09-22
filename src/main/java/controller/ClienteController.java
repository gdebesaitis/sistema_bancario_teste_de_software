package main.java.controller;

import main.java.model.Cliente;
import main.java.model.exception.IdadeNaoPermitidaException;
import main.java.service.ClienteService;
import main.java.view.BancoView;
import main.java.view.MenuView;

/**
 * Controller responsável por gerenciar as operações relacionadas aos clientes.
 * Faz a ponte entre a interface de usuário (View) e a lógica de negócio (Service).
 */
public class ClienteController {
    
    private ClienteService clienteService;
    private MenuView menuView;
    private BancoView bancoView;
    
    public ClienteController(ClienteService clienteService, MenuView menuView, BancoView bancoView) {
        this.clienteService = clienteService;
        this.menuView = menuView;
        this.bancoView = bancoView;
    }
    
    /**
     * Executa a consulta de um cliente por ID.
     */
    public void consultarCliente() {
        int idCliente = menuView.lerIdCliente();
        Cliente cliente = clienteService.pesquisaCliente(idCliente);
        
        if (cliente != null) {
            bancoView.exibirCliente(cliente);
        } else {
            bancoView.exibirNaoEncontrado("Cliente");
        }
    }
    
    /**
     * Executa a ativação de um cliente.
     */
    public void ativarCliente() {
        int idCliente = menuView.lerIdCliente();
        boolean sucesso = clienteService.ativarCliente(idCliente);
        
        if (sucesso) {
            bancoView.exibirOperacaoSucesso("Ativação do cliente", "Cliente ID " + idCliente + " foi ativado");
        } else {
            bancoView.exibirNaoEncontrado("Cliente");
        }
    }
    
    /**
     * Executa a desativação de um cliente.
     */
    public void desativarCliente() {
        int idCliente = menuView.lerIdCliente();
        boolean sucesso = clienteService.desativarCliente(idCliente);
        
        if (sucesso) {
            bancoView.exibirOperacaoSucesso("Desativação do cliente", "Cliente ID " + idCliente + " foi desativado");
        } else {
            bancoView.exibirNaoEncontrado("Cliente");
        }
    }
    
    /**
     * Executa a adição de um novo cliente.
     */
    public void adicionarCliente() {
        try {
            System.out.println("\n=== CADASTRO DE NOVO CLIENTE ===");
            
            int id = gerarProximoId();
            String nome = menuView.lerNomeCliente();
            int idade = menuView.lerIdadeCliente();
            String email = menuView.lerEmailCliente();
            int idContaCorrente = menuView.lerIdConta();
            
            // Validar idade
            clienteService.validaIdade(idade);
            
            Cliente novoCliente = new Cliente(id, nome, idade, email, idContaCorrente, true);
            clienteService.adicionaCliente(novoCliente);
            
            bancoView.exibirOperacaoSucesso("Cadastro de cliente", 
                "Cliente " + nome + " cadastrado com ID " + id);
            
        } catch (IdadeNaoPermitidaException e) {
            bancoView.exibirOperacaoErro("Cadastro de cliente", e.getMessage());
        }
    }
    
    /**
     * Executa a remoção de um cliente.
     */
    public void removerCliente() {
        int idCliente = menuView.lerIdCliente();
        boolean sucesso = clienteService.removeCliente(idCliente);
        
        if (sucesso) {
            bancoView.exibirOperacaoSucesso("Remoção de cliente", "Cliente ID " + idCliente + " foi removido");
        } else {
            bancoView.exibirNaoEncontrado("Cliente");
        }
    }
    
    /**
     * Verifica se um cliente está ativo.
     */
    public void verificarStatusCliente() {
        int idCliente = menuView.lerIdCliente();
        Cliente cliente = clienteService.pesquisaCliente(idCliente);
        
        if (cliente != null) {
            String status = clienteService.clienteAtivo(idCliente) ? "ATIVO" : "INATIVO";
            menuView.exibirMensagem("Status do cliente ID " + idCliente + ": " + status);
        } else {
            bancoView.exibirNaoEncontrado("Cliente");
        }
    }
    
    /**
     * Lista todos os clientes do sistema.
     */
    public void listarClientes() {
        bancoView.exibirListaClientes(clienteService.getClientesDoBanco());
    }
    
    /**
     * Gera o próximo ID disponível para um novo cliente.
     * @return próximo ID disponível
     */
    private int gerarProximoId() {
        int maiorId = 0;
        for (Cliente cliente : clienteService.getClientesDoBanco()) {
            if (cliente.getId() > maiorId) {
                maiorId = cliente.getId();
            }
        }
        return maiorId + 1;
    }
    
    /**
     * Valida a idade de um cliente.
     * @param idade idade a ser validada
     * @return true se a idade for válida
     */
    public boolean validarIdade(int idade) {
        try {
            return clienteService.validaIdade(idade);
        } catch (IdadeNaoPermitidaException e) {
            bancoView.exibirIdadeInvalida(idade);
            return false;
        }
    }
}