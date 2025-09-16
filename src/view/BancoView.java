package view;

import model.Cliente;
import model.ContaCorrente;
import java.util.List;

/**
 * Classe responsável pela exibição formatada de informações bancárias.
 * Contém métodos específicos para apresentação de dados de clientes e contas.
 */
public class BancoView {
    
    /**
     * Exibe as informações detalhadas de um cliente.
     * @param cliente cliente a ser exibido
     */
    public void exibirCliente(Cliente cliente) {
        if (cliente != null) {
            System.out.println("\n" + cliente.toString());
        }
    }
    
    /**
     * Exibe as informações detalhadas de uma conta corrente.
     * @param conta conta a ser exibida
     */
    public void exibirConta(ContaCorrente conta) {
        if (conta != null) {
            System.out.println("\n" + conta.toString());
        }
    }
    
    /**
     * Exibe uma lista de todos os clientes do banco.
     * @param clientes lista de clientes
     */
    public void exibirListaClientes(List<Cliente> clientes) {
        if (clientes == null || clientes.isEmpty()) {
            System.out.println("\nNenhum cliente encontrado no sistema.");
            return;
        }
        
        System.out.println("\n=== LISTA DE CLIENTES ===");
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId() + " | Nome: " + cliente.getNome() + 
                             " | Status: " + (cliente.isAtivo() ? "Ativo" : "Inativo"));
        }
        System.out.println("========================");
    }
    
    /**
     * Exibe uma lista de todas as contas do banco.
     * @param contas lista de contas
     */
    public void exibirListaContas(List<ContaCorrente> contas) {
        if (contas == null || contas.isEmpty()) {
            System.out.println("\nNenhuma conta encontrada no sistema.");
            return;
        }
        
        System.out.println("\n=== LISTA DE CONTAS ===");
        for (ContaCorrente conta : contas) {
            System.out.println("ID: " + conta.getId() + " | Saldo: R$ " + 
                             String.format("%.2f", conta.getSaldo()) + 
                             " | Status: " + (conta.isAtiva() ? "Ativa" : "Inativa"));
        }
        System.out.println("=======================");
    }
    
    /**
     * Exibe uma mensagem formatada de operação realizada com sucesso.
     * @param operacao tipo de operação realizada
     * @param detalhes detalhes adicionais da operação
     */
    public void exibirOperacaoSucesso(String operacao, String detalhes) {
        System.out.println("\n✓ " + operacao + " realizada com sucesso!");
        if (detalhes != null && !detalhes.isEmpty()) {
            System.out.println("  " + detalhes);
        }
    }
    
    /**
     * Exibe uma mensagem formatada de erro em operação.
     * @param operacao tipo de operação que falhou
     * @param motivo motivo do erro
     */
    public void exibirOperacaoErro(String operacao, String motivo) {
        System.out.println("\n✗ Erro na operação: " + operacao);
        if (motivo != null && !motivo.isEmpty()) {
            System.out.println("  Motivo: " + motivo);
        }
    }
    
    /**
     * Exibe informações de uma transferência realizada.
     * @param idContaOrigem ID da conta de origem
     * @param idContaDestino ID da conta de destino
     * @param valor valor transferido
     */
    public void exibirTransferencia(int idContaOrigem, int idContaDestino, double valor) {
        System.out.println("\n=== TRANSFERÊNCIA REALIZADA ===");
        System.out.println("Conta Origem: " + idContaOrigem);
        System.out.println("Conta Destino: " + idContaDestino);
        System.out.println("Valor: R$ " + String.format("%.2f", valor));
        System.out.println("==============================");
    }
    
    /**
     * Exibe o saldo de uma conta.
     * @param idConta ID da conta
     * @param saldo saldo atual
     */
    public void exibirSaldo(int idConta, double saldo) {
        System.out.println("\n=== SALDO DA CONTA ===");
        System.out.println("Conta: " + idConta);
        System.out.println("Saldo: R$ " + String.format("%.2f", saldo));
        System.out.println("=====================");
    }
    
    /**
     * Exibe mensagem quando um item não é encontrado.
     * @param tipoItem tipo do item (Cliente, Conta, etc.)
     */
    public void exibirNaoEncontrado(String tipoItem) {
        System.out.println("\n✗ " + tipoItem + " não encontrado!");
    }
    
    /**
     * Exibe uma mensagem de validação de idade inválida.
     * @param idade idade informada
     */
    public void exibirIdadeInvalida(int idade) {
        System.out.println("\n✗ Idade inválida: " + idade + " anos");
        System.out.println("  A idade deve estar entre 18 e 65 anos.");
    }
}