package view;

import java.util.Scanner;

public class MenuView {
	
	private Scanner sc;
	
	public MenuView() {
		sc = new Scanner(System.in);
	}
	
	public void ExibeMenuPrincipal() {
		
	}
	
	public int lerOpcaoMenu() {
		return sc.nextInt();
	}
	
	public int lerIdCliente() {
		System.out.println("Digite o ID do cliente: ");
		return sc.nextInt();
	}
	
	public int lerIdCont(){
		System.out.println("Digite o ID da conta: ");
		return sc.nextInt();
	}
	
	public String lerNomeCliente() {
		System.out.println("Digite o nome do cliente: ");
		return sc.nextLine();
	}
	
	public int lerIdadeCliente() {
		System.out.println("Digite a idade do cliente: ");
		return sc.nextInt();
	}
	
	public String lerEmailCliente() {
		System.out.println("Digite o email do cliente: ");
		return sc.nextLine();
	}

	public double lerValor() {
		System.out.println("Digite o valor: R$ ");
		return sc.nextDouble();
	}
	
	public void exibeMensagemSucesso(String mensagem) {
		System.out.println("\n✓ " + mensagem);
	}
	
	public void exibeMensagemErro(String mensagem) {
		System.out.println("\n✗ " + mensagem);
	}
	
	public void exibeMensagem(String mensagem) {
		System.out.println("\n " + mensagem);
	}
	
	public void pulaLinha() {
		System.out.println();
	}
	
	public void exibirMensagemSaida() {
        System.out.println("\n################# Sistema encerrado #################");
    }
	
	public void aguardarTecla() {
        System.out.print("\nPressione Enter para continuar...");
        sc.nextLine();
    }
	
	public void fechar() {
        sc.close();
    }	
	
}
