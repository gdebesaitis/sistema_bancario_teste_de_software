package controller;

import model.Cliente;
import model.ContaCorrente;
import service.ClienteService;
import service.ContaService;
import view.MenuView;
import view.BancoView;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller principal do sistema bancário.
 * Responsável por coordenar o fluxo da aplicação e inicializar o sistema.
 */
public class BancoController {
    
    private MenuView menuView;
    private BancoView bancoView;
    private ClienteController clienteController;
    private ContaController contaController;
    private ClienteService clienteService;
    private ContaService contaService;
    
    public BancoController() {
        inicializarSistema();
    }
    
    /**
     * Inicializa todos os componentes do sistema bancário.
     */
    private void inicializarSistema() {
        // Inicializar Views
        this.menuView = new MenuView();
        this.bancoView = new BancoView();
        
        // Inicializar dados do sistema
        inicializarDadosIniciais();
        
        // Inicializar Controllers
        this.clienteController = new ClienteController(clienteService, menuView, bancoView);
        this.contaController = new ContaController(contaService, menuView, bancoView);
    }
    
    /**
     * Cria os dados iniciais do sistema (clientes e contas de exemplo).
     */
    private void inicializarDadosIniciais() {
        // Criando listas vazias
        List<ContaCorrente> contasDoBanco = new ArrayList<>();
        List<Cliente> clientesDoBanco = new ArrayList<>();
        
        // Criando e inserindo duas contas na lista de contas correntes do banco
        ContaCorrente conta01 = new ContaCorrente(1, 0, true);
        ContaCorrente conta02 = new ContaCorrente(2, 0, true);
        contasDoBanco.add(conta01);
        contasDoBanco.add(conta02);
        
        // Criando dois clientes e associando as contas criadas acima a eles
        Cliente cliente01 = new Cliente(1, "Maria Silva", 31, "mariasilva@gmail.com", conta01.getId(), true);
        Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", conta02.getId(), true);
        
        // Inserindo os clientes criados na lista de clientes do banco
        clientesDoBanco.add(cliente01);
        clientesDoBanco.add(cliente02);
        
        // Inicializando os services
        this.clienteService = new ClienteService(clientesDoBanco);
        this.contaService = new ContaService(contasDoBanco);
    }
    
    /**
     * Inicia a execução do sistema bancário.
     * Controla o loop principal da aplicação.
     */
    public void iniciarSistema() {
        boolean continua = true;
        
        while (continua) {
            try {
                menuView.exibirMenuPrincipal();
                int opcao = menuView.lerOpcaoMenu();
                
                switch (opcao) {
                    case 1:
                        clienteController.consultarCliente();
                        break;
                        
                    case 2:
                        contaController.consultarConta();
                        break;
                        
                    case 3:
                        clienteController.ativarCliente();
                        break;
                        
                    case 4:
                        clienteController.desativarCliente();
                        break;
                        
                    case 5:
                        executarTestesUnitarios();
                        break;
                        
                    case 6:
                        continua = false;
                        menuView.exibirMensagemSaida();
                        break;
                        
                    default:
                        menuView.exibirMensagemErro("Opção inválida! Escolha uma opção entre 1 e 6.");
                        break;
                }
                
                if (continua) {
                    menuView.pulaLinha();
                    menuView.aguardarTecla();
                }
                
            } catch (Exception e) {
                menuView.exibirMensagemErro("Erro inesperado: " + e.getMessage());
                menuView.pulaLinha();
            }
        }
        
        // Fechar recursos
        menuView.fechar();
    }
    
    /**
     * Executa uma simulação de testes unitários básicos.
     * Esta implementação é uma versão simplificada para demonstração.
     */
    private void executarTestesUnitarios() {
        menuView.exibirMensagem("=== EXECUTANDO TESTES UNITÁRIOS ===");
        
        try {
            // Teste 1: Pesquisa de cliente existente
            Cliente cliente = clienteService.pesquisaCliente(1);
            if (cliente != null) {
                menuView.exibirMensagemSucesso("✓ Teste 1 - Pesquisa cliente existente: PASSOU");
            } else {
                menuView.exibirMensagemErro("✗ Teste 1 - Pesquisa cliente existente: FALHOU");
            }
            
            // Teste 2: Pesquisa de cliente inexistente
            Cliente clienteInexistente = clienteService.pesquisaCliente(999);
            if (clienteInexistente == null) {
                menuView.exibirMensagemSucesso("✓ Teste 2 - Pesquisa cliente inexistente: PASSOU");
            } else {
                menuView.exibirMensagemErro("✗ Teste 2 - Pesquisa cliente inexistente: FALHOU");
            }
            
            // Teste 3: Validação de idade válida
            try {
                clienteService.validaIdade(25);
                menuView.exibirMensagemSucesso("✓ Teste 3 - Validação idade válida: PASSOU");
            } catch (Exception e) {
                menuView.exibirMensagemErro("✗ Teste 3 - Validação idade válida: FALHOU");
            }
            
            // Teste 4: Validação de idade inválida
            try {
                clienteService.validaIdade(15);
                menuView.exibirMensagemErro("✗ Teste 4 - Validação idade inválida: FALHOU");
            } catch (Exception e) {
                menuView.exibirMensagemSucesso("✓ Teste 4 - Validação idade inválida: PASSOU");
            }
            
            // Teste 5: Pesquisa de conta existente
            ContaCorrente conta = contaService.pesquisaConta(1);
            if (conta != null) {
                menuView.exibirMensagemSucesso("✓ Teste 5 - Pesquisa conta existente: PASSOU");
            } else {
                menuView.exibirMensagemErro("✗ Teste 5 - Pesquisa conta existente: FALHOU");
            }
            
            menuView.exibirMensagem("\n=== TESTES CONCLUÍDOS ===");
            
        } catch (Exception e) {
            menuView.exibirMensagemErro("Erro durante execução dos testes: " + e.getMessage());
        }
    }
    
    /**
     * Obtém o service de clientes (para uso em testes ou outras operações).
     * @return ClienteService
     */
    public ClienteService getClienteService() {
        return clienteService;
    }
    
    /**
     * Obtém o service de contas (para uso em testes ou outras operações).
     * @return ContaService
     */
    public ContaService getContaService() {
        return contaService;
    }
}