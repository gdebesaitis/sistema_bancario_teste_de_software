package negocio;


import java.util.Scanner;

import model.ContaCorrente;
import negocio.Cliente;
import negocio.SistemaBancario;
import negocio.TestesMain;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SistemaBancario sistema = new SistemaBancario();

		boolean continua = true;		
		while (continua){
			
			sistema.printMenu();
			
			int opcao = sc.nextInt();
			
			switch (opcao) {
			// Consultar por um cliente
			case 1:
				System.out.print("Digite o ID do cliente: ");
				int idCliente = sc.nextInt();
				Cliente cliente = sistema.getClientes().pesquisaCliente(idCliente);
				
				if(cliente != null)
					System.out.println(cliente.toString());
				else
					System.out.println("Cliente n�o encontrado!");
				
				sistema.pulaLinha();
				break;

			// Consultar por uma conta corrente
			case 2:
				System.out.print("Digite o ID da conta: ");
				int idConta = sc.nextInt();
				ContaCorrente conta = sistema.getContas().pesquisaConta(idConta);
				
				if(conta != null)
					System.out.println(conta.toString());
				else
					System.out.println("Conta n�o encontrado!");
				
				sistema.pulaLinha();
				break;

			// Ativar um cliente
			case 3:
				
				System.out.print("Digite o ID do cliente: ");
				int idCliente2 = sc.nextInt();
				Cliente cliente2 = sistema.getClientes().pesquisaCliente(idCliente2);
				
				if(cliente2 != null){
					cliente2.setAtivo(true);
					System.out.println("Cliente ativado com sucesso!");
				}
				else
					System.out.println("Cliente n�o encontrado!");
			
				sistema.pulaLinha();
				break;
				
			// Desativar um cliente
			case 4:
				
				System.out.print("Digite o ID do cliente: ");
				int idCliente3 = sc.nextInt();
				Cliente cliente3 = sistema.getClientes().pesquisaCliente(idCliente3);
				
				if(cliente3 != null){
					cliente3.setAtivo(false);
					System.out.println("Cliente desativado com sucesso!");
				}
				else
					System.out.println("Cliente n�o encontrado!");
				
				sistema.pulaLinha();
				break;
			case 5:
				System.out.println("Executando testes unitários...");
				TestesMain testes = new TestesMain(sistema);
				testes.executarTestes();
				sistema.pulaLinha();
				break;
			// Sair
			case 6:
				continua = false;
				System.out.println("################# Sistema encerrado #################");
				break;
				
			default:
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				break;
				
			} 
			
		}
	
		
	}
}

