package negocio;

import java.util.ArrayList;
import java.util.List;

public class SistemaBancario{

    private GerenciadoraClientes gerClientes;
    private GerenciadoraContas gerContas;

    public SistemaBancario(){
        inicializaSistemaBancario();
    }

    public GerenciadoraClientes getClientes(){
        return gerClientes;
    }

    public GerenciadoraContas getContas(){
        return gerContas;
    }

    public void inicializaSistemaBancario(){
        // criando lista vazia de contas e clientes
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		List<Cliente> clientesDoBanco = new ArrayList<>();
		
		// criando e inserindo duas contas na lista de contas correntes do banco
		ContaCorrente conta01 = new ContaCorrente(1, 0, true);
		ContaCorrente conta02 = new ContaCorrente(2, 0, true);
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		// criando dois clientes e associando as contas criadas acima a eles
		Cliente cliente01 = new Cliente(1, "Maria Silva", 31, "mariasilva@gmail.com", conta01.getId(), true);
		Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", conta02.getId(), true);
		// inserindo os clientes criados na lista de clientes do banco
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		this.gerClientes = new GerenciadoraClientes(clientesDoBanco);
		this.gerContas = new GerenciadoraContas(contasDoBanco);
    }

	public void pulaLinha(){
		System.out.println("\n");
	}

	public void printMenu(){
		System.out.println("O que voc� deseja fazer? \n");
		System.out.println("1) Consultar por um cliente");
		System.out.println("2) Consultar por uma conta corrente");
		System.out.println("3) Ativar um cliente");
		System.out.println("4) Desativar um cliente");
		System.out.println("5) Executar testes unitarios");
		System.out.println("6) Sair");
		System.out.println();
	}
}