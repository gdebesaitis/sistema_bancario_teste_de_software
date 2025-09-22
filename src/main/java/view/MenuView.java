package main.java.view;

import java.util.Scanner;

/**
 * Classe responsável pela interface de usuário do sistema bancário.
 * Gerencia a exibição de menus e captura de entrada do usuário.
 */
public class MenuView {
    
    private Scanner scanner;
    
    public MenuView() {
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Exibe o menu principal do sistema bancário.
     */
    public void exibirMenuPrincipal() {
        System.out.println("\n=== SISTEMA BANCÁRIO ===");
        System.out.println("O que você deseja fazer?\n");
        System.out.println("1) Consultar por um cliente");
        System.out.println("2) Consultar por uma conta corrente");
        System.out.println("3) Ativar um cliente");
        System.out.println("4) Desativar um cliente");
        System.out.println("5) Executar testes unitários");
        System.out.println("6) Sair");
        System.out.print("\nDigite sua opção: ");
    }
    
    /**
     * Lê a opção escolhida pelo usuário no menu principal.
     * @return opção escolhida
     */
    public int lerOpcaoMenu() {
        return scanner.nextInt();
    }
    
    /**
     * Solicita e lê o ID de um cliente.
     * @return ID do cliente
     */
    public int lerIdCliente() {
        System.out.print("Digite o ID do cliente: ");
        return scanner.nextInt();
    }
    
    /**
     * Solicita e lê o ID de uma conta.
     * @return ID da conta
     */
    public int lerIdConta() {
        System.out.print("Digite o ID da conta: ");
        return scanner.nextInt();
    }
    
    /**
     * Solicita e lê o nome de um cliente.
     * @return nome do cliente
     */
    public String lerNomeCliente() {
        System.out.print("Digite o nome do cliente: ");
        scanner.nextLine(); // limpa o buffer
        return scanner.nextLine();
    }
    
    /**
     * Solicita e lê a idade de um cliente.
     * @return idade do cliente
     */
    public int lerIdadeCliente() {
        System.out.print("Digite a idade do cliente: ");
        return scanner.nextInt();
    }
    
    /**
     * Solicita e lê o email de um cliente.
     * @return email do cliente
     */
    public String lerEmailCliente() {
        System.out.print("Digite o email do cliente: ");
        scanner.nextLine(); // limpa o buffer
        return scanner.nextLine();
    }
    
    /**
     * Solicita e lê um valor monetário.
     * @return valor digitado
     */
    public double lerValor() {
        System.out.print("Digite o valor: R$ ");
        return scanner.nextDouble();
    }
    
    /**
     * Exibe uma mensagem de sucesso.
     * @param mensagem mensagem a ser exibida
     */
    public void exibirMensagemSucesso(String mensagem) {
        System.out.println("\n✓ " + mensagem);
    }
    
    /**
     * Exibe uma mensagem de erro.
     * @param mensagem mensagem de erro a ser exibida
     */
    public void exibirMensagemErro(String mensagem) {
        System.out.println("\n✗ " + mensagem);
    }
    
    /**
     * Exibe uma mensagem informativa.
     * @param mensagem mensagem informativa a ser exibida
     */
    public void exibirMensagem(String mensagem) {
        System.out.println("\n" + mensagem);
    }
    
    /**
     * Exibe uma linha em branco para separação visual.
     */
    public void pulaLinha() {
        System.out.println();
    }
    
    /**
     * Exibe uma mensagem de despedida ao sair do sistema.
     */
    public void exibirMensagemSaida() {
        System.out.println("\n################# Sistema encerrado #################");
    }
    
    /**
     * Pausa a execução aguardando uma tecla do usuário.
     */
    public void aguardarTecla() {
        System.out.print("\nPressione Enter para continuar...");
        scanner.nextLine();
    }
    
    /**
     * Fecha o scanner ao finalizar o sistema.
     */
    public void fechar() {
        scanner.close();
    }
}