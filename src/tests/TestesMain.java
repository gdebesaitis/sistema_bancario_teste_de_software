package tests;

import model.Cliente;
import model.ContaCorrente;

public class TestesMain {

//    private SistemaBancario sistema;
//
//    public TestesMain(SistemaBancario sistema) {
//        this.sistema = sistema;
//    }
//
//    private boolean testeConsultarClienteExistente() {
//        System.out.println("Teste: Consultando Cliente ID 1");
//        Cliente cliente = sistema.getClientes().pesquisaCliente(1);
//
//        if(cliente != null && cliente.getId() == 1 && cliente.getNome().equals("Maria Silva")) {
//            System.out.println("  Cliente encontrado: " + cliente.getNome());
//            return true;
//        }
//        System.out.println("  Erro: Cliente não encontrado ou dados incorretos");
//        return false;
//    }
//
//    private boolean testeConsultarClienteInexistente() {
//        System.out.println("Teste: Consultando Cliente ID 999");
//        Cliente cliente = sistema.getClientes().pesquisaCliente(999);
//        if(cliente == null) {
//            System.out.println("  Cliente não encontrado, como esperado");
//            return true;
//        }
//        System.out.println("  Erro: Cliente encontrado quando não deveria");
//        return false;
//    }
//
//    private boolean testeConsultarContaExistente() {
//        System.out.println("  Consultando conta ID 1...");
//        ContaCorrente conta = sistema.getContas().pesquisaConta(1);
//
//        if(conta != null && conta.getId() == 1) {
//            System.out.println("  Conta encontrada: ID " + conta.getId() + ", Saldo: " + conta.getSaldo());
//            return true;
//        }
//        System.out.println("  Erro: Conta não encontrada");
//        return false;
//    }
//
//    private boolean testeConsultarContaInexistente() {
//        System.out.println("  Consultando conta ID 999...");
//        ContaCorrente conta = sistema.getContas().pesquisaConta(999);
//
//        if(conta == null) {
//            System.out.println("  Correto: Conta inexistente retornou null");
//            return true;
//        }
//        System.out.println("  Erro: Deveria retornar null para conta inexistente");
//        return false;
//    }
//
//    private boolean testeAtivarCliente() {
//        System.out.println("  Desativando cliente ID 2 primeiro...");
//        Cliente cliente = sistema.getClientes().pesquisaCliente(2);
//        cliente.setAtivo(false);
//
//        System.out.println("  Ativando cliente ID 2...");
//        cliente.setAtivo(true);
//
//        if(cliente.isAtivo()) {
//            System.out.println("  Cliente ativado com sucesso");
//            return true;
//        }
//        System.out.println("  Erro: Cliente não foi ativado");
//        return false;
//    }
//
//    private boolean testeDesativarCliente() {
//        System.out.println("  Desativando cliente ID 1...");
//        Cliente cliente = sistema.getClientes().pesquisaCliente(1);
//        cliente.setAtivo(false);
//
//        if(!cliente.isAtivo()) {
//            System.out.println("  Cliente desativado com sucesso");
//            cliente.setAtivo(true);
//            return true;
//        }
//        System.out.println("  Erro: Cliente não foi desativado");
//        return false;
//    }
//
//    private boolean testeRemoverConta() {
//        System.out.println("  Adicionando conta teste ID 99...");
//        ContaCorrente contaTeste = new ContaCorrente(99, 100.0, true);
//        sistema.getContas().adicionaConta(contaTeste);
//
//        System.out.println("  Removendo conta ID 99...");
//        boolean removido = sistema.getContas().removeConta(99);
//
//        if(removido && sistema.getContas().pesquisaConta(99) == null) {
//            System.out.println("  Conta removida com sucesso");
//            return true;
//        }
//        System.out.println("  Erro: Método removeConta retornou: " + removido);
//        System.out.println("  Conta ainda existe? " + (sistema.getContas().pesquisaConta(99) != null));
//        return false;
//    }
//
//    public void executarTestes() {
//        System.out.println("Iniciando testes do sistema bancário...");
//
//        boolean resultado;
//
//        resultado = testeConsultarClienteExistente();
//        System.out.println("Teste consultar cliente existente: " + (resultado ? "SUCESSO" : "FALHA"));
//
//        resultado = testeConsultarClienteInexistente();
//        System.out.println("Teste consultar cliente inexistente: " + (resultado ? "SUCESSO" : "FALHA"));
//
//        resultado = testeConsultarContaExistente();
//        System.out.println("Teste consultar conta existente: " + (resultado ? "SUCESSO" : "FALHA"));
//
//        resultado = testeConsultarContaInexistente();
//        System.out.println("Teste consultar conta inexistente: " + (resultado ? "SUCESSO" : "FALHA"));
//
//        resultado = testeAtivarCliente();
//        System.out.println("Teste ativar cliente: " + (resultado ? "SUCESSO" : "FALHA"));
//
//        resultado = testeDesativarCliente();
//        System.out.println("Teste desativar cliente: " + (resultado ? "SUCESSO" : "FALHA"));
//
//        resultado = testeRemoverConta();
//        System.out.println("Teste remover conta: " + (resultado ? "SUCESSO" : "FALHA"));
//
//        System.out.println("Testes concluídos.");
//    }
}
